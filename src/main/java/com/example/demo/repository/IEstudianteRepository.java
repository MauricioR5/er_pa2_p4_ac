package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertar(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public List<Estudiante> buscarTodos();
}
