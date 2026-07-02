package com.dionatan.usuario.business;

import com.dionatan.usuario.business.converter.UsuarioConverter;
import com.dionatan.usuario.business.dtos.UsuarioDTO;
import com.dionatan.usuario.infraestructure.entity.Usuario;
import com.dionatan.usuario.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }
}
