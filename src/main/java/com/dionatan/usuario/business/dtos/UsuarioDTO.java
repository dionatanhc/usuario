package com.dionatan.usuario.business.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //faz com que possamos criar um objeto do tipo UsuarioDTO de forma mais simples, usando o padrão de projeto Builder
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTO> enderecos;
    private List<TelefoneDTO> telefones;
}
