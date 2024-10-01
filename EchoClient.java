import java.io.*;
import java.net.Socket;

public class EchoClient{
    public static void main(String[] args){

        try{

        
        System.out.println("Client Started");

        Socket soc = new Socket("localhost", 9086);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println("Enter a string");

        String str = userInput.readLine();

        PrintWriter out = new PrintWriter(soc.getOutputStream(), true); //autoFlush, this PrintWriter really isn't anything connection related, it just writing it basically 

        out.println(str); //out is essentially a System.out.println, because it writes off that code 

        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        System.out.println(in.readLine());

        in.close();

        out.close();

        soc.close();
        }


        catch(Exception e){
            e.printStackTrace();
        }
    }


}