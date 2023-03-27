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


public class client {


	public static void main(String[] args) throws NullPointerException {
		// Setting up the objects
		Socket socket = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader bf = null;
		BufferedWriter bw = null;

		ServerSocket serverSocket = null;

		try {
			Scanner sc = new Scanner(System.in);

			socket = new Socket("localhost", 8878);

			isr = new InputStreamReader(socket.getInputStream());
			osw = new OutputStreamWriter(socket.getOutputStream());

			bf = new BufferedReader(isr);
			bw = new BufferedWriter(osw);


			while (true) {

				String msgtosend =sc.nextLine();
				bw.write(msgtosend);
				bw.newLine();
				bw.flush();

				System.out.println("Server:" + bf.readLine());


					break;

			}
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			{
				try {
					if (socket != null)
						socket.close();
					if (isr != null)
						isr.close();
					if (osw != null)
						osw.close();
					if (bf != null)
						bf.close();
					if (bw != null)
						bw.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
