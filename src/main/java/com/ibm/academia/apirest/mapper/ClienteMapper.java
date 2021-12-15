package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.ClienteDTO;
import com.ibm.academia.apirest.models.entities.Cliente;

public class ClienteMapper 
{
	public static ClienteDTO mapCliente(Cliente cliente)
	{
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setTipoTarjeta(cliente.getTipoTarjeta());
        
        return clienteDTO;
	}

}
