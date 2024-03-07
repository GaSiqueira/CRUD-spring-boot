package com.empresa.loja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.loja.entidade.Produto;

public interface Repositorio extends JpaRepository<Produto, Long>{

}
