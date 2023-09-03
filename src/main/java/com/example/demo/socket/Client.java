package com.example.demo.socket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
        
    private final Integer PORT=13;
    private final String  IP="localhost";
    
    public Client() {
        // TODO Auto-generated constructor stub
        
    try {
        //GAry Morales

        Socket clientSeSocket=new Socket(IP,PORT);
        System.out.println("-----------1 Iniciando la comunicación--------");
        File fileOrigin=new File("D:/cliente/imagen.jpg");
        FileInputStream fis=new FileInputStream(fileOrigin);
        DataOutputStream salida=new DataOutputStream(clientSeSocket.getOutputStream());
        
        int byteleidos;
        while ((byteleidos=fis.read())!=-1) {
            salida.write(byteleidos);
        }
        fis.close();
        salida.close();
        System.out.println("-----------2 Finalizando comunicación--------");
        clientSeSocket.close();
    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        
    }
    
    
    public static void main(String[] args) {
        new Client();
        
    }
}    
