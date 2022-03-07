package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.TestCode;
import ec.edu.insteclrg.dto.TestCodeDTO;
import ec.edu.insteclrg.persistence.TestCodeRepository;
import ec.edu.insteclrg.service.GenericCRUDServiceImpl;

@Service
public class TestCodeService extends GenericCRUDServiceImpl<TestCode, TestCodeDTO> {

	@Autowired
	private TestCodeRepository repository;

	@Override
	public TestCode mapearDominio(TestCodeDTO dtoObject) {
		TestCode domain = new TestCode();
		domain.setId(dtoObject.getId());
		domain.setCode(dtoObject.getCodigo());
		domain.setName(dtoObject.getNombre());
		return domain;
	}

	@Override
	public TestCodeDTO mapearDTO(TestCode domainObject) {
		TestCodeDTO dto = new TestCodeDTO();
		dto.setId(domainObject.getId());
		dto.setCodigo(domainObject.getCode());
		dto.setNombre(domainObject.getName());
		return dto;
	}

	@Override
	public Optional<TestCode> buscar(TestCodeDTO dtoObject) {
		return repository.findById(dtoObject.getId());
	}
}
