import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ContadorCoincidencias {

	static int totalCoincidencias = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String letraBuscar = "a";
		
		File archivo = new File("texto.txt");
		
		buscarCoincidenciaCaracter(letraBuscar, archivo);
		buscarCoincidenciaPalabra(letraBuscar, archivo);

	}
	
	public static void buscarCoincidenciaCaracter(String letraBuscar, File archivo) {
		totalCoincidencias = 0;
		
		char caracter = letraBuscar.charAt(0);
		
		try {
			if(archivo.exists()) {
				BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
				
				String lineaLeida;
				while((lineaLeida = archivoLeer.readLine()) != null) {
					
					char[] arregloCaracteres = lineaLeida.toCharArray();
					
					for(int i = 0 ; i < arregloCaracteres.length ; i++) {
						
						if(arregloCaracteres[i] == caracter) {
							totalCoincidencias = totalCoincidencias + 1;
						}
					}
				}
				archivoLeer.close();
			}
			
			System.out.println("\n\nEl caracter: " + letraBuscar + 
					" se encuentra: " + totalCoincidencias + 
					" veces en el archivo buscando por CARACTER");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	} 
	
	public static void buscarCoincidenciaPalabra(String letraBuscar, File archivo) {
		totalCoincidencias = 0;
		
		try {
			if(archivo.exists()) {
				
				BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
				String lineaLeida;
				
				while((lineaLeida = archivoLeer.readLine()) != null) {
					
					String[] partes = lineaLeida.split(" ");
					
					for(int i = 0 ; i < partes.length ; i++) {
						if(partes[i].equals(letraBuscar)) {
							totalCoincidencias = totalCoincidencias + 1;
						}
					}
				}
				
				archivoLeer.close();
			}
			
			System.out.println("\n\nEl caracter: " + letraBuscar + 
					" se encuentra: " + totalCoincidencias + 
					" veces en el archivo buscando por PALABRA");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	} 

}














