package co.edu.uco.proyectonotas.web.controlador;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.uco.proyectonotas.dto.AdministradorDTO;
import co.edu.uco.proyectonotas.dto.PersonaDTO;
import co.edu.uco.proyectonotas.negocio.fachada.AdministradorFachada;
import co.edu.uco.proyectonotas.negocio.fachada.PersonaFachada;
import co.edu.uco.proyectonotas.negocio.fachada.impl.FachadaFactory;


 
@Controller
public class LoginControlador {
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm() {
        return "login";
        
    }
    
    @RequestMapping(value="login", method=RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm") String nombreUsuario, String contraseña,  Model model) {
    	
    	List<AdministradorDTO> admins = new ArrayList<>();
    	List<PersonaDTO> users = new ArrayList<>();
    	String retorno = "login";
        
        PersonaFachada personaFachada = FachadaFactory.obtenerPersonaFachada();
        AdministradorFachada adminsitradorFachada = FachadaFactory.obtenerAdministradorFachada();
        AdministradorDTO administradorDto = new AdministradorDTO();
        PersonaDTO personaDto = new PersonaDTO();
        personaDto.setNombre(nombreUsuario);
        personaDto.setContraseña(contraseña);
        administradorDto.setNombre(nombreUsuario);
        administradorDto.setContraseña(contraseña);
        
        System.out.println(personaDto.getNombreUsuario()+ personaDto.getContraseña());
        
        users = personaFachada.consultar(personaDto);
        admins = adminsitradorFachada.consultar(administradorDto);
        
        
        if(users.equals(null)) {
        	
        	if(admins.equals(null))
        	{
        		retorno = "login";
        		
        	}else if(admins.get(0).getNombreUsuario() == nombreUsuario && admins.get(0).getContraseña() == contraseña) {
        		retorno = "usuarios/listar";
        	}
        	
        }else if(users.get(0).getNombreUsuario() == nombreUsuario && users.get(0).getContraseña() == contraseña) {
        	retorno =  "paises/listar";
        }else {
        	model.addAttribute("invalidCredentials", true);
        	
        	retorno = "login";
        }
        return retorno;
        
        
    }
    
    
}
 