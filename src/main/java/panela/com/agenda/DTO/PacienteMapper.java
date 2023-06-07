package panela.com.agenda.DTO;

import java.util.ArrayList;
import java.util.List;


import panela.com.agenda.entity.Paciente;

public class PacienteMapper {
	public static Paciente toPaciente(PacienteDTO pacienteDTO) {
		Paciente paciente = new Paciente();
		paciente.setNome(pacienteDTO.getNome());
		paciente.setSobrenome(pacienteDTO.getSobrenome());
		paciente.setEmail(pacienteDTO.getEmail());
		paciente.setCpf(pacienteDTO.getCpf());
		return paciente;
	}
	
	public static PacienteDTO toPacienteDTO(Paciente paciente) {
		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO.setNome(paciente.getNome());
		pacienteDTO.setSobrenome(paciente.getSobrenome());
		pacienteDTO.setEmail(paciente.getEmail());
		pacienteDTO.setCpf(paciente.getCpf());
		return pacienteDTO;
	}
	
	public static List<PacienteDTO> toPacienteList(List<Paciente> pacientes){
		List<PacienteDTO> response = new ArrayList<PacienteDTO>();
		for(Paciente paciente : pacientes) {
			response.add(toPacienteDTO(paciente));
		} return response;
		
		
	}

	

	
}
