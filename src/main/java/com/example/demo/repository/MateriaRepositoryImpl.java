package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
	}

	@Override
	public List<Materia> seleccionarTodo() {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("(m.nombre, m.codigo, m.descripcion, m.numeroCreditos, m.numeroEstudiantes)"
				+ "from Materia m", Materia.class);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia buscarPorCodigo(String codigo) {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("select m from Materia m where m.codigo:= codigo",
				Materia.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public Materia buscarPorId(Integer id) {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("select m from Materia m where m.id:= id",
				Materia.class);
		myQuery.setParameter("id", id);
		return myQuery.getSingleResult();
	}

}
