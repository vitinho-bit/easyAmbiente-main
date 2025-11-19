package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDTO {

@JsonProperty(access = JsonProperty.Access.READ_ONLY)
private Long id;

@NotNull(message = "O campo nome deve ser preenchido")
private String nome;

@NotNull(message = "O campo descricao deve ser preenchido")
private String descricao;

@NotNull(message = "O campo tipo deve ser preenchido")
private String tipo;



}
