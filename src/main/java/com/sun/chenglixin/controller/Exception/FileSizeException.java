package com.sun.chenglixin.controller.Exception;

/**
 * 文件大小超过上限
 * @author lenveo
 *
 */
public class FileSizeException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileSizeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
