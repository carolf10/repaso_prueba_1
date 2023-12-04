package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	private static List<Vehiculo> base = new ArrayList<>();
	
	@Override
	public Vehiculo seleccionar(String placa) {
		for (Vehiculo vehiculo:base) {
			if(vehiculo.getPlaca().equals(placa)) {
				Vehiculo vcl = new Vehiculo();
				vcl.setMarca(vehiculo.getMarca());
				vcl.setPlaca(vehiculo.getPlaca());
				vcl.setPrecio(vehiculo.getPrecio());
				vcl.setTipo(vehiculo.getTipo());
				return vcl;
			}
		}
		return null;
	}
	
	public Vehiculo seleccionarEliminar(String placa) {
		for (Vehiculo vehiculo:base) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}

	//recordar uso la base y introduzco el objeto
	@Override
	public void insertar(Vehiculo vehiculo) {
		base.add(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		Vehiculo vehiculo= this.seleccionarEliminar(placa);
		base.remove(vehiculo);
	}
	

}
