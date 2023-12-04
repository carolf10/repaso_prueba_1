package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Override
	public Matricula buscar(String cedula, String placa) {
		// TODO Auto-generated method stub
		return iMatriculaRepository.seleccionar(cedula, placa);
	}

	@Override
	public void guardar(Matricula matricula) {
		this.iMatriculaRepository.insertar(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		this.iMatriculaRepository.actualizar(matricula);

	}

	@Override
	public void eliminar(String cedula, String placa) {
		this.iMatriculaRepository.eliminar(cedula, placa);
	}

	@Override
	public void generarMatricula(Propietario propietario, Vehiculo vehiculo) {
		//el valor para realizar los calculos
		BigDecimal valorMatricula= null;
		/*para la comparacion uso null el == para igualar dado que con el equals se requiere que los valores sean lo mismo
		 *llamo al metodo buscar dado que aqui realizo una comparacion de existencia en la base*/
		
		if(this.buscar(propietario.getCedula(), vehiculo.getPlaca()) == null) {
			if(vehiculo.getTipo().equals("liviano")) {
				//este el valor del voy a usar o plantea el ejercicio
				BigDecimal liviano= new BigDecimal(0.10);
				/*el metodo multiply se encarga de multiplar los valores del BigDecimal
				 * llamo el valor regitrado en vehiculo del precio y guardo el valor actualizado en valor matricula*/
				valorMatricula = vehiculo.getPrecio().multiply(liviano);
				System.out.println("Valor de matricula para vehiculo liviano: " + valorMatricula);
			}else if (vehiculo.getTipo().equals("pesado")) {
				BigDecimal pesado = new BigDecimal(0.15);
				valorMatricula= vehiculo.getPrecio().multiply(pesado);
				System.out.println("Valor de matricula para vehiculo pesado: " + valorMatricula);
			}else if (valorMatricula.compareTo(new BigDecimal(2000)) == 1) { 
				/*el compareTo compare entre BigDecimal, cuando debe ser valores iguales se usa el 0, cuando debe ser el valor
				 *mayor a el 1 y cuando debe ser menor -1*/
				BigDecimal descuento = new BigDecimal(0.07);
				valorMatricula= vehiculo.getPrecio().subtract(descuento);
				System.out.println("El valor de la matricula con el descuento aplicado: " + valorMatricula);
			}
		} else {
			System.out.println("La matricula ya se encuentra registrada");
		}
		
		//Creacion de la matricula con los valores del propietario, vehiculo y valor calculado de valor matricula
		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setPropietario(propietario);
		matricula.setValorMatricula(valorMatricula);
		matricula.setVehiculo(vehiculo);
		this.guardar(matricula);
		
		System.out.println("Datos de la matricula: \n" + matricula);
	}

}
