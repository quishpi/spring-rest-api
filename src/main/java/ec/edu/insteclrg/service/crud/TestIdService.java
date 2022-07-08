package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.TestId;
import ec.edu.insteclrg.dto.TestIdDTO;
import ec.edu.insteclrg.persistence.TestIdRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TestIdService extends GenericCrudServiceImpl<TestId, TestIdDTO> {

	@Autowired
	private TestIdRepository repository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<TestId> find(TestIdDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TestIdDTO mapToDto(TestId domain) {
		return modelMapper.map(domain, TestIdDTO.class);
	}

	@Override
	public TestId mapToDomain(TestIdDTO dto) {
		return modelMapper.map(dto, TestId.class);
	}
}
