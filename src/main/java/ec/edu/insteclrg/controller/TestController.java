package ec.edu.insteclrg.controller;

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
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService clienteService;

	@PostMapping(path = "/guardar")
	public String guardar(@RequestBody Test cliente) {
		clienteService.guardar(cliente);
		return "Ok";
	}

	@PutMapping(path = "actualizar")
	public String actualizar(@RequestBody Test cliente) {
		clienteService.actualizar(cliente);
		return "Ok";
	}

	@GetMapping(path = "/listar")
	public @ResponseBody List<Test> listar() {
		return clienteService.buscarTodo(new Test());

	}

	@GetMapping(path = "/buscar/{nombre}")
	public @ResponseBody Test buscar(@PathVariable String nombre) {
		return clienteService.buscarPorNombre(nombre);

	}

	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		Test cliente = new Test();
		cliente.setId(id);
		clienteService.eliminar(cliente);
	}

}
