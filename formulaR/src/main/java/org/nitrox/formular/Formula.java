/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nitrox.formular;

import com.google.common.base.Splitter;
import java.math.BigDecimal;
import java.util.HashSet;

/**
 *
 * @author Alessandro Lima (alessandrolima@gmail.com)
 */
class Formula {

    private HashSet<Variable> formulaVariables = new HashSet<Variable>();
    private String expression;
    private ScriptRunner scriptRunner;
    private String defaultPatternOperators = "\\+|-|\\*|/";

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
    
    public boolean isValid(String expression) {
        HashSet<Variable> variables = new HashSet<Variable>();
        for (String variablesName : Splitter.onPattern(defaultPatternOperators).omitEmptyStrings().split(expression)) {
            Variable variable = new Variable();
            variable.setName(variablesName.trim());
            variable.setValue(new BigDecimal("1.00"));
            variables.add(variable);
        }
        
        try {
            scriptRunner.eval(expression, variables);
            return true;
        } catch (Exception e) {
            //
        }
        return false;
    }
    
    public boolean isValidForPattern(String expression, String pattern) {
        defaultPatternOperators = defaultPatternOperators + "|" + pattern;
        return this.isValid(expression);
    }
}
