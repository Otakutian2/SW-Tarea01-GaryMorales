package com.example.demo.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Ejecucion {
		private final Integer PORT = 13;
		public Ejecucion() {
			 Socket clienteSocket;
		        //GAry Morales
		        try {
		            ServerSocket serverSocket= new ServerSocket(PORT);
		            while(true) {
		            //Bucle infinito
		                
		                System.out.println("----------------1 Iniciando server socket------------");
		                System.out.println("----------------2 A la espera del clientSocket----------");
		                clienteSocket=serverSocket.accept(); //La espera a un cliente
		                System.out.println("----------------3 Llegó el clienteSocket----------");
		                
		                File fileOrigin=new File("D:/server/imagen.png");
		                FileOutputStream data=new FileOutputStream(fileOrigin);
		                DataInputStream salida=new DataInputStream(clienteSocket.getInputStream());
		                
		                int byteleidos;
		                while ((byteleidos=salida.read())!=-1) {
		                    data.write(byteleidos);
		                }
		                data.close();
		                salida.close();
		                
		                clienteSocket.close();
		                System.out.println("----------------4 Finalizar la atención clienteSocket----------");
		            }
		        } catch (IOException e) {
		            
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        catch (Exception e) {
		            // TODO: handle exception
		        }
		}
		public static void main(String[] args) {
			new Ejecucion();
		}
}
