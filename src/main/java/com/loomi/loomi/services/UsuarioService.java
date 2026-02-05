package com.loomi.loomi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.loomi.loomi.domain.usuario.Usuario;
import com.loomi.loomi.domain.usuario.UsuarioRepository;
 import com.loomi.loomi.exception.BusinessException;
import com.loomi.loomi.exception.ResourceNotFoundException;
import java.util.UUID;

@Service
public class UsuarioService {
    
    @Autowired (required = true)
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        try {
            validarUsuario(usuario);
            return usuarioRepository.save(usuario);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Erro ao criar usuário", e);
        }
    }

    public List<Usuario> listarTodosUsuarios(){
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException("Erro ao listar usuários", e);
        }
    }

    public Usuario buscarUsuarioPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário", "id", id));
    }

    public void deletarUsuario(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        try {
            if (!usuarioRepository.existsById(id)) {
                throw new ResourceNotFoundException("Usuário", "id", id);
            }
            usuarioRepository.deleteById(id);
        } catch (ResourceNotFoundException | IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Erro ao deletar usuário", e);
        }
    }
    
    private void validarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        
        // Adicione validações específicas conforme necessário
        // Por exemplo: validar email, nome, etc.
    }
}
