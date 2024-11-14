package com.example.springboot.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.models.Model;




@Repository
public interface repositorio extends JpaRepository<Model,Long> {


    List<Model> findByNomeContaining(String nome);

}
