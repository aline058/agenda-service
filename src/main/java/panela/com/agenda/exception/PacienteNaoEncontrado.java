package panela.com.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class PacienteNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PacienteNaoEncontrado(String mensagem) {
		super(mensagem);
	}

}
