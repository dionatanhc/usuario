package com.dionatan.usuario.business.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneDTO{
    private String numero;
    private String ddd;
}
