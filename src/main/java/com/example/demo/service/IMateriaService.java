package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {

	public void agregar(Materia materia);

	public Materia buscarPorCodigo(String codigo);
	
	public Materia buscarPorId(Integer id); 
	
	public List<Materia> buscarTodos();
}
