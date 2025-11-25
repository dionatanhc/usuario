package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor //Cria um construtor com todos os atributos da classe
@NoArgsConstructor //Cria um construtor vazio, sem parâmetros
@Entity //aponta para o spring que essa é uma tabela do banco de dados
//indica o nome da tabela, se não for definido name = "xxxxx" o nome automático será default
@Table(name = "endereco")

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Long numero;
    @Column(name = "complemento", length = 10)
    private String complemento;
    @Column(name = "cidade", length = 150)
    private String cidade;
    @Column(name = "estado", length = 3)
    private String estado;
    @Column(name = "cep", length = 9)
    private String cep;
}

//@GeneratedValue(strategy = GenerationType.IDENTITY)
//Diz ao JPA que o banco de dados será responsável por gerar o ID automaticamente
//O banco cria um ID novo toda vez que você salvar um registro
//id | nome
//1  | João
//2  | Maria
//3  | Lucas
