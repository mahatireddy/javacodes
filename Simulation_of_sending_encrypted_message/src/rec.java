import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class rec {
	static SecretKey key;
	private int key_size =128;   // Can be 128 192 256
	private Cipher encryptionCipher;
	private static int T_LEN=128;
	static private byte[] IV;
public void intkey(String secretkey,String  IV) {
		
		key = new SecretKeySpec(decode(secretkey),"AES");
		this.IV=decode(IV);
		
	}

public static String decrypt(String encryptedmsg) throws Exception {


	byte[] msginBytes=decode(encryptedmsg);
	Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
	
	GCMParameterSpec spec = new GCMParameterSpec(T_LEN,IV);
	
	decryptionCipher.init(Cipher.DECRYPT_MODE,key,spec);        //Initializing decryption       needs 2 parameters
			
	byte[]decryptedBytes = decryptionCipher.doFinal(msginBytes);
	
	return new String(decryptedBytes);
	
}
private static String encode(byte[] data) {             //Encode
	
	
	return Base64.getEncoder().encodeToString(data);         // Msg written will be stored in byte array
}


	//Decrypting msg
private static byte[] decode(String data) {            //Decode
	
	
	return Base64.getDecoder().decode(data);         // Msg Decoding
	
}

public static void main(String args[]) {
	rec recieve = new rec();
	recieve.intkey("NrZbHFh3hwbOBr5EusSX7g==","TiCH7lQ+AQNraYFH");
	String decryptedmsg = null;
	try {
		decryptedmsg = rec.decrypt("Sqg2E/YStcXTSrLRBMLF5E7e+LSLgQ==");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Decrypted Msg:"+decryptedmsg);
}



}
