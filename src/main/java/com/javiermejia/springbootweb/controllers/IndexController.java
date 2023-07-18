package com.javiermejia.springbootweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javiermejia.springbootweb.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    @GetMapping({"/","/index","/home",""})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework con Model!");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Javier");
        usuario.setApellido("Mejia");
        usuario.setEmail("javier@correo.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Javier", "Mejia", "javier@correo.com"));
        usuarios.add(new Usuario("Braulio", "Torres", "braulio@correo.com"));
        usuarios.add(new Usuario("Emmanuel", "Onate", "emmanuel@correo.com"));

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }
}
