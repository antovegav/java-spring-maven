package com.forza.apirest.apirest.Repositories;

import com.forza.apirest.apirest.Entities.Carrito;
import com.forza.apirest.apirest.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    List<Carrito> findByUsuario(Usuario usuario);
}
