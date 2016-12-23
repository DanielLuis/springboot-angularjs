package br.com.springboot.app.controller;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.springboot.app.controller.ClienteController;
import br.com.springboot.app.domain.Cliente;
import br.com.springboot.app.service.ClienteService;
import br.com.springboot.app.support.BaseTest;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest extends BaseTest{
    
	@Autowired
    public MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;


    private String json;

    @Before
    public void setUp() {
    	
    	cliente = getCliente(null);
    	
    	json = obterJson(cliente);
    	
    }



	
    
//    @Test
//    public List<Cliente> findAllTest(){
    	
//    	given(this.clienteService.findAll())
//        .willReturn(new VehicleDetails("Honda", "Civic"));
//
//    this.mvc.perform(get("/sboot/vehicle")
//        .accept(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andExpect(content().string("Honda Civic"));
//		return ;
//	}

//	public Cliente findOneTest(long id){
//		return clienteRepository.findOne(id);
//	}
//	public List<Cliente> findByNameTest(String nome){
//		return clienteRepository.findByNome(nome);
//	}
//	
    @Test
    public void saveClienteTest() throws Exception{
			this.mockMvc.perform(post("/clientes/add")
			    .contentType(MediaType.APPLICATION_JSON)
			    .content(json))
			    .andExpect(status().isOk());
    	
	}
//	@Transactional(propagation=Propagation.REQUIRED)
//	public void deleteTest(long id){
//		clienteRepository.delete(id);
//	}
	
	

}
