package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
	}

	@Override
	public List<Matricula> seleccionarTodos() {
		TypedQuery<Matricula> query = this.entityManager.createQuery("SELECT m FROM Matricula m", Matricula.class);
		return query.getResultList();
	}

	@Override
	public List<MatriculaDTO> seleccionarDTO() {
		TypedQuery<MatriculaDTO> myTypedQuery = this.entityManager
				 .createQuery("select NEW com.example.demo.modelo.dto.MatriculaDTO "
				 		+ "(m.estudiante.cedula, m.estudiante.apellido, m.estudiante.nombre , m.materia.nombre, m.materia.codigo, m.fechaMatricula)from Matricula m", MatriculaDTO.class);
				return myTypedQuery.getResultList();
	}
	
	

}
