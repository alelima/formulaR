package org.nitrox.formular;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class JRubyScriptRunnerManager {

    private ScriptEngine engine;
    
    private String defautScript;
    
    private CompiledScript compiledScript;
    
    private static final String filename = "src/main/ruby/formulaR.rb";

    public JRubyScriptRunnerManager() throws ScriptException, FileNotFoundException {
        System.setProperty("org.jruby.embed.localcontext.scope", "threadsafe");
        System.setProperty("org.jruby.embed.localvariable.behavior", "transient");
        String scriptFile = System.getProperty("user.dir") + "/" + filename;
        System.out.println(scriptFile);
        
        ScriptEngineManager factory = new ScriptEngineManager();
        this.engine = factory.getEngineByName("jruby");
        
        FileReader reader = new FileReader(scriptFile);
        compiledScript = ((Compilable)engine).compile(reader);
        //compiledScript.e
        //defautScript = "script here"
    }

    private Object evalJavaBigDecimal(BigDecimal valor1, BigDecimal valor2) {
        return valor1.subtract(valor2);
    }

    public Object evalRuby(BigDecimal valor1, BigDecimal valor2) throws ScriptException {
        Bindings bindings = new SimpleBindings();
        bindings.put("valor1", valor1);
        bindings.put("valor2", valor2);
        bindings.put("formula", valor2);
        //bindings.put("valor3", new BigDecimal("0.00"));
        BigDecimal resultado = (BigDecimal) engine.eval(defautScript + "valor1 - valor2 + sqrt(4) + 2", bindings);
        return resultado;
    }
}
