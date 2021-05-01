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

import co.edu.uco.proyectonotas.dto.PaisDTO;
import co.edu.uco.proyectonotas.negocio.fachada.PaisFachada;
import co.edu.uco.proyectonotas.negocio.fachada.impl.FachadaFactory;



@RestController
@RequestMapping("/paises")
public class PaisControlador {

	@GetMapping("/dummy")
	public PaisDTO consultarDummy() {
		PaisDTO pais = new PaisDTO();

		pais.setCodigo(123);
		pais.setNombre("Peru");

		return pais;
	}

	@GetMapping("/crear")
    public ModelAndView crear() {
 
        PaisDTO pais = new PaisDTO();
        ModelAndView vista = new ModelAndView("/paises/crear");
        vista.addObject("titulo", "Formulario: Nuevo Pais");
        vista.addObject("paises", pais);
        return vista;
 
    }
 
    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute PaisDTO pais) {
        PaisFachada fachada = FachadaFactory.obtenerPaisFachada();
        fachada.registrar(pais);
        ModelAndView vista = new ModelAndView("redirect:/paises/listar");
 
        return vista;
 
    }
 
    @GetMapping("/listar")
    public ModelAndView consultar() {
 
        List<PaisDTO> paises = new ArrayList<>();
 
        PaisFachada fachada = FachadaFactory.obtenerPaisFachada();
        paises = fachada.consultar(null);
        ModelAndView vista = new ModelAndView("paises/listar");
        vista.addObject("titulo", "Lista de Paises");
        vista.addObject("paises", paises);
 
        return vista;
    }
 
    @GetMapping("/modificar/{codigo}")
    public ModelAndView modificar(@PathVariable int codigo) {
        List<PaisDTO> paises = new ArrayList<>();
        PaisDTO paisModificar = new PaisDTO();
        PaisFachada fachada = FachadaFactory.obtenerPaisFachada();
        paisModificar.setCodigo(codigo);
        paises = fachada.consultar(paisModificar);
        PaisDTO pais = paises.get(0);
        ModelAndView vista = new ModelAndView("/paises/modificar");
        vista.addObject("titulo", "Formulario: Modificar Pais");
        vista.addObject("paises", pais);
        return vista;
    }
 
    @PostMapping("/actualizar")
    public ModelAndView guardarCambios(@ModelAttribute PaisDTO pais) {
        PaisFachada fachada = FachadaFactory.obtenerPaisFachada();
        fachada.modificar(pais);
        ModelAndView vista = new ModelAndView("redirect:/paises/listar");
        return vista;
    }
    
    @GetMapping("/eliminar/{codigo}")
    public ModelAndView eliminar(@PathVariable int codigo) {
        PaisDTO paisEliminar = new PaisDTO();
        paisEliminar.setCodigo(codigo);
        PaisFachada fachada = FachadaFactory.obtenerPaisFachada();
        fachada.eliminar(paisEliminar);
        ModelAndView vista = new ModelAndView("redirect:/paises/listar");
        return vista;
    }
}
