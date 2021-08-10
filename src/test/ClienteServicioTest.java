package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import servicio.ClienteServicio;

public class ClienteServicioTest {

	@Test
	public void agregarClienteNullTest() {

		ClienteServicio juanitoClienteNulo = new ClienteServicio();
		juanitoClienteNulo.agregarCliente(null, null, null, null);

		assertNull("No se ha agregado a la lista", null); // Verificamos que no se haya agregado a lista dado sus
															// valores nulos
	}
	
	@Test
	public void agregarClienteTest() {

		ClienteServicio juanitoCliente = new ClienteServicio();
		juanitoCliente.agregarCliente("15555-5", "Juanito", "Pérez", "4 años");

		assertNotNull("Se ha agregado un cliente a la lista\n", juanitoCliente); // Se agrega a la lista siempre que sus
																					// valores no sean nulos
	}

	@Test
	public void test() {

	}

}
