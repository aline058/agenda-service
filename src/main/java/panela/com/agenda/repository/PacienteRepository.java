package panela.com.agenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import panela.com.agenda.entity.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	Optional<Paciente> findByCpf(String cpf);
	
	

	boolean existsDistinctPeopleByCpfOrEmail(String cpf, String email);
	

}
