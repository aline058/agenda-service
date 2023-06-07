package panela.com.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import panela.com.agenda.entity.Paciente;
import panela.com.agenda.exception.PacienteJaCadastrado;
import panela.com.agenda.exception.PacienteNaoEncontrado;
import panela.com.agenda.repository.PacienteRepository;

@Service
public class PacienteService {
	
	
	private final PacienteRepository pr;
	@Autowired
	public PacienteService(PacienteRepository pr) {
		this.pr = pr;
	}
	
	public Paciente salvar(Paciente paciente) {
		if(pr.existsDistinctPeopleByCpfOrEmail(paciente.getCpf(), paciente.getEmail())) {
			throw new PacienteJaCadastrado("Paciente já cadastrado!");
		}
		return pr.save(paciente);
	}
	
	
	public List<Paciente> listar(){
		return pr.findAll();
	}
	
	public Optional<Paciente> exibir(String cpf) {
		return pr.findByCpf(cpf);
	}
	
	public Paciente alterar(Paciente paciente) {
		if(!pr.existsById(paciente.getId())||!pr.existsByCpf(paciente.getCpf())) {
			throw new PacienteNaoEncontrado("Paciente não encontrado");
		}
		return pr.save(paciente);
	}
	
	public void apagar(Long id) {
		pr.deleteById(id);
	}
}
