import java.io.*;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class multiserver extends Thread{
    Socket skt;
    private static int countclient=0;
    multiserver(Socket skt){
        this.skt=skt;
    }
    
    public static String Verifier(String arg,String avg){
      if(arg.contains(avg)){
        return arg +" contient "+avg;
      }else{
        return arg +" ne contient pas "+avg;
      }
    }
    public void run(){
        try{
            System.out.print("En Attente de clients:  \n");
            String chain1x="";
            String chain2x="";
            BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));//resevoir
            PrintStream ps=new PrintStream(skt.getOutputStream());//send
            System.out.println("is Connected!!");
            countclient++;
            chain1x=br.readLine();
            chain2x=br.readLine();
            System.out.println("L'addresse Logique de client :"+countclient+" "+skt.getInetAddress().toString());
            System.out.println("Les Chaines Recues: "+chain1x+" "+chain2x);
            chain1x=Verifier(chain1x, chain2x);
            ps.println(chain1x);
    }
        catch(Exception e){System.out.println(e.getMessage());}
    }
    public static void main(String[] args)throws Exception {
        ServerSocket ss=new ServerSocket(6000);
        Socket skt;
        int count=1;
        multiserver srv;
        while(true){
            Scanner sc=new Scanner(System.in);
                     skt=ss.accept();
                     System.out.println("Client Connected :"+count++);
                     srv=new multiserver(skt);
                     srv.start();
        }

    }
}
