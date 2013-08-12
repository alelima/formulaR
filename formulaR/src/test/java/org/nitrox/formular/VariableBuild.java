/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nitrox.formular;

import java.math.BigDecimal;

/**
 *
 * @author Alessandro Lima (alessandro.lima@serpro.gov.br)
 */
public class VariableBuild {
     private String name;

    private BigDecimal value;
    
    public VariableBuild withNameAndWithValue(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
        return this;
    }
    
    public Variable build() {
        Variable var = new Variable();
        var.setName(name);
        var.setValue(value);
        
        return var;
    }

}
