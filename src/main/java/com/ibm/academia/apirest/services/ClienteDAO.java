package com.ibm.academia.apirest.services;

import java.util.List;

import com.ibm.academia.apirest.models.entities.Cliente;

public interface ClienteDAO 
{
	
	List<Cliente> findByPasionSalarioEdad(String pasion , Integer salario , Integer edad);
	
}
