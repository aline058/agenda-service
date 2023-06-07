package panela.com.agenda.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import panela.com.agenda.entity.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	

	boolean existsDistinctPeopleByCpfOrEmail(String cpf, String email);

	boolean existsByCpf(String cpf);

	Optional<Paciente> findByCpf(String cpf);

	void deleteByCpf(String cpf);
	

}
