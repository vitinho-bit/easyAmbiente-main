package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.ReservaDTO;
import com.example.demo.Service.ReservaService;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaController extends BaseController<ReservaDTO> {


    private ReservaService service;

    protected ReservaController(ReservaService service){
        super(service);
        this.service = service;
    
    }

    @GetMapping("/por-data/{dataInicio}/{dataFim}")
    public List<ReservaDTO> reservasPordata(
        @PathVariable("dataInicio") String dataInicio,
        @PathVariable("dataInicio") String dataFim
    ){
        return service.listarPorData(dataInicio, dataFim);

    }

    @GetMapping("/por-ambiente/{ambienteId}")
    public List<ReservaDTO> reservasPorAmbiente(
            @PathVariable("ambienteId") Long ambienteId){
        return service.listarPorAmbiente(ambienteId);

    }

    @GetMapping("/por-nome/{nome}")
    public List<ReservaDTO> reservasPorNome(
            @PathVariable("nome") String nome){
        return service.listarPorNome(nome);

    }

     
    // 🔹 Calendário semanal de reservas — integra com o método getCalendarioSemanal() do service
    @GetMapping("/calendario")
    public List<ReservaDTO> calendario() {
        return service.calendario();
    }


    @GetMapping("/relatorio-ambientes/{mes}/{ano}")
        public Map<String, Long> getRelatorioUtilizacaoAmbientes(
        @PathVariable int mes,
        @PathVariable int ano) {
    return service.getRelatorioUtilizacaoAmbientes(mes, ano);
}
    
    

}
