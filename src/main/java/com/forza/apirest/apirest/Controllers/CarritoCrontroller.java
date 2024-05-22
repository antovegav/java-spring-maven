package com.forza.apirest.apirest.Controllers;

import com.forza.apirest.apirest.Entities.Carrito;
import com.forza.apirest.apirest.Entities.Usuario;
import com.forza.apirest.apirest.Services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CarritoCrontroller {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/{usuarioID}")
    public List<Carrito> obtenerCarritoPorUsuario(@PathVariable Long usuarioId){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return carritoService.obtenerCarritoPorUsuario(usuario);
    }

    @PostMapping
    public Carrito agregarProductoAlCarrito(@RequestBody Carrito carrito){
        return carritoService.agregarProductoAlCarrito(carrito);
    }
}
