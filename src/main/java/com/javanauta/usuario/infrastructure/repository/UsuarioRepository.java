package com.javanauta.usuario.infrastructure.repository;

import com.dionatan.aprendendospring.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    //classe que serve para evitar retorno de informações nulas, evitar erro NullPointerException
    Optional<Usuario> findByEmail (String email);

    @Transactional
    void deleteByEmail(String email);
}
