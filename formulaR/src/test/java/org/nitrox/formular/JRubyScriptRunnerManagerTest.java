/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nitrox.formular;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alessandro Lima <alessandro.lima@serpro.gov.br>
 */
public class JRubyScriptRunnerManagerTest {
    
    public JRubyScriptRunnerManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of evalRuby method, of class JRubyScriptRunnerManager.
     */
    @Test
    public void testEvalRuby() throws Exception {
        System.out.println("evalRuby");
        BigDecimal valor1 = new BigDecimal("20");
        BigDecimal valor2 = new BigDecimal("10");
        JRubyScriptRunnerManager instance = new JRubyScriptRunnerManager();
        BigDecimal resultado = (BigDecimal) instance.evalRuby(valor1, valor2); 
        System.out.println(resultado);
        fail("The test case is a prototype.");
        /*BigDecimal valor1 = null;
        BigDecimal valor2 = null;
        JRubyScriptRunnerManager instance = new JRubyScriptRunnerManager();
        Object expResult = null;
        Object result = instance.evalRuby(valor1, valor2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
}