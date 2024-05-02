package br.com.edu.infnet.tp01springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    int id;
    String nome;
    String sobrenome;
    String email;
    String idade;
    String genero;
}
