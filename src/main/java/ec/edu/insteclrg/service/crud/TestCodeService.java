package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.TestCode;
import ec.edu.insteclrg.dto.TestCodeDTO;
import ec.edu.insteclrg.persistence.TestCodeRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TestCodeService extends GenericCrudServiceImpl<TestCode, TestCodeDTO> {

	@Autowired
	private TestCodeRepository repository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<TestCode> find(TestCodeDTO dto) {
		return repository.findByCode(dto.getCode());
	}

	@Override
	public TestCodeDTO mapToDto(TestCode domain) {
		return modelMapper.map(domain, TestCodeDTO.class);
	}

	@Override
	public TestCode mapToDomain(TestCodeDTO dto) {
		return modelMapper.map(dto, TestCode.class);
	}
}
