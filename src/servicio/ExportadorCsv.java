package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorCsv extends Exportador {// Esta clase se debe instanciar con polimorfismo Exportador exp = new
												// ExportarCsv

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
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

				bw.write(client.getRunCliente() + "," + client.getNombreCliente() + "," + client.getApellidoCliente()
						+ "," + client.getAniosCliente() + "," + estado + "\n");

			}
			bw.close();
			System.out.println("Datos de clientes exportados correctamente en formato csv.");

		} catch (IOException e) {
			System.out.println("Error al exportar el archivo");
			System.out.println(e.getMessage());
		}

	}

}
