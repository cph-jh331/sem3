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

    public IdIsNotIntegerException()
    {
    }

    public IdIsNotIntegerException(String msg)
    {
        super(msg);
    }
}
