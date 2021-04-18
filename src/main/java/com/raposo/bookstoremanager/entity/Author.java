package com.raposo.bookstoremanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
Classe que representa a entidade Author do modelo relacional
 */


//Notação que indica que esta classe é uma entidade
@Entity

//Notações Lombok que adiciona os metodos de encapsulamento
@Data
//Notações Lombok que torna a classe no padrão builder
@Builder
//Notações Lombok que cria um contrutor sem argumentos
@NoArgsConstructor
//Notações Lombok que cria um contrutor com todos argumentos
@AllArgsConstructor
public class Author {
    //Chave primária
    @Id
    //cria um valor automatico ao criar um objeto desta classe
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Atributos

    //indica que o atributo não poderá ser nulo e deverá ser único
    @Column(nullable = false, unique = true)
    private String name;
    //indica que o atributo não poderá ser nulo
    @Column(nullable = false)
    private Integer age;
}
