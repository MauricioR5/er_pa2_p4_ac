package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaService {

	public void agregar(Matricula matricula);
	
	public List<Matricula> buscarTodos();
	
	public List<MatriculaDTO> buscarDTO();
	
	
}
