package com.forza.apirest.apirest.Controllers;

import com.forza.apirest.apirest.Entities.Producto;
import com.forza.apirest.apirest.Entities.Usuario;
import com.forza.apirest.apirest.Repositories.UsuarioRepository;
import com.forza.apirest.apirest.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable String email){
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorEmail(email);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
//    public Usuario obtenerUsuarioPorEmail(@PathVariable String email){
//        return usuarioService.obtenerUsuarioPorEmail(email);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, usuarioActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @RequestMapping("usuario/{id}")
//    public List<Producto.Usuario> getUsuarios(){
//        List<Producto.Usuario> usuarios = new ArrayList<>();
//
//        Producto.Usuario usuario1 = new Producto.Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
//        Producto.Usuario usuario2 = new Producto.Usuario(2L,"Tester", "test@2.2", "test2", "+5691", "Dentro de", "tu corazon bb 💝");
//        Producto.Usuario usuario3 = new Producto.Usuario(3L,"Tester", "test@3.3", "test3", "+5691", "Dentro de", "tu corazon bb 💝");
//
//        usuarios.add(usuario1);
//        usuarios.add(usuario2);
//        usuarios.add(usuario3);
//        return usuarios;
//    }
//
//    @RequestMapping
//    public Producto.Usuario updateUsuario(){
//
//        Producto.Usuario usuario = new Producto.Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
//        return usuario;
//    }
//
//
//    @RequestMapping
//    public Producto.Usuario deleteUsuario(){
//
//        Producto.Usuario usuario = new Producto.Usuario(1L,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
//        return usuario;
//    }
//
//
//    @RequestMapping(value = "usuario/{id}")
//    public Producto.Usuario getByIdUsuario(@PathVariable Long id){
//
//        Producto.Usuario usuario = new Producto.Usuario(id,"Test", "test@1.1", "test1", "+5691", "Dentro de", "tu corazon bb 💝");
//        return usuario;
//    }
//
//    @RequestMapping(value="usuarios")
//    public List<Producto.Usuario> getUsuario(){
//        return usuarioRepository.getUsuarios();
//    }

}
