package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.mapper.ClienteMapper;
import com.ibm.academia.apirest.models.dto.ClienteDTO;
import com.ibm.academia.apirest.models.entities.Cliente;
import com.ibm.academia.apirest.services.ClienteDAO;

@RestController
@RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	private ClienteDAO clienteDao;
	
	
	/**
	 * Enpoint para encontrar el tipo de tarjetas disponibles dependiendo de los parametros
	 * @param pasion Parametro para indicar la pasion del objeto tipo Cliente
	 * @param salario Parametro para indicar el salario del objeto tipo Cliente
	 * @param edad Parametro para indicar la edad del tipo Cliente
	 * NotFoundException En caso de que falle buscando el tipo de tarjeta
	 * @return Tipo de tarjeta para el perfil del cliente.
	 * @author JAMR
	 */
	@GetMapping("/perfil")
    public ResponseEntity<?> indicarPerfil(@RequestParam String pasion , @RequestParam Integer salario , @RequestParam Integer edad)
	{
		List<Cliente> clientes = null;
		clientes = clienteDao.findByPasionSalarioEdad(pasion, salario, edad);
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);	
    }
	
	/**
	 * Enpoint para encontrar el tipo de tarjetas disponibles dependiendo de los parametros
	 * @param pasion Parametro para indicar la pasion del objeto tipo Cliente
	 * @param salario Parametro para indicar el salario del objeto tipo Cliente
	 * @param edad Parametro para indicar la edad del tipo Cliente
	 * NotFoundException En caso de que falle buscando el tipo de tarjeta
	 * @return Tipo de tarjeta para el perfil del cliente.
	 * @author JAMR
	 */
	@GetMapping("/perfil/dto")
    public ResponseEntity<?> indicarPerfilDTO(@RequestParam String pasion , @RequestParam Integer salario , @RequestParam Integer edad)
	{
        List<Cliente> clientes = clienteDao.findByPasionSalarioEdad(pasion, salario, edad);

		List<ClienteDTO> listaClientes = clientes
				.stream()
				.map(ClienteMapper::mapCliente)
				.collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).header("Operacion Exitosa").body(listaClientes);
		
    }
	
}
