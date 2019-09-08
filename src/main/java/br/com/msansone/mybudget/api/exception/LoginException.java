package br.com.msansone.mybudget.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 8853553971942684196L;
}
