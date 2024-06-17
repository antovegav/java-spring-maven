package com.forza.apirest.apirest;


import com.forza.apirest.apirest.Database.UsuarioDto;
import com.forza.apirest.apirest.Entities.Usuario;
import com.forza.apirest.apirest.Repositories.UsuarioRepository;
import com.forza.apirest.apirest.Services.UsuarioServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UsuarioServicesTest {

    @InjectMocks
    private UsuarioServices usuarioServices;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    public void testGetUsuariosById( ){
        Long usuarioId = 1L;
        Usuario mockUsuario = new Usuario(usuarioId,"Juancho","janxo@gmail.com");

        Mockito.when(usuarioRepository.findById(usuarioId)).thenReturn(Optional.ofNullable(mockUsuario));

        UsuarioDto savedUsuario = usuarioServices.getUsuarioById(usuarioId);


    }

}
