package bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author yinchengjian
 * @Date 2019/8/4 18:20
 */
public class BioServer {

    public static void main(String[] args) throws Exception {
        int port = 80;
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String line = in.readLine();
                System.out.println("client:"+line);
                if("exit".equals(line)){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(socket!=null){
                socket.close();
            }
            if(serverSocket!=null){
                serverSocket.close();
            }
        }

    }

}
