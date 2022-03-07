package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.TestId;

@Repository
public interface TestIdRepository extends JpaRepository<TestId, Long> {

}
