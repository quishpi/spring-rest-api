package ec.edu.insteclrg.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TestCodeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String codigo;

	private String nombre;

}
