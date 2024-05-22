package com.forza.apirest.apirest.Services;

import com.forza.apirest.apirest.Entities.Carrito;
import com.forza.apirest.apirest.Entities.Usuario;
import com.forza.apirest.apirest.Repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> obtenerCarritoPorUsuario(Usuario usuario){
        return carritoRepository.findByUsuario(usuario);
    }

    public  Carrito agregarProductoAlCarrito( Carrito carrito){
        return carritoRepository.save(carrito);
    }
}
