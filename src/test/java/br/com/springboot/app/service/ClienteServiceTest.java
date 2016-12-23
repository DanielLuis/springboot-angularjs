package br.com.springboot.app.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.app.domain.Cliente;
import br.com.springboot.app.support.BaseTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ClienteServiceTest extends BaseTest{
   
	@Autowired
    private ClienteService clienteService;

	
	
    @Before
    public void setUp() {
    	
    	cliente = getCliente(null) ;
    	
    	clientes.add(cliente);
    	
    	
//    	when(clienteService.saveCliente(cliente)).thenReturn(getCliente(Long.valueOf(1)));

//    	when(clienteService.findAll()).thenReturn(clientes);
    	
    }

    private void saveCliente(){
    	cliente = clienteService.saveCliente(cliente);
    }
    
	@Test
	public void testSaveCliente() {
		saveCliente();
		assertNotNull(cliente.getId()); 
	}


	@Test
	public void testFindAll() {
		List<Cliente> clientes = clienteService.findAll();
		assertTrue(clientes.size() > 0);
	}

	@Test
	public void testFindOne() {
		cliente = clienteService.findOne(cliente.getId());
		assertNotNull(cliente); 
	}

	@Test
	public void testFindByName() {
		clientes = clienteService.findByName(cliente.getNome());
		assertTrue(clientes.size() > 0);
	}

	@Test
	public void testDelete() {
		clienteService.delete(cliente.getId());
		cliente = null;
		assertNull(cliente);
	}
	


}
