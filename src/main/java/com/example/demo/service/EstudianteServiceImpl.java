package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	private IEstudianteRepository iEstudianteRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Estudiante estudiante) {
		this.iEstudianteRepository.insertar(estudiante);
}

	@Override
	public List<Estudiante> buscarTodos() {
		return this.iEstudianteRepository.buscarTodos();
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		return this.iEstudianteRepository.seleccionarPorCedula(cedula);
	}

	}
