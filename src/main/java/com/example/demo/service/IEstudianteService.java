package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);

	public List<Estudiante> buscarTodos();

	public Estudiante buscarPorCedula(String cedula);
}
