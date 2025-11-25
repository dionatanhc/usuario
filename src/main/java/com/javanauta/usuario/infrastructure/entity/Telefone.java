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
@Table(name = "telefone")

public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", length = 10)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;
}
