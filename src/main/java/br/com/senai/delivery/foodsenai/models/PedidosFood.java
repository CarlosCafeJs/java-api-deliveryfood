package br.com.senai.delivery.foodsenai.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class PedidosFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ClientesFood cliente;

    @ManyToMany
    private List<ProdutosFood> produtos;

    private BigDecimal valorTotal;
    private LocalDateTime dataPedido;
    private String status; 
    private String formaPagamento;

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
    public List<ProdutosFood> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<ProdutosFood> produtos) {
        this.produtos = produtos;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public LocalDateTime getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


}
