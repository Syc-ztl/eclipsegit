package com.sun.chenglixin.service.ex.exception;
/**
 * 验证码输入错误
 * @author lenveo
 *
 */
public class CodeCheckOutException extends  ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeCheckOutException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CodeCheckOutException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CodeCheckOutException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CodeCheckOutException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CodeCheckOutException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
