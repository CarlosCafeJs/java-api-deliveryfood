package br.com.senai.delivery.foodsenai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.delivery.foodsenai.models.CarrinhosFood;
import br.com.senai.delivery.foodsenai.models.ProdutosFood;
import br.com.senai.delivery.foodsenai.repository.CarrinhoRepository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Service
public class CarrinhosService {

    @Autowired
    private CarrinhoRepository repositoryCarrinho;

    public BigDecimal calcularTotal(Map<ProdutosFood, Integer> produtos) {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<ProdutosFood, Integer> entry : produtos.entrySet()) {
            BigDecimal precoProduto = entry.getKey().getPreco();
            Integer quantidade = entry.getValue();
            BigDecimal subtotal = precoProduto.multiply(BigDecimal.valueOf(quantidade));
            total = total.add(subtotal);
        }
        return total;
    }

    public CarrinhosFood salvarCarrinho(CarrinhosFood carrinho) {
        return repositoryCarrinho.save(carrinho);
    }

    public Optional<CarrinhosFood> buscarCarrinhoPorId(Long id) {
        return repositoryCarrinho.findById(id);
    }

    public void deletarCarrinho(Long id) {
        repositoryCarrinho.deleteById(id);
    }

    public void adicionarProduto(Long carrinhoId, ProdutosFood produto, Integer quantidade) {
        CarrinhosFood carrinho = buscarCarrinhoPorId(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        Map<ProdutosFood, Integer> produtos = carrinho.getProdutos();
        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade);
        carrinho.setProdutos(produtos);
        salvarCarrinho(carrinho);
    }

    public void removerProduto(Long carrinhoId, ProdutosFood produto) {
        CarrinhosFood carrinho = buscarCarrinhoPorId(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        Map<ProdutosFood, Integer> produtos = carrinho.getProdutos();
        produtos.remove(produto);
        carrinho.setProdutos(produtos);
        salvarCarrinho(carrinho);
    }

    public void atualizarQuantidade(Long carrinhoId, ProdutosFood produto, Integer novaQuantidade) {
        CarrinhosFood carrinho = buscarCarrinhoPorId(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        Map<ProdutosFood, Integer> produtos = carrinho.getProdutos();
        if (novaQuantidade <= 0) {
            produtos.remove(produto);
        } else {
            produtos.put(produto, novaQuantidade);
        }
        carrinho.setProdutos(produtos);
        salvarCarrinho(carrinho);
    }
}
