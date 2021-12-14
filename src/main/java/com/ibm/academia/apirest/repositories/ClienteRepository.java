package com.ibm.academia.apirest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>
{
	@Query("select c from Cliente c where c.id = ?1")
	public Optional<Cliente> buscarPorId(Integer id);
	
	@Query("select c from Cliente c where c.pasion = ?1 and c.salarioMinimo<=?2 and salarioMaximo>=?2 and edadMinima<=?3 and edadMaxima>=?3")
	List<Cliente> findByPasionSalarioEdad(String pasion , Integer salario , Integer edad);
	
	
}
