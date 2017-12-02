package com.iwcn.master.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.iwcn.master.model.Producto;
import com.iwcn.master.repositories.ProductoRepository;

@RunWith(SpringRunner.class)
public class DataBaseTest {

	private Producto pi;
	
	private ArrayList<Producto> todosProductos = new ArrayList<Producto> ();
	
	@Mock
	private ProductoRepository productoRepository;
	
	@InjectMocks
	private DatabaseServices dbServices = new DatabaseServices();
	
	@Before
	public void init(){
		pi = new Producto(1, "111", "111", "111",  new Integer (1));
		todosProductos.add(pi);
		
		when(productoRepository.findAll()).thenReturn(todosProductos);
		when(productoRepository.findById(1)).thenReturn(pi);
	}
	
	@Test
	public void testGetProductos() {
		List<Producto> todosProductos = dbServices.getProductos();
		assertEquals(todosProductos.size(), 1);
		verify(productoRepository).findAll();
		imprimir("Se verifica que se llama una vez al método 'selectAll'");
	}

	@Test
	public void testAddProducto() {
        assertEquals(dbServices.getProductos().size(), 1);
        Producto p = new Producto(2, "222", "222", "222",  new Integer (2));
        dbServices.addProducto(p);
        todosProductos.add(p);
        assertEquals(dbServices.getProductos().size(), 2);
        verify(productoRepository).save(p);
		imprimir("Se verifica que se llama una vez al método 'save'");
	}

	@Test
	public void testFindId() {
		Producto pi = dbServices.findId(1);
		assertEquals(pi.getId(), 1);
		assertEquals(pi.getCodigo(), "111");
		assertEquals(pi.getNombre(), "111");
		assertEquals(pi.getDescripcion(), "111");
		assertEquals(pi.getPrecio(), new Integer(1));
		verify(productoRepository).findById(1);
		imprimir("Se verifica que se llama una vez al método 'findById'");
	}

	@Test
	public void testDeleteProducto() {
        assertEquals(dbServices.getProductos().size(), 1);
        Producto p = dbServices.findId(1);
        dbServices.deleteProducto(p.getId(), p.getCodigo(), p.getNombre(), p.getDescripcion(),  p.getPrecio());
        todosProductos.remove(p);
        assertEquals(dbServices.getProductos().size(), 0);
        verify(productoRepository).delete(dbServices.findId(1));
		imprimir("Se verifica que se llama una vez al método 'delete'");
	}

	@Test
	public void testSetProducto() {
        assertEquals(dbServices.getProductos().size(), 1);
        Producto p = new Producto(2, "222", "222", "222", new Integer (2));
        dbServices.setProducto("222", "222", "222", new Integer (2), 1);
        todosProductos.set(0, p);
        assertEquals(dbServices.getProductos().size(), 1);
	}
	
	private static void imprimir(String text) {
		System.out.println(text);
	}

}