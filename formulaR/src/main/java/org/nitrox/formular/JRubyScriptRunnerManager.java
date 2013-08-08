package org.nitrox.formular;


import java.math.BigDecimal;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class JRubyScriptRunnerManager {

    private ScriptEngine engine;
    
    private String defautScript;
    
    private static final String filename = "src/main/ruby/formula_operations_definition.rb";

    public JRubyScriptRunnerManager() throws ScriptException {
        System.setProperty("org.jruby.embed.localcontext.scope", "threadsafe");
        System.setProperty("org.jruby.embed.localvariable.behavior", "transient");
        String scriptFile = System.getProperty("user.dir") + "/" + filename;
        System.out.println(scriptFile);
        
        ScriptEngineManager factory = new ScriptEngineManager();
        this.engine = factory.getEngineByName("jruby");
        //context = engine.getContext();
        defautScript = "class Java::JavaMath::BigDecimal\n"
                + "	def + (n)\n"
                + "		if n.kind_of?(Numeric)\n"
                + "			self.add(Java::JavaMath::BigDecimal.new(n))\n"
                + "		elsif n.is_a?(Java::JavaMath::BigDecimal)\n"
                + "			self.add(n)\n"
                + "		end\n"
                + "	end\n"
                + "	def - (n)\n"
                + "		if n.kind_of?(Numeric)\n"
                + "			self.subtract(Java::JavaMath::BigDecimal.new(n))\n"
                + "		elsif n.is_a?(Java::JavaMath::BigDecimal)\n"
                + "			self.subtract(n)\n"
                + "		end\n"
                + "	end\n"
                + "	def * (n)\n"
                + "		if n.kind_of?(Numeric)\n"
                + "			self.multiply(Java::JavaMath::BigDecimal.new(n))\n"
                + "		elsif n.is_a?(Java::JavaMath::BigDecimal)\n"
                + "			self.multiply(n)\n"
                + "		end\n"
                + "	end\n"
                + "	def / (n)\n"
                + "		if n.kind_of?(Numeric)\n"
                + "			self.divide(Java::JavaMath::BigDecimal.new(n))\n"
                + "		elsif n.is_a?(Java::JavaMath::BigDecimal)\n"
                + "			self.divide(n)\n"
                + "		end\n"
                + "	end\n"
                + "end\n"
                + "def sqrt(value)\n"
                + "	Math.sqrt(value)\n"
                + "end\n";
    }

    private Object evalJavaBigDecimal(BigDecimal valor1, BigDecimal valor2) {
        return valor1.subtract(valor2);
    }

    public Object evalJavaScript(BigDecimal valor1, BigDecimal valor2) throws ScriptException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("valor1", valor1);
        engine.put("valor2", valor2);
        engine.eval("valor3 = valor1 - valor2;");
        return engine.get("valor3");
    }

    public Object evalJavaDouble(BigDecimal valor1, BigDecimal valor2) throws ScriptException {
        return valor1.doubleValue() - valor2.doubleValue();
    }

    public Object evalRuby(BigDecimal valor1, BigDecimal valor2) throws ScriptException {
        Bindings bindings = new SimpleBindings();
        bindings.put("valor1", valor1);
        bindings.put("valor2", valor2);
        //bindings.put("valor3", new BigDecimal("0.00"));
        BigDecimal resultado = (BigDecimal) engine.eval(defautScript + "valor1 - valor2 + sqrt(4) + 2", bindings);
        return resultado;
    }
}
