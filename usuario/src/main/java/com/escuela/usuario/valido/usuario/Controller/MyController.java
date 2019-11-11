package com.escuela.usuario.valido.usuario.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@Autowired
	DummyService service;
	DummyBase base;

	@GetMapping("/login")
	public String createUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

	@PostMapping("/login")
	public String readUser(@ModelAttribute Usuario usuario, Model modelo) {

		if (service.getAtribute(usuario.getUser(), usuario.getPass())) {
			return "cuenta";
		} else {
			modelo.addAttribute("pepe", "Usuario y/o contraseña invalido!");
			return "error";
		}

	}

	@GetMapping("/okLogin")
	public String createUsuario1(Usuario usuario) {

		return "okLogin";
	}

	@PostMapping("/okLogin")
	public String readUser1(@ModelAttribute Usuario usuario, Model modelo) {
		if (service.registerUser(usuario.getUser(), usuario))
			return "datos";
		else {
			System.out.println("error  existe usuario");
			modelo.addAttribute("pepe", "El usuario '" + usuario.getUser() + "' ya existe!");
			return "error";
		}
	}

	@GetMapping("/proximamente")
	public String createUsuario15(Usuario usuario) {

		return "proximamente";
	}

	@GetMapping("/buscador")
	public String searchUser1(Usuario usuario) {
		return "buscador";
	}

	@PostMapping("/buscador")
	public String searchUser2(@ModelAttribute Usuario usuario, Model modelo) {
		Usuario user = service.searchUser(usuario.getUser(), usuario);
		if (user != null) {
			modelo.addAttribute("usuario", "Usuario: " + user.getUser());
			modelo.addAttribute("nombre", " Nombre: " + user.getNombre());
			modelo.addAttribute("apellido", "Apellido: " + user.getApellido());
			modelo.addAttribute("edad", "Edad: " + user.getEdad());
			modelo.addAttribute("mail", "E-mail:  " + user.getMail());

			return "datosBusqueda";
		} else {
			modelo.addAttribute("pepe", "Usuario no encontrado!");
			return "error";
		}
	}
}