package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {

}
