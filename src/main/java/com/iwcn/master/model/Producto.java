package com.iwcn.master.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String codigo;
	
	private String nombre;
	
	private String descripcion;
	
	private Integer precio;
	
}
