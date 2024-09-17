import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

class Server
{
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    public Server()
    {
        try {
            server = new ServerSocket(7777);
            System.out.println("Server is ready to accept connection");
            System.out.println("waiting...");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        startReading();
        startWriting();

    }

    public void startReading()
    {
        Runnable r1 =()->
        {   
            System.out.println("Reader Started");
    try{
            while (true) {
                String msg = br.readLine();
                if(msg.equals("exit"))
                {
                    System.out.println("client terminated the chat");
                    socket.close();

                    break;
                }
                System.out.println("Client :"+ msg);
        }

    }catch(Exception e){
        System.out.println("connection closed..");
    }


        };
        new Thread(r1).start();
    }

    public void startWriting()
    {
        Runnable r2=()->{
            System.out.println("Writer Started...");
try{
            while (!socket.isClosed()) {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

                    String content = br1.readLine();
                    out.println(content);

                    out.flush();

                    if(content.equals("exit"))
                    {
                        socket.close();
                        break;
                    }
                }
            }catch(Exception e)
            {
                //e.printStackTrace();
                System.out.println("connection closed..");
            }

            //System.out.println("connection closed..");

        };
        new Thread(r2).start();

    }




    public static void main(String[] args)
{
    new Server();
}
}
