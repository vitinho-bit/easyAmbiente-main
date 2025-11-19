package com.example.demo.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ReservaDTO;
import com.example.demo.Entity.Ambiente;
import com.example.demo.Entity.Reserva;
import com.example.demo.Repository.AmbienteRepository;
import com.example.demo.Repository.ReservaRepository;

@Service
public class ReservaService extends BaseService<Reserva, ReservaDTO> {

    ReservaRepository repository;

    @Autowired
    AmbienteRepository ambienteRepository;

    protected ReservaService(ReservaRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<ReservaDTO> listarPorNome(String nome) {
        List<Reserva> reservas = repository.findByNome(nome);
        List<ReservaDTO> dtos = new ArrayList<>();
        for (Reserva reserva : reservas) {
            dtos.add(super.toDto(reserva));
        }
        return dtos;
    }

    public List<ReservaDTO> listarPorAmbiente(Long ambienteId) {
        List<Reserva> reservas = repository.findByAmbiente(ambienteId);
        List<ReservaDTO> dtos = new ArrayList<>();
        for (Reserva reserva : reservas) {
            dtos.add(super.toDto(reserva));
        }
        return dtos;
    }

    public List<ReservaDTO> listarPorData(String dataInicio, String dataFim) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime inicio = LocalDate.parse(dataInicio, formatter).atStartOfDay();
        LocalDateTime fim = LocalDate.parse(dataFim, formatter).atTime(23, 59, 59);
        List<Reserva> reservas = repository.findByDatas(inicio, fim);
        List<ReservaDTO> dtos = new ArrayList<>();
        for (Reserva reserva : reservas) {
            dtos.add(super.toDto(reserva));
        }
        return dtos;
    }

    public ReservaDTO create(ReservaDTO dto) {
        Ambiente ambiente = ambienteRepository.findById(dto.getAmbiente().getId())
                .orElseThrow(() -> new IllegalStateException("Ambiente não existe."));

        if (!ambiente.isAtivo()) {
            throw new IllegalStateException("O ambiente não está ativo.");
        }

        boolean disponivel = repository.temDisponibilidade(
                ambiente.getId(),
                dto.getDataInicio(),
                dto.getDataFim());

        if (!disponivel) {
            throw new IllegalStateException("O ambiente já está ocupado.");
        }

        return super.create(dto);
    }

    public List<ReservaDTO> calendario(){
         LocalDate agora = LocalDate.now();

         LocalDateTime inicioDaSemana = agora.with(DayOfWeek.MONDAY).atStartOfDay();
         LocalDateTime fimDaSemana = inicioDaSemana.plusDays(6)
        .withHour(23)
        .withMinute(59)
        .withSecond(59);

        List<Reserva> reservas = repository.findByDatas(inicioDaSemana, fimDaSemana);

        List<ReservaDTO> dtos = new ArrayList<>();
        for (Reserva reserva : reservas) {
            dtos.add(super.toDto(reserva));
        }
        return dtos;
    }


    public Map<String, Long> getRelatorioUtilizacaoAmbientes(int mes, int ano) {
        List<Object[]> resultados = repository.findUtilizacaoAmbientesPorMes(mes, ano);
    
        Map<String, Long> relatorio = new LinkedHashMap<>();
    
        for (Object[] linha : resultados) {
            String nomeAmbiente = (String) linha[0];
            Long totalReservas = (Long) linha[1];
            relatorio.put(nomeAmbiente, totalReservas);
        }
    
        return relatorio;
    }

    
}
