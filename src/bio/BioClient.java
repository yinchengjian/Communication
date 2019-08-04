package bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author yinchengjian
 * @Date 2019/8/4 18:55
 */
public class BioClient {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int port = 80;
        Socket socket = null;
        PrintWriter out = null;
        try{
            socket = new Socket("127.0.0.1",port);
            out = new PrintWriter(socket.getOutputStream(),true);
            while(true){
                String line = scanner.nextLine();
                if(line!=null){
                    out.println(line);
                    if("exit".equals(line)){
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out!=null){
                out.close();
            }
            if(socket!=null) socket.close();
        }
    }
}
