/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nitrox.formular;

import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author Alessandro Lima <alessandro.lima@serpro.gov.br>
 */
public interface ScriptRunner {
    
    public BigDecimal eval(String expression, Set<Evaluable> evaluables);    
    
    //public Integer eval(Integer ... values);
}
