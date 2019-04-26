package com.myproject.product.exception;

public class FeedbackException extends Exception{

	public FeedbackException(String message)
	{
		super("FeedbackException-"+message);
	}
	
	public FeedbackException(String message, Throwable cause)
	{
		super("FeedbackException-"+message,cause);
	}
}
