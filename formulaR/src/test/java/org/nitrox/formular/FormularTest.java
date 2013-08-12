/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nitrox.formular;

import java.math.BigDecimal;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Alessandro Lima (alessandrolima@gmail.com)
 */
public class FormularTest {

    @Test
    public void shouldAddVariablesAndEvalAreaFormula() {
        VariableBuild varBuild = new VariableBuild();
        
        Variable height = varBuild.withNameAndWithValue("heigth", new BigDecimal("9.04")).build();
        Variable width = varBuild.withNameAndWithValue("width", new BigDecimal("7.07")).build();
        
        Formula formula = new Formula();
        formula.putVar(height, width);        
        formula.setExpression("heigth * width");
        
        BigDecimal result = formula.eval();
        
        assertEquals(new BigDecimal("63.9128"), result);        
    }
    
    @Test
    public void shouldEvalAreaFormulaWithIntegerNumbers() {
        VariableBuild varBuild = new VariableBuild();
        
        Variable height = varBuild.withNameAndWithValue("heigth", new BigDecimal("9.04")).build();
        Variable width = varBuild.withNameAndWithValue("width", new BigDecimal("7.07")).build();
        
        Formula formula = new Formula();
        formula.putVar(height, width);        
        formula.setExpression("heigth * width + 2");
        
        BigDecimal result = formula.eval();
        
        assertEquals(new BigDecimal("65.9128"), result);        
    }
    
    @Test
    public void shouldEvalAreaFormulaWithFloatNumbers() {
        VariableBuild varBuild = new VariableBuild();
        
        Variable height = varBuild.withNameAndWithValue("heigth", new BigDecimal("9.04")).build();
        Variable width = varBuild.withNameAndWithValue("width", new BigDecimal("7.07")).build();
        
        Formula formula = new Formula();
        formula.putVar(height, width);        
        formula.setExpression("heigth * width + 2.01");
        
        BigDecimal result = formula.eval();
        
        assertEquals(new BigDecimal("65.9228"), result);        
    }
    
    @Test
    public void shouldEvalDivision() {
        VariableBuild varBuild = new VariableBuild();
        
        Variable height = varBuild.withNameAndWithValue("heigth", new BigDecimal("9.04")).build();
        Variable width = varBuild.withNameAndWithValue("width", new BigDecimal("7.07")).build();
        
        Formula formula = new Formula();
        formula.putVar(height, width);        
        formula.setExpression("heigth / width");
        
        BigDecimal result = formula.eval();
        
        assertEquals(new BigDecimal("1.27864215"), result);        
    }
    
    //@Test
    public void shouldEvalBooleanToFormula() {
        VariableBuild varBuild = new VariableBuild();
        
        Variable area = varBuild.withNameAndWithValue("area", new BigDecimal("5.01")).build();
        Variable height = varBuild.withNameAndWithValue("heigth", new BigDecimal("9.04")).build();
        Variable width = varBuild.withNameAndWithValue("width", new BigDecimal("7.07")).build();
        
        Formula formula = new Formula();
        formula.putVar(area, height, width);        
        formula.setExpression("area = variable2 + variable3");
        
        BigDecimal result = formula.eval();
        
        assertEquals(new BigDecimal("21.12"), result);        
    }
    
}
