package com.uce.edu.service;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

public interface IMatriculaService {
	public Matricula buscar (String cedula, String placa);
	public void guardar (Matricula matricula);
	public void actualizar(Matricula matricula);
	public void eliminar (String cedula, String placa);
	
	//el nombre calcular si se usa se tendra que retonar un valor 
	public void generarMatricula(Propietario propietario, Vehiculo vehiculo);


}
