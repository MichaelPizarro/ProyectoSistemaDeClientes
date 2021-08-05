package vista;

import java.util.Scanner;

import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu implements MetodosMenu{
	
	private ClienteServicio clienteServicio;
	private ArchivoServicio archivoServicio;
	private ExportadorCsv exportadorCsv;
	private ExportadorTxt exportadorTxt;
	private String fileName = "Clientes"; //Para exportar el archivo
	private String fileName1 = "DBClientes.csv"; //Para importar el archivo
	private Scanner scanner; 
	
	public void iniciarMenu() {
		//Aqui va el menu con las opciones dentro de un do while
	}

	@Override
	public void listarCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarCliente() {
		// TODO Auto-generated method stub
		
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
