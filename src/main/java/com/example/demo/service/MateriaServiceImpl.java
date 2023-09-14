package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;
	@Override
	public void agregar(Materia materia) {
		this.iMateriaRepository.insertar(materia);
		
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		return this.iMateriaRepository.buscarPorCodigo(codigo);
	}

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarPorId(id);
	}

	@Override
	public List<Materia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionarTodo();
	}

	
	
}
