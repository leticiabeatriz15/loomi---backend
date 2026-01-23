package com.loomi.loomi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.loomi.loomi.domain.usuario.Usuario;
import com.loomi.loomi.domain.usuario.UsuarioRepository;
import java.util.UUID;

@Service
public class UsuarioService {
    
    @Autowired (required = true)
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll();

    }

    public void deletarUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
