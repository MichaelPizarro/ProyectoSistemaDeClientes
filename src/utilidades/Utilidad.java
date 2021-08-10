package utilidades;

public class Utilidad {
	
	
	public Utilidad() {
		
	}
	
	public void limpiarPantalla() {
		for(int i=0; i<20; i++) {
			System.out.println("\n");
		}
	}
	
	public void mostrarMensaje() {
		System.out.println("Se ha limpiado la pantalla.....");
		System.out.println("Fin del Programa");
	}
}
