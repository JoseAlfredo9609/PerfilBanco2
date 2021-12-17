package com.ibm.academia.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entities.Cliente;
import com.ibm.academia.apirest.repositories.ClienteRepository;

@Service
public class ClienteDAOImpl implements ClienteDAO
{

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findByPasionSalarioEdad(String pasion, Integer salario, Integer edad) {
		
		List<Cliente>clientes = clienteRepository.findByPasionSalarioEdad(pasion, salario, edad);
		
		if(clientes.isEmpty())
			throw new NotFoundException("No existe perfil para esos datos");
		
		return clienteRepository.findByPasionSalarioEdad(pasion, salario, edad);
	}
	
	
}
