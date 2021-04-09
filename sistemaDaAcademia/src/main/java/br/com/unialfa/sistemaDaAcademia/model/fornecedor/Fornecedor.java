package br.com.unialfa.sistemaDaAcademia.model.fornecedor;

import br.com.unialfa.sistemaDaAcademia.model.produto.Produto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    @ManyToMany
    private List<Produto> produtos;
}