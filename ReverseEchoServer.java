import java.io.*;
import java.io.PrintStream;
import java.net.*;
import java.security.MessageDigest;

public class ReverseEchoServer{
    private static int countclient=0;
    public static String Verifier(String arg,String avg){
      if(arg.contains(avg)){
        return arg +" contient "+avg;
      }else{
        return arg +" ne contient pas "+avg;
      }
    }
    public static void main(String[] args){
        try{
        ServerSocket ss=new ServerSocket(2000);
        Socket stk=ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(stk.getInputStream()));//resevoir
        PrintStream ps=new PrintStream(stk.getOutputStream());//send
        String msg="hi";
        do{
            msg=br.readLine();
            ps.println(msg);
        }while(!msg.equals("end"));}catch(Exception op){System.out.println(op.getMessage());}
        
    }
}
