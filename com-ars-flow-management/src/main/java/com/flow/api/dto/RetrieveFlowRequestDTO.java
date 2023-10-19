package com.flow.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveFlowRequestDTO {

    public int id;
    public String nome;
    public String descricao;

}
