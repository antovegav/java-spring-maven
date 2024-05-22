package com.forza.apirest.apirest.Repositories;

import com.forza.apirest.apirest.Entities.Producto;
import com.forza.apirest.apirest.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findBtEmail(String email);
//    List<Producto.Usuario> getUsuarios();
}
