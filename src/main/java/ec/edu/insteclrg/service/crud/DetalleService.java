package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Detalle;
import ec.edu.insteclrg.dto.DetalleDTO;
import ec.edu.insteclrg.persistence.DetalleRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class DetalleService extends GenericCrudServiceImpl<Detalle, DetalleDTO> {

	@Autowired
	private DetalleRepository repository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Detalle> find(DetalleDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public DetalleDTO mapToDto(Detalle domain) {
		return modelMapper.map(domain, DetalleDTO.class);
	}

	@Override
	public Detalle mapToDomain(DetalleDTO dto) {
		return modelMapper.map(dto, Detalle.class);
	}
}
