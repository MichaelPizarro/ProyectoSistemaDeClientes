package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorTxt extends Exportador {// Esta clase se debe instanciar con polimorfismo Exportador exp = new
												// ExportarTxt

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// Implementar acciones correspondientes utilizando PrintWriter y FileWriter
		// para exportar archivos
		try {

			File file = new File(fileName);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Cliente client : listaClientes) {
				String estado = "Activo";
				if (client.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
					estado = "Activo";
				} else if (client.getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
					estado = "Inactivo";
				}

				bw.write("---------Datos del Cliente---------------\n");
				bw.write("\nRUN del Cliente: " + client.getRunCliente() + "\n");
				bw.write("\nNombre del Cliente: " + client.getNombreCliente() + "\n");
				bw.write("\nApellido del Cliente: " + client.getApellidoCliente() + "\n");
				bw.write("\nAños del Cliente: " + client.getAniosCliente() + "\n");
				bw.write("\nCategoría del Cliente: " + estado + "\n");
				bw.write("\n-----------------------------------------------\n");

			}
			bw.close();
			System.out.println("Datos de clientes exportados correctamente en formato txt.");

		} catch (IOException e) {
			System.out.println("Error al exportar el archivo");
			System.out.println(e.getMessage());
		}

	}

}
