import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    private static int countclient=0;
    public static String Verifier(String arg,String avg){
      if(arg.contains(avg)){
        return arg +" contient "+avg;
      }else{
        return arg +" ne contient pas "+avg;
      }
    }
public static void main(String[] arg){
    try{
      ServerSocket s=new ServerSocket(6000);
     while(true){
   System.out.print("En Attente de clients:  \n");
   String chain1x="";
   String chain2x="";
   Socket stk=s.accept();
   ObjectInputStream br=new ObjectInputStream(stk.getInputStream());
   ObjectOutputStream ps=new ObjectOutputStream(stk.getOutputStream());
   System.out.println("is Connected!!");
   countclient++;
   Byte[] a;
   br.read(a);
   chain1x=String.valueOf(a);
   br.read(a);
   chain2x=String.valueOf(a);
   System.out.println("L'addresse Logique de client :"+countclient+" "+stk.getInetAddress().toString());
   System.out.println("Les Chaines Recues: "+chain1x+" "+chain2x);
   chain1x=Verifier(chain1x, chain2x);
   a=chain1x.getBytes();
   ps.write(a);
     }
}catch(Exception o){
    System.out.print(o.getMessage());
}
}
}