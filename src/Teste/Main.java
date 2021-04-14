package Teste;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Main {
	
	public static void main(String[] args) {
		try{
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			
			SecretKey  chaveSecreta = kg.generateKey();
		
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");//Coração da biblioteca crypto ele é o responsavel por criptografar 		
			cipher.init(Cipher.ENCRYPT_MODE, chaveSecreta);
						
			byte[] text = "A".getBytes("UTF-8");
			byte[] encText = cipher.doFinal(text);
			
			
			//System.out.println("Encrypted: "+new String(encText).chars().count());
			System.out.println("Encrypted: "+new String(encText).chars().count());
			System.out.println("Encrypted: "+new String(encText));
			
			cipher.init(Cipher.DECRYPT_MODE, chaveSecreta);
			byte[] decText = cipher.doFinal(encText);
			
			System.out.println("Decrypted: "+new String(decText).chars().count());
			System.out.println("Decrypted: "+new String(decText));

		}
		catch(Exception e){
			
		}
	}
	 
}
