package com.loomi.loomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loomi.loomi.domain.usuario.Usuario;
import com.loomi.loomi.domain.usuario.UsuarioRepository;
import com.loomi.loomi.dto.UsuarioDto;
import com.loomi.loomi.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired (required = true)
    private UsuarioService usuarioService;
    
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario = usuarioService.criarUsuario(usuario);

        return ResponseEntity.ok(usuario);
    }
}
