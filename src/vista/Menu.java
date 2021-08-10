package vista;


import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu implements MetodosMenu {

	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv;
	private ExportadorTxt exportadorTxt;
	private String fileName = "Clientes"; // Para exportar el archivo
	private String fileName1 = "DBClientes.csv"; // Para importar el archivo
	private Scanner scanner = new Scanner(System.in);
	
	public Menu() {

	}

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

			switch (opcion) { //Switch para llamar a los métodos
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
		int opcion = 0, op = 0, posicion = -1, contador = 0; // Se definen las variables para las opciones que se van a
		Cliente client = new Cliente();                      // seleccionar
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
			System.out.println("\nIngrese RUN del Cliente a editar:"); // Se ingresa el RUN del cliente a editar
			run = scanner.nextLine();

			for (Cliente list : clienteServicio.getListaClientes()) {
				if (list.getRunCliente().equals(run)) { // Buscamos la ubicación en la lista del cliente a editar
					posicion = contador;
				}
				contador++;
			}

			if (posicion >= 0) { // Si la pocicion es mayor o igual a cero significa que encontró un cliente
				client = clienteServicio.getListaClientes().get(posicion);

				if (opcion == 1) {
					do {
						System.out.println("\n-----Actualizando estado del Cliente----");
						System.out.println("El estado actual es: " + client.getNombreCategoria());
						System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
						System.out.println("2.-Si desea mantener el estado del cliente Activo");
						System.out.println("\nIngrese opcion: ");

						op = scanner.nextInt();
						scanner.nextLine();
						// System.out.println("----------------------------------------");
						if (op == 1) {
							client.setNombreCategoria(CategoriaEnum.INACTIVO); // Cambiamos el estado a inactivo
						} else if (op == 2) {
							client.setNombreCategoria(CategoriaEnum.ACTIVO);
						}

					} while (op < 1 || op > 2);

				} else if (opcion == 2) {

					do {
						System.out.println("----Actualizando datos del Cliente-----");
						System.out.println("\n1.-El RUN del Cliente es: " + client.getRunCliente());
						System.out.println("2.-El Nombre del Cliente es: " + client.getNombreCliente());
						System.out.println("3.-El Apellido del Cliente es: " + client.getApellidoCliente());
						System.out.println("4.-Los años como Cliente son: " + client.getAniosCliente());
						System.out.println("\nIngrese opcion a editar de los datos del cliente:");
						op = scanner.nextInt();
						scanner.nextLine();
						

						switch (op) { //Switch para setear los atributos según la opción seleccionada
						case 1:
							System.out.println("\n1.-Ingrese nuevo RUN del Cliente:");
							String run2 = scanner.nextLine();
							client.setRunCliente(run2);
							break;
						case 2:
							System.out.println("2.-Ingrese nuevo Nombre del Cliente:");
							String name = scanner.nextLine();
							client.setNombreCliente(name);
							break;
						case 3:
							System.out.println("3.-Ingrese nuevo Apellido del Cliente:");
							String surname = scanner.nextLine();
							client.setApellidoCliente(surname);
							break;
						case 4:
							System.out.println("4.-Ingrese nuevos años como Cliente:");
							String years = scanner.nextLine();
							client.setAniosCliente(years);
							break;
						default:
							System.out.println("Opción ingresada no válida");
						}

					} while (op < 1 || op > 4);

				}

			} else {
				System.out.println("El cliente no se encuentra en la lista"); // Si la posicion se mantiene con el valor
																				// inicial no existe el cliente buscado
			}

			clienteServicio.editarCliente(posicion, client);
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");

		} while (opcion < 1 || opcion > 2);

	}

	@Override
	public void importarDatos() {
		System.out.println("---------Cargar Datos en Windows---------------");
		System.out.println("\nIngresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		String ruta = scanner.nextLine().trim();
		String rutaArchivo = ruta + "\\" + this.fileName1;
		this.archivoServicio = new ArchivoServicio();
		archivoServicio.cargarDatos(rutaArchivo, clienteServicio.getListaClientes()); //Pasamos la ruta y la lista para cargar info
		
		

	}

	@Override
	public void exportarDatos() {
		int op = 0;
		do {
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Seleccione el formato a exportar:");
			System.out.println("1.-Formato csv");
			System.out.println("2.-Formato txt");
			System.out.println("\nIngrese una opción para exportar:");
			System.out.println("----------------------------------");
			op = scanner.nextInt();
			scanner.nextLine();

		} while (op < 1 || op > 2);
		
		if(op == 1) {
			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			String ruta = scanner.nextLine().trim();
			String rutaArchivo = ruta + "\\" + this.fileName + ".csv";
			this.exportadorCsv = new ExportadorCsv();
			exportadorCsv.exportar(rutaArchivo, clienteServicio.getListaClientes()); //Enviamos ruta y lista clientes
		}else if(op == 2) {
			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			String ruta = scanner.nextLine().trim();
			String rutaArchivo = ruta + "\\" + this.fileName + ".txt";
			this.exportadorTxt = new ExportadorTxt();
			exportadorTxt.exportar(rutaArchivo, clienteServicio.getListaClientes()); //Enviamos ruta y lista clientes
		}
		
		

	}

	@Override
	public void terminarPrograma() { //Aqui procedemos a cerrar el programa
		Utilidad util = new Utilidad();
		util.limpiarPantalla(); //Limpiamos y mostramos mensaje
		util.mostrarMensaje();

	}
	
}
