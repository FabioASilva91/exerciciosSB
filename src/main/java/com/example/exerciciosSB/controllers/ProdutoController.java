package com.example.exerciciosSB.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciosSB.model.entities.Produto;
import com.example.exerciciosSB.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {

		produtoRepository.save(produto);

		return produto;
	}
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Produto> obterProdutoPorPaginas(@PathVariable int numeroPagina,
			@PathVariable int qtdePagina){
		if(qtdePagina >= 5) qtdePagina = 5;
		Pageable pageable = PageRequest.of(numeroPagina, qtdePagina);
		return produtoRepository.findAll(pageable);
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> obterPrdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
//	@PutMapping
//	public Produto alterarProduto(@Valid Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//		
//	}
	@DeleteMapping(path = "/{id}")
	public void excluirProduto(@PathVariable int id){
		produtoRepository.deleteById(id);
		
	}

}
