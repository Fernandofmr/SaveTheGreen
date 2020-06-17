package modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FicheroClientes {
	
	public void escribeArchivo(String nombre) {
			
			String contenido="Hola a todos, sigo probando pero ¡no lo consigo!";
			
			File f;
			FileWriter w;
			BufferedWriter bw;
			PrintWriter wr;
			
			try {
				
				f=new File(nombre);
				w=new FileWriter(f);
				bw=new BufferedWriter(w);
				wr=new PrintWriter(bw);
				
				
				w.write(contenido);
				
				bw.close();
				wr.close();
				
				
			}catch(Exception e) {
				
				e.getMessage();
				
			}
			
		}

}
