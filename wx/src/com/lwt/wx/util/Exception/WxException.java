package com.lwt.wx.util.Exception;

public class WxException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WxException() {
		super();
	}

	public WxException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WxException(String message, Throwable cause) {
		super(message, cause);
	}

	public WxException(String message) {
		super(message);
	}

	public WxException(Throwable cause) {
		super(cause);
	}
   
}
