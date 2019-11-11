package com.escuela.usuario.valido.usuario.Controller;

import java.util.HashMap;
import java.util.Map;

public class DummyBase {

	private static Map<String, Usuario> mapa;

	static {

		mapa = new HashMap<String, Usuario>();
		mapa.put("flor", new Usuario("flor", "1234", "florencia", "Forneton", "sasa@sdfs.com", 26));
		mapa.put("lore", new Usuario("lore", "1000", "Lorena", "Fiordelmondo", "lore@gmail.com", 23));
		mapa.put("vale", new Usuario("vale", "1000", "Valentina", "Mora", "anda@asd.com", 20));
		mapa.put("agusfior", new Usuario("agusfior", "1000", "Agustina", "Fiordelmondo", "agus@fior.com", 21));
		mapa.put("florvera", new Usuario("florvera", "1000", "Florencia", "Vera", "florevera@gmail.com", 21));

		
	}

	public static Map<String, Usuario> getMap() {
		return mapa;
	}

	public static void setMap(String userN, Usuario user) {
		mapa.put(userN, user);
	}

}