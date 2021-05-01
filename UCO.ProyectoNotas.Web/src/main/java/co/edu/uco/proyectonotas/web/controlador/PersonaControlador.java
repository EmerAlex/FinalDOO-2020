package co.edu.uco.proyectonotas.web.controlador;

import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.objetoEsNulo;
import static co.edu.uco.transversal.utilitario.texto.UtilTexto.cadenaEstaNulaOVacia;
import static co.edu.uco.transversal.utilitario.texto.UtilTexto.soloTexto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.edu.uco.proyectonotas.dto.PersonaDTO;
import co.edu.uco.proyectonotas.negocio.fachada.PersonaFachada;
import co.edu.uco.proyectonotas.negocio.fachada.impl.FachadaFactory;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;
import co.edu.uco.transversal.respuesta.Respuesta;
import co.edu.uco.transversal.respuesta.enumeracion.TipoRespuestaEnum;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class PersonaControlador {
	
	@GetMapping("/dummy")
	public PersonaDTO consultarDummy() {
		PersonaDTO persona = new PersonaDTO();
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
 
        PersonaDTO usuario = new PersonaDTO();
        ModelAndView vista = new ModelAndView("/usuarios/crear");
        vista.addObject("titulo", "Formulario: Nuevo Usuario");
        vista.addObject("usuarios", usuario);
        return vista;
	}
	
	@PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute PersonaDTO usuario) {
        PersonaFachada fachada = FachadaFactory.obtenerPersonaFachada();
        fachada.registrar(usuario);
        ModelAndView vista = new ModelAndView("redirect:/usuarios/listar");
 
        return vista;
 
    }
	@GetMapping("/modificar/{codigo}")
    public ModelAndView modificar(@PathVariable int codigo) {
        List<PersonaDTO> usuarios = new ArrayList<>();
        PersonaDTO usuarioModificar = new PersonaDTO();
        PersonaFachada fachada = FachadaFactory.obtenerPersonaFachada();
        usuarioModificar.setCodigo(codigo);
        usuarios = fachada.consultar(usuarioModificar);
        PersonaDTO usuario = usuarios.get(0);
        ModelAndView vista = new ModelAndView("/usuarios/modificar");
        vista.addObject("titulo", "Formulario: Modificar Usuarios");
        vista.addObject("usuarios", usuario);
        return vista;
    }

    @GetMapping("/eliminar/{codigo}")
    public ModelAndView eliminar(@PathVariable int codigo) {
        PersonaDTO usuarioEliminar = new PersonaDTO();
        usuarioEliminar.setCodigo(codigo);
        PersonaFachada fachada = FachadaFactory.obtenerPersonaFachada();
        fachada.eliminar(usuarioEliminar);
        ModelAndView vista = new ModelAndView("redirect:/usuarios/listar");
        return vista;
    }
	
    
    @PostMapping("/actualizar")
    public ModelAndView guardarCambios(@ModelAttribute PersonaDTO usuario) {
        PersonaFachada fachada = FachadaFactory.obtenerPersonaFachada();
        fachada.modificar(usuario);
        ModelAndView vista = new ModelAndView("redirect:/usuarios/listar");
        return vista;
    }
    
	@GetMapping("/listar")
    public ModelAndView consultar() {
 
        List<PersonaDTO> usuarios = new ArrayList<>();
 
        PersonaFachada fachada = FachadaFactory.obtenerPersonaFachada();
        usuarios = fachada.consultar(null);
        ModelAndView vista = new ModelAndView("usuarios/listar");
        vista.addObject("titulo", "Lista de Usuarios");
        vista.addObject("usuarios", usuarios);
 
        return vista;
    }
}
