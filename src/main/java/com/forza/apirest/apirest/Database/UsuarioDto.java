package com.forza.apirest.apirest.Database;
import com.forza.apirest.apirest.Entities.Usuario;

public record UsuarioDto( Long id, String nombre, String email) {

    public UsuarioDto(Usuario u){
        this(u.getId(), u.getNombre(), u.getEmail());
    }

    public Usuario toUserEntity(){
        return new Usuario(id,nombre,email);
    }

}
