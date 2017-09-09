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
public class CannotEditException extends RuntimeException {

    public CannotEditException()
    {
    }

    public CannotEditException(String msg)
    {
        super(msg);
    }
}
