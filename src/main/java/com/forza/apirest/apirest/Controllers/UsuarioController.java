package com.forza.apirest.apirest.Controllers;

import com.forza.apirest.apirest.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuario(){
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        Usuario usuario2 = new Usuario(2L,"Tester", "test@2.2", "test2", "+5691", "Dentro de", "tu corazon bb 💝");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        return usuarios;
    }

    public Usuario updateUsuario(){

        Usuario usuario = new Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        return usuario;
    }


    public Usuario deleteUsuario(){

        Usuario usuario = new Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        return usuario;
    }


    @RequestMapping(value = "usuario/{id}")
    public Usuario getByIdUsuario(@PathVariable Long id){

        Usuario usuario = new Usuario(id,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        return usuario;
    }
    
}
