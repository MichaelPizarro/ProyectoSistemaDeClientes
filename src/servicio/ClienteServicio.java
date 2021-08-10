package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {

	private List<Cliente> listaClientes;

	public ClienteServicio() {
		super();
		this.listaClientes = new ArrayList<>();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void listarClientes() {

		this.listaClientes.stream().forEach( // Utilizamos la librearía Streams para mostrar la lista de clientes
				(cliente) -> {
					System.out.println("-------------Datos del Cliente-------------");
					System.out.println("\nRUN del Cliente: " + cliente.getRunCliente());
					System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
					System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
					System.out.println("Años como Cliente: " + cliente.getAniosCliente());
					String estado = "";
					if (cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
						estado = "Activo"; // Cambiamos el valor de la variable tal como lo pide el texto
					} else if (cliente.getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
						estado = "Inactivo";
					}
					System.out.println("Categoría del Cliente: " + estado);
					System.out.println("\n--------------------------------------------");
				}

		);
	}

	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente) {

		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente);
		
		
		
		if (runCliente != null && nombreCliente != null && apellidoCliente != null && aniosCliente != null) {
			this.listaClientes.add(cliente);
			System.out.println("Se ha agregado un cliente a la lista\n");

		}else {
			System.out.println("No se ha agregado a la lista");
		}
		
		//if(runCliente == null && nombreCliente == null && apellidoCliente == null && aniosCliente == null) {
			//System.out.println("No se ha agregado a la lista");
		
		//}
		
		

	}

	public void editarCliente(int posicion, Cliente client) {

		this.listaClientes.set(posicion, client); // Modificamos el objeto en la posición indicada

	}

}
