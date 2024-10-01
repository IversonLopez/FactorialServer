import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class EchoServer{
    public static void main(String[] args){

        //using try and catch methods when dealing with IO'S

        try{
            System.out.println("Waiting for clients");
            ServerSocket ss = new ServerSocket(9086);
            Socket soc = ss.accept();//blocking call, the server socet will wait for a incoming cilient connections and then when 
                                     //it gets a conncetion it will return a socket object, and that object will capture it in a 
                                     //Socket reference.
            System.out.println("Connection Established"); // if the previous method from the ServerSocket class(.accept) works, then say Connection Established

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            String str = in.readLine(); 

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true); //send the same string back to the client

            out.println("Server Says '" + str + "'");

            in.close();
            out.close();
            soc.close();

        }
        

        catch(Exception e){

            e.printStackTrace();

        }

        //this a test       
    }
}