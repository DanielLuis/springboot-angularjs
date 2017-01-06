package br.com.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.app.domain.Cliente;
import br.com.springboot.app.repository.ClienteRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class ClienteService 
{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(long id){
		clienteRepository.delete(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Cliente saveCliente(Cliente cliente){
		 return clienteRepository.save(cliente);
	}

	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}

	public Cliente findOne(long id){
		return clienteRepository.findOne(id);
	}
	public List<Cliente> findByName(String nome){
		return clienteRepository.findByNome(nome);
	}
	


}
