package com.ibm.academia.apirest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.models.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>
{
	
	@Query("select c from Cliente c where upper(c.pasion) = upper(?1) and c.salarioMinimo<=?2 and salarioMaximo>=?2 and edadMinima<=?3 and edadMaxima>=?3")
	List<Cliente> findByPasionSalarioEdad(String pasion , Integer salario , Integer edad);
	
	
}
