package com.empresa.loja.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.loja.entidade.Produto;
import com.empresa.loja.repositorio.Repositorio;

@RestController
public class Controle {
	@Autowired
	private Repositorio repo;
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Produto p) {
		repo.save(p);
	}
	@GetMapping("/listar")
	public List<Produto> listar(){
		return repo.findAll();
	}
	@GetMapping("/teste")
	public String mensagem() {
		return "Hello world";
	}
	
	@PutMapping("/atualizar/{id}")	
	public void atualizar(@PathVariable Long id, @RequestBody Produto prod){
		Produto p = repo.findById(id).orElse(null);
		if(p != null) {
			p.setNome(prod.getNome());
			p.setValor(prod.getValor());
			repo.save(p);
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deleteProduto(@PathVariable Long id) {
		Produto p = repo.findById(id).orElse(null);
		if(p != null) {
			repo.delete(p);
		}
	}
}
