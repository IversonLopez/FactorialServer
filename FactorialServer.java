import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class FactorialServer {
    public static void main(String[] args){
        
        try{
            System.out.println("Waiting for Clients");
            ServerSocket ss = new ServerSocket(9086);
            Socket soc = ss.accept();
            System.out.println("Connection Established");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); //reads the number inputted from the client 
            int number = Integer.parseInt(in.readLine()); //change to an int (conversion), integer wrapper
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true); //output back to the client the actual factorial, not the number(getting ready to output it)
            out.println("Factorial of " + number + " is: " + factorial(number)); //officially sends the number back to the client 
            in.close();
            soc.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

//recursion is the first method i think of, so i would do 5! = 5 * 4!
//whats the base case? , if 0! = 1

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }

        else{
            return n * factorial(n-1);
        }
    }


}
