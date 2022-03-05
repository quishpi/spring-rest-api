package ec.edu.insteclrg.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.domain.Test;
import ec.edu.insteclrg.service.TestService;

@RestController
@RequestMapping("/api/v1.0/test")
public class TestController {

	@Autowired
	TestService testService;

	@PostMapping(path = "/guardar")
	public String guardar(@RequestBody Test test) {
		testService.guardar(test);
		return "Ok";
	}

	@PutMapping(path = "actualizar")
	public String actualizar(@RequestBody Test test) {
		testService.actualizar(test);
		return "Ok";
	}

	@GetMapping(path = "/listar")
	public @ResponseBody List<Test> listar() {
		return testService.buscarTodo(new Test());

	}

	@GetMapping(path = "/buscar/{nombre}")
	public @ResponseBody Test buscar(@PathVariable String nombre) {
		return testService.buscarPorNombre(nombre);
	}

	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		Test cliente = new Test();
		cliente.setId(id);
		testService.eliminar(cliente);
	}

}
