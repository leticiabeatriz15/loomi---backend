package com.loomi.loomi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loomi.loomi.domain.usuario.Usuario;
import com.loomi.loomi.domain.usuario.UsuarioRepository;
import com.loomi.loomi.dto.UsuarioDto;

@Service
public class UsuarioService {
    
    @Autowired (required = true)
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
