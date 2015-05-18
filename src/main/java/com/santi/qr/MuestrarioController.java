package com.santi.qr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.santi.qr.model.Muestrario;
import com.santi.qr.service.MuestrarioService;

@Controller
public class MuestrarioController {
	
	private MuestrarioService muestrarioService;
	
	@Autowired(required=true)
	@Qualifier(value="muestrarioService")
	public void setMuestrarioService(MuestrarioService ms){
		this.muestrarioService = ms;
	}
	
	@RequestMapping(value = "/muestrarios", method = RequestMethod.GET)
	public String listaMuestrarios(Model model) {
		model.addAttribute("muestrario", new Muestrario());
		model.addAttribute("listaMuestrarios", this.muestrarioService.listaMuestrarios());
		return "muestrario";
	}
	
	//For add and update person both
	@RequestMapping(value= "/muestrarios/crea", method = RequestMethod.POST)
	public String creaMuestrario(@ModelAttribute("muestrario") Muestrario m){
		
		if(m.getId_qr()== 0){
			//new qr, add it
			this.muestrarioService.creaMuestrario(m);
		}else{
			//existing person, call update
			this.muestrarioService.actualizaMuestrario(m);
		}
		
		return "redirect:/muestrarios";
		
	}
	
	@RequestMapping("muestrarios/elimina/{id_qr}")
    public String eliminaMuestrario(@PathVariable("id_qr") int id){
		
        this.muestrarioService.eliminaMuestrario(id);
        return "redirect:/muestrarios";
    }
 
    @RequestMapping("muestrarios/edita/{id_qr}")
    public String editaMuestrario(@PathVariable("id_qr") int id_qr, Model model){
        model.addAttribute("muestrario", this.muestrarioService.getMuestrarioPorId(id_qr));
        model.addAttribute("listaMuestrarios", this.muestrarioService.listaMuestrarios());
        return "muestrario";
    }
	
}
