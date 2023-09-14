package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping(value = "materias")
public class MateriaController {

	@Autowired
	IMateriaService materiaService;
	
	@GetMapping(value = "/nuevaMateria")
	public String paginaNuevaMateria(Materia materia) {
		return "vistaNuevaMateria";
	}

	@PostMapping(value = "/insertar")
	public String insertarMateria(Materia materia) {
		this.materiaService.agregar(materia);
		return "redirect:/materias/buscar";
	}
	
	@GetMapping(value = "/buscar")
	public String buscarTodos(Model modelo) {
		List<Materia> lista=this.materiaService.buscarTodos();
		modelo.addAttribute("materias", lista);		
		return "vistaListaMaterias";
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public String buscarPorId(@PathVariable("id") Integer id, Model modelo) {
		Materia materia = this.materiaService.buscarPorId(id);
		modelo.addAttribute("materia", materia);
		return "vistaMateria";
	}
	
}
