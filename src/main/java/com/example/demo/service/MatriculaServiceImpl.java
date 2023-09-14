package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Override
	public void agregar(Matricula matricula) {
		
		Materia temp = this.iMateriaRepository.buscarPorId(matricula.getMateria().getId());
		temp.setNumeroEstudiantes(temp.getNumeroEstudiantes()+1);
		

		this.iMatriculaRepository.insertar(matricula);
	}

	@Override
	public List<Matricula> buscarTodos() {
		return this.iMatriculaRepository.seleccionarTodos();
	}

	@Override
	public List<MatriculaDTO> buscarDTO() {
		return this.iMatriculaRepository.seleccionarDTO();
	}

}
