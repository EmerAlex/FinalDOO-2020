package co.edu.uco.proyectonotas.negocio.fachada.impl;

import co.edu.uco.proyectonotas.negocio.fachada.AdministradorFachada;
import co.edu.uco.proyectonotas.negocio.fachada.PaisFachada;
import co.edu.uco.proyectonotas.negocio.fachada.PersonaFachada;

public class FachadaFactory {
	
	public static PaisFachada obtenerPaisFachada() {
		return new PaisFachadaImpl();
	}
	public static PersonaFachada obtenerPersonaFachada() {
		return new PersonaFachadaImpl();
	}
	public static AdministradorFachada obtenerAdministradorFachada() {
		return new AdministradorFachadaImpl();
	}
}

