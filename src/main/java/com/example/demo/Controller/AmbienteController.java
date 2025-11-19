package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Service.AmbienteService;
import com.example.demo.Service.RecursoService;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController extends BaseController<AmbienteDTO> {
 
    protected AmbienteController(AmbienteService service){
        super(service);
    }

   
}
