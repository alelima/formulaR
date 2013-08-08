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
public interface ScriptRunner {
    
    public BigDecimal eval(BigDecimal ... values);    
    
    public Integer eval(Integer ... values);
}
