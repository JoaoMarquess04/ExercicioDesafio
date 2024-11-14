package com.example.springboot.dtos;


import java.io.Serializable;



public class ModelDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private String nome;
    private String data;

    // Construtores
    public ModelDTO() {}

    public ModelDTO( String nome, String data) {
        
        this.nome = nome;
        this.data = data;
    }

    // Getters e Setters
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
