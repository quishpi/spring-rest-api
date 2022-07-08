package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Cabecera;

@Repository
public interface CabeceraRepository extends JpaRepository<Cabecera, Long> {

}
