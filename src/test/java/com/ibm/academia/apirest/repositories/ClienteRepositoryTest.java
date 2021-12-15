package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Cliente;

@DataJpaTest
public class ClienteRepositoryTest 
{
	@Autowired
	private ClienteRepository clienteRepository;
	
	@BeforeEach
	void serUp()
	{
		//Given
		clienteRepository.save(DatosDummy.cliente01());
	}
	
	@AfterEach
	void tearDown() 
	{
		clienteRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Perfil bancario por pasion salario y edad")
	void findByPasionSalarioEdad()
	{
		//When
		List<Cliente> expected = (List<Cliente>) clienteRepository.findByPasionSalarioEdad("Shopping", 10000, 20);
		
		//Then
		assertThat(expected.size() == 2).isTrue();
	}

}
