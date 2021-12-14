package com.ibm.academia.apirest.services;

import java.util.List;
import java.util.Optional;

import com.ibm.academia.apirest.entities.Cliente;

public interface ClienteDAO 
{
	public Optional<Cliente> buscarPorId(Integer id);
	
	List<Cliente> findByPasionSalarioEdad(String pasion , Integer salario , Integer edad);
	
}
