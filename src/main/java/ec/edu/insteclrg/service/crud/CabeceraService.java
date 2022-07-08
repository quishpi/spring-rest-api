package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Cabecera;
import ec.edu.insteclrg.dto.CabeceraDTO;
import ec.edu.insteclrg.persistence.CabeceraRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class CabeceraService extends GenericCrudServiceImpl<Cabecera, CabeceraDTO> {

	@Autowired
	private CabeceraRepository repository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Cabecera> find(CabeceraDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public CabeceraDTO mapToDto(Cabecera domain) {
		return modelMapper.map(domain, CabeceraDTO.class);
	}

	@Override
	public Cabecera mapToDomain(CabeceraDTO dto) {
		return modelMapper.map(dto, Cabecera.class);
	}
}
