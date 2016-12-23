package br.com.springboot.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.app.domain.Cliente;


@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente,Long> {
	
	public List<Cliente> findAll();
	public Cliente findOne(long id);
	public List<Cliente> findByNome(String nome);

}
