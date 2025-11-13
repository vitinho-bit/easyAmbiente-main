package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.Entity.Ambiente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "O nome deve ser preenchido")
    private String nome;

    @NotNull(message = "O motivo deve ser preenchido")
    private String motivo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @NotNull(message = "A data inicio deve ser preenchida")
    private LocalDateTime dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @NotNull(message = "A data final deve ser preenchida")
    private LocalDateTime dataFim;

    @NotNull(message = "O ambiente deve ser preenchido")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Ambiente ambiente;

    @AssertTrue(message = "A data de inicio deve ser antes da data fim")
    public boolean periodoValido(){
        return dataInicio.isBefore(dataFim);
    }

}
