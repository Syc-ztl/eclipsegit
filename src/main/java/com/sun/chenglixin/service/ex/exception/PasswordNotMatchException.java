package com.sun.chenglixin.service.ex.exception;
/**
 * 密码错误
 * @author lenveo
 *
 */
public class PasswordNotMatchException extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
		
}
