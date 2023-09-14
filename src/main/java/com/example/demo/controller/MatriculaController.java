package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("matriculas")
public class MatriculaController {

	@Autowired
	IEstudianteService estudianteService;
	@Autowired
	IMateriaService materiaService;
	@Autowired
	IMatriculaService matriculaService;
	
	@GetMapping("/nuevaMatricula")
	public String paginaNuevaMatricula(Matricula matricula) {
		return "vistaNuevaMatricula";
	}
	
	@PostMapping("/insertar")
	public String insertarMatricula(Matricula matricula) {
		Materia temp= this.materiaService.buscarPorCodigo(matricula.getMateria().getCodigo());
		Estudiante estu = this.estudianteService.buscarPorCedula(matricula.getEstudiante().getCedula());
		this.matriculaService.agregar(matricula);
		return "redirect:/matriculas/buscar";
	}
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Matricula> lista=this.matriculaService.buscarTodos();
		modelo.addAttribute("matriculas", lista);
		return "vistaListaMatriculas";
	}
	
}
