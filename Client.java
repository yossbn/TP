import java.io.*;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client{
public static void main(String[] arg){
    try{
   Socket stk=new Socket("127.0.0.1", 6000);
   Scanner s=new Scanner(System.in);
   BufferedReader br=new BufferedReader(new InputStreamReader(stk.getInputStream()));//resevoir
   PrintStream ps=new PrintStream(stk.getOutputStream());//send
   System.out.print("Enter la chaine 1: ");
   String chain1="";
   chain1=s.nextLine();
   ps.println(chain1);
   System.out.print("Enter la chaine 2: ");
   String chain2="";
   chain2=s.nextLine();
    ps.println(chain2);
   System.out.println("Les chaines Envoyées: "+chain1+" "+"et "+chain2);
   System.out.println("Address :"+stk.getLocalAddress().toString()+" port :"+stk.getLocalPort());
   System.out.println("Address Sreveur :"+stk.getInetAddress().toString()+" port Server:"+stk.getPort());
   chain1=br.readLine();
   System.out.println("La Réponse du serveur: "+chain1);
}catch(Exception o){;
    o.printStackTrace();
}
}
}