package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Cliente;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.ClienteDAO;

@RestController
@RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	private ClienteDAO clienteDao;
	
	@GetMapping("/id/{Id}")
	public ResponseEntity<?> buscarClientePorId(@PathVariable Integer Id) 
	{
		Optional<Cliente> oCliente =  clienteDao.buscarPorId(Id);		
		
		if(!oCliente.isPresent())
			throw new NotFoundException(String.format("El producto con ID %d no existe",Id));
		return new ResponseEntity<Cliente>(oCliente.get(), HttpStatus.OK);
	}
	
	@GetMapping("/perfil")
    public ResponseEntity<List<Cliente>> indicarPerfil(@RequestParam String pasion , @RequestParam Integer salario , @RequestParam Integer edad)
	{
        List<Cliente> clientes = clienteDao.findByPasionSalarioEdad(pasion, salario, edad);
		if(clientes.size()>0){
			return ResponseEntity.status(HttpStatus.OK).header("Operacion Exitosa").body(clientes);
		}
		else {
			return ResponseEntity.noContent().build();
		}
    }
	
	@GetMapping("/profile")
    public ResponseEntity<?> indicarProfile(@RequestParam String pasion , @RequestParam Integer salario , @RequestParam Integer edad)
	{
        List<Cliente> clientes = clienteDao.findByPasionSalarioEdad(pasion, salario, edad);
		if(clientes.isEmpty())
			throw new NotFoundException("No existen perfil para esos datos");
		return ResponseEntity.status(HttpStatus.OK).header("Operacion Exitosa").body(clientes);
		
    }
	
}
