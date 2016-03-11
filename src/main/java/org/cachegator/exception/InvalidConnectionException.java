/**
 *
 */
package org.cachegator.exception;

/**
 * @author m4ver1k
 * @since  04-Mar-2016
 * 
 */
public class InvalidConnectionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1093467219642184434L;
	/**
	 * 
	 */
	public InvalidConnectionException(String name) {
		super("Invalid Connection Name ->"+name);
	}
}
