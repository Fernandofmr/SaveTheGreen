package datos;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * Clase que se encarga de cifrar los datos
 *
 */
public class PassUtils {
	
	public String hash(String texto) {
		
		try {
			MessageDigest hashDigest = MessageDigest.getInstance("SHA-512");
			byte[] textoBinario = texto.getBytes(Charset.forName("UTF-8"));
			byte[] hashBinario = hashDigest.digest(textoBinario); //Hexadecimal 250 100 20 --> 0xAFdX93
			String hash = ""; //6bM7xG9aaaKM323d (hola) SALT
			for(int i = 0; i < hashBinario.length;i++) {
				byte letra = hashBinario[i];
				hash += Integer.toString((letra & 0xff) + 0x100, 16).substring(1);
			}
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean comprobar(String texto, String hash) {
	//System.out.println("Texto formulario: "+texto);
		String hashTexto = hash(texto);
		//System.out.println("Texto hash:"+hashTexto);
		//System.out.println("BD hash:"+hash);
		
		if(hashTexto.equals(hash)) {
			return true;
		
		}
		else {
			return false;
		}
		//return hashTexto.equals(hash);
	}
	
/*	public static void main(String[] args) {
		PassUtils p = new PassUtils();
		System.out.println(p.hash("12345678"));
	}
*/
}
