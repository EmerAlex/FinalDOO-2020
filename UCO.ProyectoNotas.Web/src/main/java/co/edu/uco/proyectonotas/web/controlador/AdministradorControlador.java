package co.edu.uco.proyectonotas.web.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.edu.uco.proyectonotas.dto.AdministradorDTO;
import co.edu.uco.proyectonotas.dto.PersonaDTO;
import co.edu.uco.proyectonotas.negocio.fachada.AdministradorFachada;
import co.edu.uco.proyectonotas.negocio.fachada.impl.FachadaFactory;

@CrossOrigin("*")
@RestController
@RequestMapping("/administradores")
public class AdministradorControlador {
	
	//proyecto actuualizado!!!!!!

	@GetMapping("/dummy")
	public AdministradorDTO consultarDummy() {
		AdministradorDTO persona = new AdministradorDTO();
		persona.setCodigoSuperAdministrador(1);
		persona.setCodigo(1);
		persona.setNombre("Santiago");
		persona.setApellido("Toro");
		persona.setEstado(true);
		persona.setNombreUsuario("santi123");
		persona.setContraseña("santielp");
		return persona;
	}

	@GetMapping("/crear")
	public ModelAndView crear() {

		AdministradorDTO usuario = new AdministradorDTO();
		ModelAndView vista = new ModelAndView("/administradores/crear");
		vista.addObject("titulo", "Formulario: Nuevo Usuario");
		vista.addObject("administradores", usuario);
		return vista;
	}

	
	
	@PostMapping("/guardar")
	public ModelAndView guardar(@ModelAttribute AdministradorDTO usuario) {
		AdministradorFachada fachada = FachadaFactory.obtenerAdministradorFachada();
		fachada.registrar(usuario);
		ModelAndView vista = new ModelAndView("redirect:/administradores/listar");
		return vista;

	}
	
	@GetMapping("/convertirAUsuarioNormal/{codigo}")
	public ModelAndView ConvertirEnUsuarioNormal(@PathVariable int codigo) {
		AdministradorDTO usuario = new AdministradorDTO();
		usuario.setCodigo(codigo);
		AdministradorFachada fachada = FachadaFactory.obtenerAdministradorFachada();

		PersonaDTO usuarioConvertido = new PersonaDTO();
//		usuarioConvertido.setCodigo(fachada.ge);
		ModelAndView vista = new ModelAndView("redirect:/administradores/listar");
		return vista;
	}

	@GetMapping("/modificar/{codigo}")
	public ModelAndView modificar(@PathVariable int codigo) {
		List<AdministradorDTO> usuarios = new ArrayList<>();
		AdministradorDTO usuarioModificar = new AdministradorDTO();
		AdministradorFachada fachada = FachadaFactory.obtenerAdministradorFachada();
		usuarioModificar.setCodigo(codigo);
		usuarios = fachada.consultar(usuarioModificar);
		AdministradorDTO usuario = usuarios.get(0);
		ModelAndView vista = new ModelAndView("/administradores/modificar");
		vista.addObject("titulo", "Formulario: Modificar administradores");
		vista.addObject("administradores", usuario);
		return vista;
	}

	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminar(@PathVariable int codigo) {
		AdministradorDTO usuarioEliminar = new AdministradorDTO();
		usuarioEliminar.setCodigo(codigo);
		AdministradorFachada fachada = FachadaFactory.obtenerAdministradorFachada();
		fachada.eliminar(usuarioEliminar);
		ModelAndView vista = new ModelAndView("redirect:/administradores/listar");
		return vista;
	}

	@PostMapping("/actualizar")
	public ModelAndView guardarCambios(@ModelAttribute AdministradorDTO usuario) {
		AdministradorFachada fachada = FachadaFactory.obtenerAdministradorFachada();
		fachada.modificar(usuario);
		ModelAndView vista = new ModelAndView("redirect:/administradores/listar");
		return vista;
	}

	@GetMapping("/listar")
	public ModelAndView consultar() {

		List<AdministradorDTO> usuarios = new ArrayList<>();

		AdministradorFachada fachada = FachadaFactory.obtenerAdministradorFachada();
		usuarios = fachada.consultar(null);
		ModelAndView vista = new ModelAndView("administradores/listar");
		vista.addObject("titulo", "Lista de administradores");
		vista.addObject("administradores", usuarios);

		return vista;
	}

}
