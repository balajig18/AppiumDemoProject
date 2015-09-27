package com.home.exception;



public class PageNotLoadedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1649057383384686552L;

	public PageNotLoadedException(){
		super();
	}
	public PageNotLoadedException(String exception)
	{
		super(exception);
	}
}
