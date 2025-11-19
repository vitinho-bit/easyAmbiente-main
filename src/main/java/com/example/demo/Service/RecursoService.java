package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Entity.RecursoEntity;
import com.example.demo.Repository.RecursoRepository;



@Service
public class RecursoService extends BaseService<RecursoEntity, RecursoDTO>{

    private RecursoRepository repository;

    protected RecursoService(RecursoRepository repository){
        super(repository);
        this.repository = repository;
    }
   
   

}
