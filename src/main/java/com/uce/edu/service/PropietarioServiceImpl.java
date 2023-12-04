package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	
	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return iPropietarioRepository.seleccionar(cedula);
	}

	@Override
	public void guardar(Propietario propietario) {
		this.iPropietarioRepository.insertar(propietario);
		
	}

	@Override
	public void actualizar(Propietario propietario) {
		iPropietarioRepository.actualizar(propietario);
		
	}

	@Override
	public void eliminar(String cedula) {
		this.iPropietarioRepository.eliminar(cedula);
		
	}

}
