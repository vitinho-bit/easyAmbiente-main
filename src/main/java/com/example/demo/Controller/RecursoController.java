package com.example.demo.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Service.RecursoService;



@RestController
@RequestMapping("/recursos")
public class RecursoController extends BaseController<RecursoDTO> {
 
    private RecursoService service;

    protected RecursoController(RecursoService service){
        super(service);
        this.service = service;
    }

  


}
