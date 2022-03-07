package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.TestId;
import ec.edu.insteclrg.dto.TestIdDTO;
import ec.edu.insteclrg.persistence.TestIdRepository;
import ec.edu.insteclrg.service.GenericCRUDServiceImpl;

@Service
public class TestIdService extends GenericCRUDServiceImpl<TestId, TestIdDTO> {

	@Autowired
	private TestIdRepository repository;

	@Override
	public TestId mapearDominio(TestIdDTO dtoObject) {
		TestId domain = new TestId();
		domain.setId(dtoObject.getId());
		domain.setName(dtoObject.getNombre());
		return domain;
	}

	@Override
	public TestIdDTO mapearDTO(TestId domainObject) {
		TestIdDTO dto = new TestIdDTO();
		dto.setId(domainObject.getId());
		dto.setNombre(domainObject.getName());
		return dto;
	}

	@Override
	public Optional<TestId> buscar(TestIdDTO dtoObject) {
		return repository.findById(dtoObject.getId());
	}

}
