package servicio;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;


public class ArchivoServicio extends Exportador {

	public void cargarDatos(String fileName1, List<Cliente> listaClientes) { // Indica el nombre del archivo a cargar
																				// Aplicar implementaciones correspondientes usando FileReader y BufferedReader
																				// para leer archivo
		try {
			File archivo = new File(fileName1); 
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while(line != null) {
				String[] clients = line.split(","); //Se lee el archivo y se separa por " , "
				if(clients.length == 5) {
					
					String run = clients[0];      //Se va agregando la info del archivo a las variables
					String nombre = clients[1];
					String apellido = clients[2];
					String anios = clients[3];
					CategoriaEnum cat = CategoriaEnum.ACTIVO;
					if(clients[4].equals("Activo")) {
						cat = CategoriaEnum.ACTIVO;
					}else if(clients[4].equals("Inactivo")) {
						cat = CategoriaEnum.INACTIVO;
					}
					
					Cliente cl = new Cliente(run,nombre,apellido,anios); //Se pasan las variables por el constructor
					cl.setNombreCategoria(cat);
					
					listaClientes.add(cl); //Se agrega el objeto a la lista
				}
				
				line = br.readLine();
			}
			br.close();
			System.out.println("\n-----------------------------------------------");
			System.out.println("Datos cargados correctamente en la lista");
		}catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
			System.out.println(e.getMessage());	
			
		}catch(IOException e) {
			System.out.println("Error al cargar el archivo");
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		System.out.println("Éste método no exporta nada"); //Éste método no hace nada ya que su labor será desempeñada por otro método

	}

}
