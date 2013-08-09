package org.nitrox.formular;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.script.ScriptException;
import org.jruby.embed.LocalContextScope;
import org.jruby.embed.LocalVariableBehavior;
import org.jruby.embed.ScriptingContainer;

public class JRubyScriptRunnerManager {

    //private ScriptEngine engine;
    private ScriptingContainer ruby;
    private static String defautScript;
    private String formulaScript;
    private static final String filename = "src/main/ruby/formulaR.rb";

    public JRubyScriptRunnerManager() throws ScriptException, IOException {

        if (defautScript == null) {
            String path = System.getProperty("user.dir") + "/" + filename;
            defautScript = Files.toString(new File(path), Charsets.UTF_8);
        }

        ruby = new ScriptingContainer(LocalContextScope.THREADSAFE, LocalVariableBehavior.TRANSIENT);
    }

    public BigDecimal eval() {
              
        BigDecimal valor1 = new BigDecimal("20.000006");
        BigDecimal valor2 = new BigDecimal("10.000009");
        System.out.println(valor1.divide(valor2, RoundingMode.UP));

        formulaScript = defautScript + "valor1 + valor2";

        System.out.println("@########################@");
        ruby.put("valor1", valor1);
        ruby.put("valor2", valor2);
        BigDecimal resultado = (BigDecimal) ruby.runScriptlet(formulaScript);

        System.out.println(resultado);

        return resultado;
    }
}
