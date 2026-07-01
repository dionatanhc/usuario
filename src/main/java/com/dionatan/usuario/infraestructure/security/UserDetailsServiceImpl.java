package com.dionatan.usuario.infraestructure.security;

import com.dionatan.usuario.infraestructure.entity.Usuario;
import com.dionatan.usuario.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    // Repositório para acessar dados de usuário no banco de dados
    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Implementação do método para carregar detalhes do usuário pelo e-mail
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Busca o usuário no banco de dados pelo e-mail
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return User
                .withUsername(usuario.getUsername()) // Define o nome de usuário como o e-mail

                // IMPORTANTE → Deve retornar a senha criptografada!
                .password(usuario.getPassword())

                // Spring exige uma lista de authorities; mesmo vazio funciona.
                .authorities("USER") // coloca um papel padrão para evitar erro

                // Constrói o objeto UserDetails
                .build();
    }
}
