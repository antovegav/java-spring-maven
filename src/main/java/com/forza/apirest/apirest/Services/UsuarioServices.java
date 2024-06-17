package com.forza.apirest.apirest.Services;


import com.forza.apirest.apirest.Database.UsuarioDto;
import com.forza.apirest.apirest.Entities.Usuario;
import com.forza.apirest.apirest.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServices(final UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto createUsuario(UsuarioDto usuarioDto){
        return new UsuarioDto(usuarioRepository.save(usuarioDto.toUserEntity()));
    }

    public List<UsuarioDto> getAllUsuarios(){
        return usuarioRepository.findAll().stream().map(UsuarioDto::new).toList();
    }

    public UsuarioDto getUsuarioById(Long id){
        return new UsuarioDto(usuarioRepository.findById(id).orElse(null));
    }

    public Usuario updateUsuario(Long id, Usuario usuario){
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
