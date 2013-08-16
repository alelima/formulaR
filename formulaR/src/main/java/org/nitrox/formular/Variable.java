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
public class Variable implements Evaluable{
    
    private String description;

    private BigDecimal value;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }    
    
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }

}
