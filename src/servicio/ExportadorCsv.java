package servicio;

import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador{//Esta clase se debe instanciar con polimorfismo Exportador exp = new ExportarCsv

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// Implementar acciones correspondientes utilizando PrintWriter y FileWriter para exportar archivos
		
	}

}
