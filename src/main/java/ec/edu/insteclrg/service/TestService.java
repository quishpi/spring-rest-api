package ec.edu.insteclrg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Test;
import ec.edu.insteclrg.persistence.TestRepository;

@Service
public class TestService extends GenericCRUDServiceImpl<Test, Integer> {

	@Autowired
	TestRepository clienteRepository;

	@Override
	public Optional<Test> buscar(Test entity) {
		return clienteRepository.findById(entity.getId());
	}

	public Test buscarPorNombre(String name) {
		return clienteRepository.findByName(name);
	}

}
