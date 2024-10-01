package br.com.senai.delivery.foodsenai.controllers.carrinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senai.delivery.foodsenai.models.CarrinhosFood;
import br.com.senai.delivery.foodsenai.models.ProdutosFood;
import br.com.senai.delivery.foodsenai.services.CarrinhosService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhosFoodController {

    @Autowired
    private CarrinhosService carrinhosService;

    @PostMapping
    public CarrinhosFood criarCarrinho(@RequestBody CarrinhosFood carrinho) {
        return carrinhosService.salvarCarrinho(carrinho);
    }

    @GetMapping("/{id}/total")
    public BigDecimal getTotal(@PathVariable Long id) {
        CarrinhosFood carrinho = carrinhosService.buscarCarrinhoPorId(id)
            .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        return carrinhosService.calcularTotal(carrinho.getProdutos());
    }

    @DeleteMapping("/{id}")
    public void deletarCarrinho(@PathVariable Long id) {
        carrinhosService.deletarCarrinho(id);
    }

    @PostMapping("/{carrinhoId}/adicionar")
    public void adicionarProduto(@PathVariable Long carrinhoId, @RequestBody AdicionarProdutoRequest request) {
        ProdutosFood produto = new ProdutosFood();
        produto.setId(request.getProdutoId());
        carrinhosService.adicionarProduto(carrinhoId, produto, request.getQuantidade());
    }

    @DeleteMapping("/{carrinhoId}/remover")
    public void removerProduto(@PathVariable Long carrinhoId, @RequestParam Long produtoId) {
        ProdutosFood produto = new ProdutosFood();
        produto.setId(produtoId);
        carrinhosService.removerProduto(carrinhoId, produto);
    }

    @PutMapping("/{carrinhoId}/atualizar")
    public void atualizarQuantidade(@PathVariable Long carrinhoId, @RequestParam Long produtoId, @RequestParam Integer novaQuantidade) {
        ProdutosFood produto = new ProdutosFood();
        produto.setId(produtoId);
        carrinhosService.atualizarQuantidade(carrinhoId, produto, novaQuantidade);
    }
}

class AdicionarProdutoRequest {
    private Long produtoId;
    private Integer quantidade;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
