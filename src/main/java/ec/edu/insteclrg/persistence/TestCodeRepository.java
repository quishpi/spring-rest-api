package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.TestCode;

@Repository
public interface TestCodeRepository extends JpaRepository<TestCode, Long> {

}
