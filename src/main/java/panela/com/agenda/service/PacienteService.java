package panela.com.agenda.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import panela.com.agenda.entity.Paciente;
import panela.com.agenda.repository.PacienteRepository;

@Service
@Transactional
public class PacienteService {
	
	
	private final PacienteRepository pr;
	@Autowired
	public PacienteService(PacienteRepository pr) {
		this.pr = pr;
	}
	
	public Paciente salvar(Paciente paciente) {
		return pr.save(paciente);
	}
	
	public List<Paciente> listar(){
		return pr.findAll();
	}
	
	public Paciente exibir(Long id) {
		return pr.findById(id).get();
	}
	
	public void apagar(Long id) {
		pr.deleteById(id);
	}
}
