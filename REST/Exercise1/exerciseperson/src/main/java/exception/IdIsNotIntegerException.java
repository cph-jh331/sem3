/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Bloch
 */
public class IdIsNotIntegerException extends RuntimeException {

    /**
     * Creates a new instance of <code>IdIsNotIntegerException</code> without
     * detail message.
     */
    public IdIsNotIntegerException()
    {
    }

    /**
     * Constructs an instance of <code>IdIsNotIntegerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IdIsNotIntegerException(String msg)
    {
        super(msg);
    }
}
