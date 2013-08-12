/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nitrox.formular.exception;

/**
 *
 * @author Alessandro Lima (alessandrolima@gmail.com)
 */
public class NotValidExpressionException extends RuntimeException{
    
    public NotValidExpressionException(String message) {
        super(message);
    }
    
    public NotValidExpressionException (Throwable cause) {
        super(cause);
    }
    
    public NotValidExpressionException (String message, Throwable cause) {
        super(message, cause);
    }
}
