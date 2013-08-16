package org.nitrox.formular;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import org.jruby.embed.LocalContextScope;
import org.jruby.embed.LocalVariableBehavior;
import org.jruby.embed.ScriptingContainer;

public class JRubyScriptRunnerManager implements ScriptRunner {

    //private ScriptEngine engine;
    private ScriptingContainer ruby;
    private static String defautScript;
    private String formulaScript;
    private static final String filename = "src/main/ruby/formulaR.rb";
    
    //I don't have proud of this, but it resolves the initial Fixnum/Float convert problem.
    private String initExpression = "Java::JavaMath::BigDecimal.new(0.00) +";

    public JRubyScriptRunnerManager() {

        try {
            if (defautScript == null) {
                String path = System.getProperty("user.dir") + "/" + filename;
                defautScript = Files.toString(new File(path), Charsets.UTF_8);
            }
            ruby = new ScriptingContainer(LocalContextScope.THREADSAFE, LocalVariableBehavior.TRANSIENT);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }      
    }

    @Override
    public BigDecimal eval(String expression, Set<Evaluable> evaluables) {
        expression = initExpression + expression;
        formulaScript = defautScript + expression;        
        
        for (Evaluable evaluable : evaluables) {
            ruby.put(evaluable.getDescription(), evaluable.getValue());
        }
        
        return (BigDecimal) ruby.runScriptlet(formulaScript);
    }   
}
