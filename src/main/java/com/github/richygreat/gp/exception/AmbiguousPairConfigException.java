package com.github.richygreat.gp.exception;

public class AmbiguousPairConfigException extends RuntimeException {
	private static final long serialVersionUID = -7943374533385568297L;

	public AmbiguousPairConfigException(String message) {
		super(message);
	}

	public AmbiguousPairConfigException(String message, Throwable cause) {
		super(message, cause);
	}
}
