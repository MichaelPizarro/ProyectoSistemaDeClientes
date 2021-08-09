package vista;

import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu implements MetodosMenu {

	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio;
	private ExportadorCsv exportadorCsv;
	private ExportadorTxt exportadorTxt;
	private String fileName = "Clientes"; // Para exportar el archivo
	private String fileName1 = "DBClientes.csv"; // Para importar el archivo
	private Scanner scanner = new Scanner(System.in);

	public void iniciarMenu() {
		int opcion = 0;

		do { // Lista con opciones dentro de un ciclo Do While

			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.println("Ingrese una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				listarCliente();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente();
				break;
			case 4:
				importarDatos();
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("La opción ingresada no es válida");
			}

		} while (opcion != 6);
	}

	@Override
	public void listarCliente() {

		clienteServicio.listarClientes();// Se llama al método para mostrar la lista por consola

	}

	@Override
	public void agregarCliente() {
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("\nIngresa RUN del Cliente: ");
		String runCliente = scanner.nextLine().trim();
		System.out.println("\nIngresa Nombre del Cliente: ");
		String nombreCliente = scanner.nextLine().trim();
		System.out.println("\nIngresa Apellido del Cliente: ");
		String apellidoCliente = scanner.nextLine().trim();
		System.out.println("\nIngresa años como Cliente: ");
		String aniosCliente = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente); // Se llama al método
																									// y se envían los
																									// valores
	}

	@Override
	public void editarCliente() {
		int opcion = 0, op = 0, posicion = -1, contador = 0; //Se definen las variables para las opciones que se van a seleccionar
		String run = "";
		do {
			System.out.println("-------------Editar Cliente-------------");
			System.out.println("Seleccione qué desea hacer:");
			System.out.println("1.-Cambiar el estado del Cliente");
			System.out.println("2.-Editar los datos ingresados del Cliente");
			System.out.println("\nIngrese opcion:");
			opcion = scanner.nextInt();
			scanner.nextLine();

			System.out.println("\n----------------------------------------");
			System.out.println("\nIngrese RUN del Cliente a editar:"); //Se ingresa el RUN del cliente a editar
			run = scanner.nextLine();

			for (Cliente list : clienteServicio.getListaClientes()) {
				if (list.getRunCliente().equals(run)) { //Buscamos la ubicación en la lista del cliente a editar
					posicion = contador;
				}
				contador++;
			}

			if (posicion >= 0) { //Si la pocicion es mayor o igual a cero significa que encontró un cliente
				Cliente client = clienteServicio.getListaClientes().get(posicion);
				if (opcion == 1) {
					do {
						System.out.println("\n-----Actualizando estado del Cliente----");
						System.out.println("El estado actual es: " + client.getNombreCategoria());
						System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
						System.out.println("2.-Si desea mantener el estado del cliente Activo");
						System.out.println("\nIngrese opcion: ");

						op = scanner.nextInt();
						scanner.nextLine();
						System.out.println("----------------------------------------");
						if (op == 1) {
							client.setNombreCategoria(CategoriaEnum.INACTIVO); //Cambiamos el estado a inactivo
						} else if (op == 2) {
							client.setNombreCategoria(CategoriaEnum.ACTIVO);
						}

					} while (op < 1 || op > 2);

				} else if (opcion == 2) {

				}

			} else {
				System.out.println("El cliente no se encuentra en la lista"); //Si la posicion se mantiene con el valor inicial no existe el cliente buscado
			}

		} while (opcion < 1 || opcion > 2);

	}

	@Override
	public void importarDatos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub

	}

}
