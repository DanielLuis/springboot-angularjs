package br.com.springboot.app.support;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.springboot.app.domain.Cliente;


public class BaseTest {
	
	
    @Autowired
    public ObjectMapper objectMapper;

    public  Cliente cliente;

    public  List<Cliente> clientes = new ArrayList<Cliente>();


	
    public <T>  String obterJson(T object) {
	    String json = null;

		try {
			json = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return json;
	}

	
	public   Cliente getCliente(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome("Daniel");
        return cliente;
    }


}
