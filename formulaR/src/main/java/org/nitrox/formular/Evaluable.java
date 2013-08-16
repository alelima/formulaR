/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nitrox.formular;

import java.math.BigDecimal;

/**
 *
 * @author Alessandro Lima <alessandro.lima@serpro.gov.br>
 */
public interface Evaluable {
    
    public String getDescription();
    
    public void setDescription(String description);
                
    public BigDecimal getValue();
    
    public void setValue(BigDecimal value);
}
