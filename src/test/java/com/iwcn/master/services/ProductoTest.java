package com.iwcn.master.services;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iwcn.master.model.Producto;

public class ProductoTest {

	@Test
	public void testCompleto() {
		Producto p = new Producto(1, "111", "111", "111",  new Integer (1));
		assertEquals(p.getNombre(),"111");
		assertEquals(p.getCodigo(), "111");
		assertEquals(p.getId(), 1);
		assertEquals(p.getDescripcion(), "111");
		assertEquals(p.getPrecio(),  new Integer (1));
		imprimir("Se verifica que se crea un producto completo");
	}
	
	@Test
	public void test() {
		Producto p = new Producto();
		assertEquals(p.getNombre(), null);
		assertEquals(p.getCodigo(), null);
		assertEquals(p.getId(), 0);
		assertEquals(p.getDescripcion(), null);
		assertEquals(p.getPrecio(), null);
		imprimir("Se verifica que se crea un producto");
	}
	
	@Test
	public void testSetId() {
		Producto p = new Producto();
		p.setId(1);
		assertEquals("1", p.getId());
		imprimir("Se verifica que se inserta el 'id'");
	}
	
	@Test
	public void testSetCodigo() {
		Producto p = new Producto();
		p.setCodigo("111");
		assertEquals("111", p.getCodigo());
		imprimir("Se verifica que se inserta el 'código'");
	}
	
	@Test
	public void testSetNombre() {
		Producto p = new Producto();
		p.setNombre("111");
		assertEquals("111", p.getNombre());
		imprimir("Se verifica que se inserta el 'nombre'");
	}
	
	@Test
	public void testSetDescripcion() {
		Producto p = new Producto();
		p.setDescripcion("111");
		assertEquals("111", p.getDescripcion());
		imprimir("Se verifica que se inserta la 'descripcion'");
	}
	
	@Test
	public void testSetPrecio() {
		Producto p = new Producto();
		p.setPrecio(1);
		assertEquals(new Integer(1), p.getPrecio());
		imprimir("Se verifica que se inserta el 'precio'");
	}
	
	private static void imprimir(String text) {
		System.out.println(text);
	}

}