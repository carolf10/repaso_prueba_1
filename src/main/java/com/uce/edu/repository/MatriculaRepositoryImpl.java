package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	private static List<Matricula> base = new ArrayList<>();

	@Override
	public Matricula seleccionar(String cedula, String placa) {
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula)
					&& matricula.getVehiculo().getPlaca().equals(placa)) {
				Matricula mcl = new Matricula();
				mcl.setFechaMatricula(matricula.getFechaMatricula());
				mcl.setPropietario(matricula.getPropietario());
				mcl.setValorMatricula(matricula.getValorMatricula());
				mcl.setVehiculo(matricula.getVehiculo());
				return mcl;
			}
		}
		return null;
	}

	public Matricula seleccionarEliminar(String cedula, String placa) {
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula)
					&& matricula.getVehiculo().getPlaca().equals(placa)) {

				return matricula;
			}	
		}
		return null;
	}

	@Override
	public void insertar(Matricula matricula) {
		base.add(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		this.eliminar(matricula.getPropietario().getCedula(), matricula.getVehiculo().getPlaca());
		this.insertar(matricula);

	}

	@Override
	public void eliminar(String cedula, String placa) {
		Matricula matricula= this.seleccionarEliminar(cedula, placa);
		base.remove(matricula);

	}

}
