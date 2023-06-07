package panela.com.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import panela.com.agenda.DTO.PacienteDTO;
import panela.com.agenda.DTO.PacienteMapper;
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
	public ResponseEntity<PacienteDTO> salvar(@RequestBody PacienteDTO pacienteDTO){
		Paciente paciente = PacienteMapper.toPaciente(pacienteDTO);
		Paciente pacienteSalvo = ps.salvar(paciente);
		PacienteDTO pacienteDTOSalvo = PacienteMapper.toPacienteDTO(pacienteSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDTOSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> listar(){
		List<Paciente> pacientes = ps.listar();
		List<PacienteDTO> pacienteSalvo = PacienteMapper.toPacienteList(pacientes);
		return ResponseEntity.status(HttpStatus.OK).body(pacienteSalvo);
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<PacienteDTO> exibir(@PathVariable String cpf){	
		Optional<Paciente> optPaciente = ps.exibir(cpf);
		if(optPaciente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(PacienteMapper.toPacienteDTO(optPaciente.get()));
	}
	
	@PutMapping
	public ResponseEntity<Paciente> editar(@RequestBody Paciente paciente){
		Paciente pacienteEditado = ps.alterar(paciente);
		return ResponseEntity.status(HttpStatus.OK).body(pacienteEditado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		ps.apagar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
