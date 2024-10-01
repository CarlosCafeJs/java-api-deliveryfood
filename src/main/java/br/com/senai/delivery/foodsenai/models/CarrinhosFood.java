package br.com.senai.delivery.foodsenai.models;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tb_carrinho")
public class CarrinhosFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientesFood cliente;

    @ElementCollection
    @CollectionTable(name = "carrinho_produtos", joinColumns = @JoinColumn(name = "carrinho_id"))
    @MapKeyJoinColumn(name = "produto_id")
    private Map<ProdutosFood, Integer> produtos = new HashMap<>();

    public CarrinhosFood() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientesFood getCliente() {
        return cliente;
    }

    public void setCliente(ClientesFood cliente) {
        this.cliente = cliente;
    }

    public Map<ProdutosFood, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<ProdutosFood, Integer> produtos) {
        this.produtos = produtos;
    }
}
