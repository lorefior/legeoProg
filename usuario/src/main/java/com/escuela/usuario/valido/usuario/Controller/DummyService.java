package com.escuela.usuario.valido.usuario.Controller;

import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class DummyService {

	Map<String, Usuario> base = DummyBase.getMap();

	public boolean getAtribute(String user, String pass) {
		Usuario usuario = base.get(user);
		if (usuario == null) {
			return false;
		} else if (usuario.getPass().equals(pass)) {
			return true;
		}
		return false;

	}

	public void setAtribute(String user, Usuario pass) {

		base.put(user, pass);
	}

	public boolean registerUser(String user, Usuario password) {
		Usuario usuario = base.get(user);
		if (usuario == null) {
			base.put(user, password);
			return true;
		}
		return false;
	}

	public Usuario searchUser(String user, Usuario Usuario) {
		Usuario usuario = base.get(user);
		if(usuario == null) {
		return null;
		}	else  {
			base.values();
			return usuario;
	    }	
	}
}