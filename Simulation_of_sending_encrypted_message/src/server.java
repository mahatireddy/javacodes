import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Server Socket: Waits for request to come over the network

public class server {
	
	
	
	private static SecretKey key;
	private int key_size = 128; // Can be 128 192 256
	private static Cipher encryptionCipher;
	private static int T_LEN = 128; // Tag Length they can be either 128 120 112 104 96
	static private byte[] IV;

	public void init() throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance("AES"); // Key Generation
		generator.init(key_size); // Initializing key
		key = generator.generateKey();

	}
	
	public void intkey(String secretkey,String  IV) {
		
		key = new SecretKeySpec(decode(secretkey),"AES");
		this.IV=decode(IV);
		
	}
	public static String encrypt1(String msg) throws Exception {
		
		byte[] msginBytes=msg.getBytes();
		Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");     //GCM:Specifies the set of parameters required by a Cipher
																			   //NoPadding:2 n-uncount Padding is unnecessary words or information used to make a piece of writing or a speech longer.
		
		GCMParameterSpec spec= new GCMParameterSpec(T_LEN,IV);
		encryptionCipher.init(Cipher.ENCRYPT_MODE,key,spec);       //Initializing encryption
		
		IV=encryptionCipher.getIV();
		
		//Encryption 
		byte[]encryptedBytes = encryptionCipher.doFinal(msginBytes);
		
		
		return encode(encryptedBytes);
				
		//Encrypting msg
	}

	public static String encrypt(String msg) throws Exception {

		byte[] msginBytes = msg.getBytes();
		encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding"); // GCM:Specifies the set of parameters
																		    // required by a Cipher
																			// NoPadding:2 n-uncount Padding is
																			// unnecessary words or information used to
																			// make a piece of writing or a speech
																			// longer.

		encryptionCipher.init(Cipher.ENCRYPT_MODE, key); // Initializing encryption

		IV = encryptionCipher.getIV();

		// Encryption
		byte[] encryptedBytes = encryptionCipher.doFinal(msginBytes);

		return encode(encryptedBytes);

		// Encrypting msg
	}

	public String decrypt(String encryptedmsg) throws Exception {

		byte[] msginBytes = decode(encryptedmsg);
		Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");

		GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);

		decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec); // Initializing decryption needs 2 parameters

		byte[] decryptedBytes = decryptionCipher.doFinal(msginBytes);

		return new String(decryptedBytes);

	}

	private static String encode(byte[] data) { // Encode

		return Base64.getEncoder().encodeToString(data); // Msg written will be stored in byte array
	}

	// Decrypting msg
	private byte[] decode(String data) { // Decode

		return Base64.getDecoder().decode(data); // Msg Decoding

	}

	public static void exportkey() {
		System.out.println("Secret Key:"+encode(key.getEncoded()));
		System.out.println("IV:"+encode(IV));
	}

	public static void main(String args[]) throws Exception {

		Socket socket = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader bf = null;
		BufferedWriter bw = null;

		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(8878);

		while (true) {
			
			server aes = new server();
			aes.init();
			Scanner sc = new Scanner(System.in);
			String encryptedmsg;
			String decryptedmsg;
			String msgFromclient;
			//server aes = new server();
			//aes.init();
			

			try {
				int x=1;
				if(x==1) {
				socket = serverSocket.accept();

				isr = new InputStreamReader(socket.getInputStream());
				osw = new OutputStreamWriter(socket.getOutputStream());

				bf = new BufferedReader(isr);
				bw = new BufferedWriter(osw);
				
				
				
				
	
				while (true) {
					Scanner sc1 = new Scanner(System.in);

					msgFromclient = bf.readLine();
					//client.exportkey();

					// String msg1=client.encrypt(msgFromclient);

					System.out.println("Msg to encrypt:" + msgFromclient);
					
					//Scanner sc = new Scanner(System.in);
					
					//server aes = new server();
					//aes.init(); // Initializing
					 encryptedmsg = aes.encrypt(msgFromclient);
					 System.out.println("Encrypted msg:"+encryptedmsg);
					 decryptedmsg = aes.decrypt(encryptedmsg);
					
					server.exportkey();
					System.out.println("Decrypted msg:"+decryptedmsg);
					
					//System.out.println("Encrypted Msg:"+encryptedmsg);
					//System.out.println("Decrypted Msg:"+decryptedmsg);

					//aes.exportkey();
					

					

					//bw.write("MSG Recieved");
					bf.readLine();
					bw.flush();

						break;
				}
				}
				
				

				sc.close();

					
				}finally{
				

				isr.close();
				osw.close();
				bf.close();
				bw.close();
				serverSocket.close();

			} 
		}
	}
}
