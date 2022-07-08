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

import ec.edu.insteclrg.domain.TestCode;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.TestCodeDTO;
import ec.edu.insteclrg.service.crud.TestCodeService;

@RestController
@RequestMapping("/api/v1.0/testcode")
public class TestCodeController {

	@Autowired
	TestCodeService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TestCodeDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody TestCodeDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<TestCodeDTO> list = service.findAll(new TestCodeDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TestCodeDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{code}")
	public ResponseEntity<Object> find(@PathVariable String code) {
		TestCodeDTO dto = new TestCodeDTO();
		dto.setCode(code);
		Optional<TestCode> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<TestCode> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
