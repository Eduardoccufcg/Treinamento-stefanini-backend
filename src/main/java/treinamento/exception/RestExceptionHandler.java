package treinamento.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroCustomizado> handleAnyException(Exception ex, WebRequest request) {
		ErroCustomizado errorMessage = new ErroCustomizado(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<ErroCustomizado> CategoriaNaoEncontrada(Exception ex, WebRequest request) {
		ErroCustomizado errorMessage = new ErroCustomizado(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
