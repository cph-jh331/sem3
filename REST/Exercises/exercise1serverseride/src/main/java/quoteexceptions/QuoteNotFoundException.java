/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoteexceptions;

/**
 *
 * @author Bloch
 */
public class QuoteNotFoundException extends RuntimeException {

    public QuoteNotFoundException(String msg)
    {
        super(msg);
    }
}
