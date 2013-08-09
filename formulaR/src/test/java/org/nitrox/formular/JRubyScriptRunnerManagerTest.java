/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nitrox.formular;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.math.BigDecimal;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.SimpleBindings;
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
    //@Test
   /* public void testEvalRuby() throws Exception {
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
        fail("The test case is a prototype.");
    } */
    
    //@Test
   /* public void testRunner() throws Exception {
        JRubyScriptRunnerManager ruby = new JRubyScriptRunnerManager();
        ScriptEngine engine = ruby.getEngine();
        
        BigDecimal valor1 = new BigDecimal("20.0000000007");
        BigDecimal valor2 = new BigDecimal("10.0000089765");        
        Bindings bindings = new SimpleBindings();
        bindings.put("valor1", valor1);
        bindings.put("valor2", valor2);
        
        System.out.println("ANTES DA OPERACAO: ");
        System.out.println(System.currentTimeMillis());
        BigDecimal resultado1 = (BigDecimal) engine.eval(ruby.getDefautScript1() + "valor1 - valor2 + sqrt(4) + 2", bindings);
        System.out.println(System.currentTimeMillis());
        //BigDecimal resultado2 = (BigDecimal) engine.eval(ruby.getDefautScript2() + "valor1 - valor2 + sqrt(4) + 2", bindings);
                        
        System.out.println("Resultado 1: " + resultado1);
        //System.out.println("Resultado 2: " + resultado2);
        
        
    } */
    
    @Test
    public void testRunner2() throws Exception {
        JRubyScriptRunnerManager jruby = new JRubyScriptRunnerManager();
        jruby.eval();        
    }
}