package com.loomi.loomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.loomi.loomi.domain.usuario.Usuario;
import com.loomi.loomi.dto.UsuarioDto;
import com.loomi.loomi.services.UsuarioService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    
    @Autowired (required = true)
    private UsuarioService usuarioService;
    
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){

        Usuario usuario = new Usuario();
        usuario.setNome((usuarioDto.nome()));
        usuario.setSenha((usuarioDto.senha()));

        usuario = usuarioService.criarUsuario(usuario);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
