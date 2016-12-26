package br.com.springboot.app.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.app.domain.Cliente;
import br.com.springboot.app.domain.ClienteResource;
import br.com.springboot.app.service.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/" , method= RequestMethod.GET)
	public List<ClienteResource> getClientes() {
		return linkRef(clienteService.findAll());
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public Cliente getCliente(@PathVariable long id) {
		return clienteService.findOne(id);
	}
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public Cliente addCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}
	@RequestMapping(value = "/delete/{id}")
	public void deleteCliente(@PathVariable long id) {
		clienteService.delete(id);
	}

	@RequestMapping(value = "/buscar/nome/{nome}")
	public List<Cliente> getClienteByName(@PathVariable String nome) {
		return clienteService.findByName(nome);
	}
	
	private List<ClienteResource> linkRef(List<Cliente> clientes) {
		
		List<ClienteResource> resources = new ArrayList<ClienteResource>();
		
		
		for (Cliente cliente : clientes) {
			
			ClienteResource resource = new ClienteResource(cliente);
			
			Link selfLink = linkTo(ClienteController.class).slash(resource.getIdCliente()).withSelfRel();
			resource.add(selfLink);
			
			resources.add(resource);
		}
		
		return resources;
	}

}
