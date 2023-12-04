package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class RepasoPrueba1Application implements CommandLineRunner {
	
	@Autowired
	private IMatriculaService iMatriculaService;
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IPropietarioService iPropietarioService;

	public static void main(String[] args) {
		SpringApplication.run(RepasoPrueba1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1. Creacion de vehiculo
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Toyota");
		vehiculo.setPlaca("DFG-4565");
		vehiculo.setPrecio(new BigDecimal(50000));
		vehiculo.setTipo("pesado");
		this.iVehiculoService.guardar(vehiculo);
		System.out.println("Datos del vehiculo: \n" + vehiculo);
		
		System.out.println("Se actulizaran los datos de vehiculo: ");
		vehiculo.setMarca("Chevrolet");
		vehiculo.setPrecio(new BigDecimal(45000));
		this.iVehiculoService.actualizar(vehiculo);
		System.out.println(vehiculo);
		
		//2. Creacion del  propietario
		Propietario propietario = new Propietario();
		propietario.setApellido("Velez");
		propietario.setCedula("1753545657");
		propietario.setFechaNacimiento(LocalDateTime.of(1978, 12, 05, 3, 54));
		propietario.setNombre("Yolanda");
		this.iPropietarioService.guardar(propietario);
		
		System.out.println("Datos del propietario: \n" + propietario);
		
		//3. Creacion de la matricula
		this.iMatriculaService.generarMatricula(propietario, vehiculo);
		
	}

}
