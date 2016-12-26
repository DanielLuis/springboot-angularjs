package br.com.springboot.app.controller;


import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.springboot.app.domain.Cliente;
import br.com.springboot.app.service.ClienteService;
import br.com.springboot.app.support.BaseTest;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest{
    
	@Autowired
    public MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private Cliente cliente;

    private String json;
    
    @Autowired
    public ObjectMapper objectMapper;

    private static String URL_CLIENTE = "/clientes/";
    

    public <T>  String obterJson(T object) {
	    String json = null;

		try {
			json = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return json;
	}
    @Before
    public void setUp() {
    	cliente = new Cliente(Long.valueOf(1),"Daniel");
    	
    	json = obterJson(cliente);
    }



	
    
    @Test
    public void findAllTest() throws Exception{
    	Cliente cliente1 = new Cliente("Daniel"); 
    	Cliente cliente2 = new Cliente("Fabio"); 
    	
    	List<Cliente> clientes = Arrays.asList(cliente1,cliente2);
    	
    	
    	when(clienteService.findAll()).thenReturn(clientes);
    	
    	
    	this.mockMvc.perform(get(URL_CLIENTE)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.description", is("Lorem ipsum")))
        .andExpect(jsonPath("$.title", is("Foo")));
	}

//	public Cliente findOneTest(long id){
//		return clienteRepository.findOne(id);
//	}
//	public List<Cliente> findByNameTest(String nome){
//		return clienteRepository.findByNome(nome);
//	}
//	
    @Test
    public void saveClienteTest() throws Exception{
    	
//    	when(clienteService.saveCliente(any(Cliente.class))).thenReturn(getCliente(Long.valueOf(null)));
//    	
//    	
//			this.mockMvc.perform(post("/clientes/add")
//			    .contentType(MediaType.APPLICATION_JSON)
//			    .content(json))
//			    .andExpect(status().isOk());
//			
//			
//		verif
    	
	}
//	@Transactional(propagation=Propagation.REQUIRED)
//	public void deleteTest(long id){
//		clienteRepository.delete(id);
//	}
	
	

}
