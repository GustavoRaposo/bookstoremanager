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
public class Book {
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
    private Integer pages;
    //indica que o atributo não poderá ser nulo
    @Column(nullable = false)
    private Integer chapters;
    //indica que o atributo não poderá ser nulo
    @Column(nullable = false)
    private String isbn;
    //indica que o atributo devera estar na notação indicada, não poderá ser nulo e deverá ser único
    @Column(name = "publisher_name", nullable = false, unique = true)
    private String publisherName;

    //Relacionamento

    /*
       indica a cardinalidade muitos para um, sendo que o um book possui um Author e
       um Author possui vários Book's
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    private Author author;
}
