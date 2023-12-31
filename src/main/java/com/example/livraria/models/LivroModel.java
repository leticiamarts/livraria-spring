package com.example.livraria.models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "livros")
public class LivroModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String nome;
  private Double valor;
  private String genero;
  private String autor;
  private String editora;
  private int anoPublicacao;

  @OneToOne(mappedBy = "livro")
  @JsonIgnoreProperties("livro")
  private EstoqueModel estoque;
  
  @OneToMany(mappedBy = "livro")
  @JsonIgnore
  private Set<ItemModel> itens;
  
}