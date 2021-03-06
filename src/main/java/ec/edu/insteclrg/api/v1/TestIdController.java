package ec.edu.insteclrg.api.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.domain.TestId;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.TestIdDTO;
import ec.edu.insteclrg.service.crud.TestIdService;

@RestController
@RequestMapping("/api/v1.0/testid")
public class TestIdController {

	@Autowired
	TestIdService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TestIdDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody TestIdDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<TestIdDTO> list = service.findAll(new TestIdDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TestIdDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		TestIdDTO dto = new TestIdDTO();
		dto.setId(id);
		Optional<TestId> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<TestId> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
