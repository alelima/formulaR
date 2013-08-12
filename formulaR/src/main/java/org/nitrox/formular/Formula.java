/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nitrox.formular;

import java.math.BigDecimal;
import java.util.HashSet;
import org.nitrox.formular.JRubyScriptRunnerManager;
import org.nitrox.formular.Variable;

/**
 *
 * @author Alessandro Lima (alessandrolima@gmail.com)
 */
class Formula {

    private HashSet<Variable> formulaVariables = new HashSet<Variable>();
    private String expression;
    private ScriptRunner scriptRunner;

    public Formula() {
        this.scriptRunner = new JRubyScriptRunnerManager();
    }
    
    void putVar(Variable... variables) {
        for (int i = 0; i < variables.length; i++) {
            formulaVariables.add(variables[i]);
        }
    }
    
    void putVar(HashSet<Variable> variables) {
        this.formulaVariables = variables;
    }

    public String getExpression() {
        return expression;
    }
    
    void setExpression(String expression) {
        this.expression = expression;
    }    
    
    public BigDecimal eval() {        
        return scriptRunner.eval(this.getExpression(), this.formulaVariables);
    }
}
