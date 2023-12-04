package com.uce.edu.service;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietarioService {
	public Propietario buscar (String cedula);
	public void guardar (Propietario propietario);
	public void actualizar(Propietario propietario);
	public void eliminar (String cedula); //este tambien se puese llamar borrar

}
