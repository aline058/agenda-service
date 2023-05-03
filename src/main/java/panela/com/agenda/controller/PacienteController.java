package panela.com.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import panela.com.agenda.entity.Paciente;
import panela.com.agenda.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

	private final PacienteService ps;
	@Autowired
	public PacienteController (PacienteService ps) {
		this.ps = ps;
	}
	
	
	@PostMapping
	public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente){
		Paciente pacienteSalvo = ps.salvar(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> pacientes = ps.listar();
		return ResponseEntity.status(HttpStatus.OK).body(pacientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> exibir(@PathVariable Long id){
		Optional<Paciente> optPaciente = ps.exibir(id);
		if(optPaciente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(optPaciente.get());
	}
	
	
	
	
}
