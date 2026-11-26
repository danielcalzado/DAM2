package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTcpPalabras {
	static Socket cliente;
	static int iPuerto = 20000;
	static Writer wr = null;
	static InputStream iStr = null;
	static InputStreamReader riStr = null;
	static BufferedReader briStr = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			cliente = new Socket("127.0.0.1", iPuerto);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Activa el flujo para lectura de información
		try {
			iStr = cliente.getInputStream();
			riStr = new InputStreamReader(iStr);
			briStr = new BufferedReader(riStr);
		// Activa el flujo para escritura de información
			wr = new OutputStreamWriter(cliente.getOutputStream());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String sPalabra = "";
		String sLetras = "";
		String sMayusculas = "";
		System.out.println("Introduce una palabra o fin para terminar");
		sPalabra = sc.nextLine();
		while (!sPalabra.equalsIgnoreCase("fin")) {
			try {
				wr.write(sPalabra + "\n");
				wr.flush();
			// El servidor responde con dos mensajes
				sLetras = briStr.readLine();
				sMayusculas = briStr.readLine();
				System.out.println("Número de letras: " + sLetras);
				System.out.println("En mayúsculas: " + sMayusculas);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Introduce una palabra o fin para terminar");
			sPalabra = sc.nextLine();
		}
		// Avisa al servidor de que termina
		try {
			wr.write("fin\n");
			wr.flush();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
