/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nitrox.formular;

import java.math.BigDecimal;

/**
 *
 * @author Alessandro Lima (alessandrolima@gmail.com)
 */
class Variable {
    
    private String name;

    private BigDecimal value;
    
    public String getName() {
        return name;
    }
    
    void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }    
    
    void setValue(BigDecimal value) {
        this.value = value;
    }

}
