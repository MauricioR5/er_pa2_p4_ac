package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {

	public void insertar(Materia materia);
	
	public List<Materia> seleccionarTodo();
	
	public Materia buscarPorCodigo(String codigo);
	
	public Materia buscarPorId(Integer id);
}

