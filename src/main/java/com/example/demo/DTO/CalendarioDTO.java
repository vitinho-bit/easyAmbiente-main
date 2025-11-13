package com.example.demo.DTO;

import java.time.LocalDateTime;

public class CalendarioDTO {
    private Long id;
    private String titulo;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public CalendarioDTO(Long id, String titulo, LocalDateTime inicio, LocalDateTime fim) {
        this.id = id;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public LocalDateTime getInicio() { return inicio; }
    public LocalDateTime getFim() { return fim; }
}
