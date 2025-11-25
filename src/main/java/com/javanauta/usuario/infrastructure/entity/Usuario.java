package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor //Cria um construtor com todos os atributos da classe
@NoArgsConstructor //Cria um construtor vazio, sem parâmetros
@Entity //aponta para o spring que essa é uma tabela do banco de dados
//indica o nome da tabela, se não for definido name = "xxxxx" o nome automático será default
@Table(name = "usuario")

public class Usuario implements UserDetails {

    @Id
    //gera automaticamente o identificador único
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //indicia o nome e atributos da coluna
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;

    //um usuário para muitos endereços
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
