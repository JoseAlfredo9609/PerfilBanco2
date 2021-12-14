package com.ibm.academia.apirest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente implements Serializable
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
			
		private String pasion;
		
		@Positive(message = "Debe ser mayor a cero")
		@Column (name = "salario_minimo")
		private Integer salarioMinimo;
		
		@Positive(message = "Debe ser mayor a cero")
		@Column (name = "salario_maximo")
		private Integer salarioMaximo;
		
		@Positive(message = "Debe ser mayor a cero")
		@Column (name = "edad_minima")
		private Integer edadMinima;
		
		@Positive(message = "Debe ser mayor a cero")
		@Column (name = "edad_maxima")
		private Integer edadMaxima;
		
		@Column (name = "tipo_tarjeta")
		private String tipoTarjeta;
		
	private static final long serialVersionUID = 5407622227884567891L;

}
