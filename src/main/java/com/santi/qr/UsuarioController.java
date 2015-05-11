package com.santi.qr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.santi.qr.model.Usuario;
import com.santi.qr.service.UsuarioService;

@Controller
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@Autowired(required=true)
	@Qualifier(value="usuarioService")
	public void setUsuarioService(UsuarioService us){
		this.usuarioService = us;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String listaUsuarios(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaUsuarios", this.usuarioService.listaUsuarios());
		return "usuario";
	}
	
	//For add and update person both
	@RequestMapping(value= "/usuario/crea", method = RequestMethod.POST)
	public String creaUsuario(@ModelAttribute("usuario") Usuario u){
		
		if(u.getId_user()== 0){
			//new person, add it
			this.usuarioService.creaUsuario(u);
		}else{
			//existing person, call update
			this.usuarioService.actualizaUsuario(u);
		}
		
		return "redirect:/usuarios";
		
	}
	
	@RequestMapping("/elimina/{id_user}")
    public String eliminaUsuario(@PathVariable("id_user") int id){
		
        this.usuarioService.eliminaUsuario(id);
        return "redirect:/usuarios";
    }
 
    @RequestMapping("/edita/{id_user}")
    public String editaUsuario(@PathVariable("id_user") int id_user, Model model){
        model.addAttribute("usuario", this.usuarioService.getUsuarioPorId(id_user));
        model.addAttribute("listaUsuarios", this.usuarioService.listaUsuarios());
        return "usuario";
    }
	
}
