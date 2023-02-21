import java.io.*;
import java.io.PrintStream;
import java.net.*;
import java.security.MessageDigest;
public class ReverseEchoclient{
    public static void main(String[] args){
        try{
        Socket stk=new Socket("127.0.0.1",2000);
        BufferedReader keyb=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br=new BufferedReader(new InputStreamReader(stk.getInputStream()));//resevoir
        PrintStream ps=new PrintStream(stk.getOutputStream());//send
        String msg;
        String chain1="islam";
        String chain2="sebbah";
        do
        {   
          // System.out.print("Enter la chaine 1: ");
          // chain1=keyb.readLine();
          // System.out.print("Enter la chaine 2: ");
          // chain2=keyb.readLine();
          ps.print(chain1);
          // ps.print(chain2);
          msg=br.readLine();
          // System.out.println("Les chaines Envoyées: "+chain1+" "+"et "+chain2);
          // System.out.println("Address :"+stk.getLocalAddress().toString()+" port :"+stk.getLocalPort());
          // System.out.println("Address Sreveur :"+stk.getInetAddress().toString()+" port Server:"+stk.getPort());
        
          System.out.println("La Réponse du serveur: "+msg);
            
        }while(!msg.equals("end"));
        stk.close();}catch(Exception pl){System.out.println(pl.getMessage());}
    }
}
