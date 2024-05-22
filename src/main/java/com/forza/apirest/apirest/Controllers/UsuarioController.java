package com.forza.apirest.apirest.Controllers;

import com.forza.apirest.apirest.Repositories.UsuarioRepository;
import com.forza.apirest.apirest.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("usuario/{id}")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        Usuario usuario2 = new Usuario(2L,"Tester", "test@2.2", "test2", "+5691", "Dentro de", "tu corazon bb 💝");
        Usuario usuario3 = new Usuario(3L,"Tester", "test@3.3", "test3", "+5691", "Dentro de", "tu corazon bb 💝");

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }

    @RequestMapping
    public Usuario updateUsuario(){

        Usuario usuario = new Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        return usuario;
    }


    @RequestMapping
    public Usuario deleteUsuario(){

        Usuario usuario = new Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        return usuario;
    }


    @RequestMapping(value = "usuario/{id}")
    public Usuario getByIdUsuario(@PathVariable Long id){

        Usuario usuario = new Usuario(id,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
        return usuario;
    }

    @RequestMapping(value="usuarios")
    public List<Usuario> getUsuario(){
        return usuarioRepository.getUsuarios();
    }

}
