package ec.edu.insteclrg.api.v1;

import java.util.List;
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

import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.TestCodeDTO;
import ec.edu.insteclrg.service.crud.TestCodeService;

@RestController
@RequestMapping("/api/v1.0/testcode")
public class TestCodeController {

	@Autowired
	TestCodeService service;

	@PostMapping(path = "/guardar")
	public ResponseEntity<Object> guardar(@RequestBody TestCodeDTO dto) {
		service.guardar(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping(path = "/actualizar")
	public ResponseEntity<Object> actualizar(@RequestBody TestCodeDTO dto) {
		service.actualizar(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<Object> listar() {
		List<TestCodeDTO> list = service.buscarTodo(new TestCodeDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TestCodeDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{codigo}/buscar")
	public ResponseEntity<Object> buscar(@PathVariable String codigo) {
		TestCodeDTO dto = new TestCodeDTO();
		dto.setCodigo(codigo);
		List<TestCodeDTO> list = service.buscarTodo(dto);
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TestCodeDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

}
