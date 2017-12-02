package com.iwcn.master.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import com.iwcn.master.controllers.AppRestController;
import com.iwcn.master.model.Producto;

@RunWith(SpringRunner.class)
public class AppRestTest {
	
	private Producto pi;
	
	private ArrayList<Producto> todosProductos = new ArrayList<Producto> ();
	
	@Mock
	private DatabaseServices dbServices;
	
	@InjectMocks
	private AppRestController appRest = new AppRestController();
	
	public void AppRestController () {
		
	}
	
	@Before
	public void init(){
		pi = new Producto(1, "111", "111", "111",  new Integer (1));
		todosProductos.add(pi);
		
		when(dbServices.findId(1)).thenReturn(pi);
		when(dbServices.getProductos()).thenReturn(todosProductos);
		
	}
	@Test
	public void testListaProducto() {
		assertEquals(appRest.listaProducto().size(), 1);
		verify(dbServices).getProductos();
		imprimir("Se verifica que se llama una vez al método 'getProductos'");
	}
	
	@Test
	public void testNuevoProducto2() {
		assertEquals(appRest.listaProducto().size(), 1);
		Producto p = new Producto(2, "222", "222", "222",  new Integer (2));
		appRest.nuevoProducto2(p);
		todosProductos.add(p);
		assertEquals(appRest.listaProducto().size(), 2);
		verify(dbServices).addProducto(p);
		imprimir("Se verifica que se llama una vez al método 'addProducto'");
	}
	
	@Test
	public void testMostrarProducto() {
		Producto p = appRest.mostrarProducto("1");
		assertEquals(p.getId(), 1);
		assertEquals(p.getCodigo(), "111");
		assertEquals(p.getNombre(), "111");
		assertEquals(p.getDescripcion(), "111");
		assertEquals(p.getPrecio(), new Integer(1));
		verify(dbServices).findId(1);
		imprimir("Se verifica que se llama una vez al método 'findId'");
	}		
	@Test
	public void testBorrarProducto() {
		assertEquals(appRest.listaProducto().size(), 1);
		Producto p = appRest.mostrarProducto("1");
		appRest.borrarProducto("1");
		todosProductos.remove(p);
		assertEquals(appRest.listaProducto().size(), 0);
		verify(dbServices).deleteProducto(1, "111", "111", "111", 1);
		imprimir("Se verifica que se llama una vez al método 'deleteProducto'");
	}
	@Test
	public void testModificarProducto() {
		assertEquals(appRest.listaProducto().size(), 1);
		Producto p = new Producto(2, "222", "222", "222",  new Integer (2));
		appRest.modificarProducto(p);
		todosProductos.set(0, p);
		assertEquals(appRest.listaProducto().size(), 1);
	}
	private static void imprimir(String text) {
		System.out.println(text);
	}
	
}