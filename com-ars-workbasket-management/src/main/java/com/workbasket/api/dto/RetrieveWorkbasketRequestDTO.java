package com.workbasket.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveWorkbasketRequestDTO {

    public int id;
    public String nome;
    public String descricao;

}
