package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.models.entities.Cliente;

public class DatosDummy 
{
	public static Cliente cliente01()
	{
		return new Cliente(null, "Shopping", 7000, 14900, 18, 23, "Afinity Card");
	}
}
