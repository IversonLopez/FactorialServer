import java.net.Socket;
import java.io.*;

public class FactorialClient {
    public static void main(String[] args){
        try{

            System.out.println("Client Started");
            Socket soc = new Socket("localhost", 9086);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //typed from the keyboard, so use system.in, this is essentially when you write the scanner class for input but in a BufferedReader class
            System.out.println("Enter a Number: "); //create the bufferedReader before you ask for the number 
            int number = Integer.parseInt(in.readLine()); //need to convert to an Integer because BufferedReader is only for Strings
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true); // when you have want to send something, use PrintWriter and do soc.getOutputStream, because you want to send it and have true as the arguments
            out.println(number); //out.println(num) officially sends the number to the server 


            //reading the data from the server 

            BufferedReader in2 = new BufferedReader(new InputStreamReader(soc.getInputStream())); //reading data so use InputStream, reading "The Factorial of (num) is "
             //don't forget the readLine, because you're using a BufferedReader
            System.out.println(in2.readLine()); // Prints out to the actual console


            soc.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
