import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientAPI {
   private static DataInputStream din;
    private static DataOutputStream d_out;
    private static Socket socket;
    private static Queue<Integer> data;


    static void initialize() {
        try {
            socket = new Socket("127.0.0.1", 8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            din = new DataInputStream(socket.getInputStream());
            d_out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        data = new ConcurrentLinkedQueue<>();
    }
    public static  Integer send_data(){
        while (data.size()==0) {
        }
        return data.poll();
    }


    public static void main(String[] args) throws IOException {
        initialize();
        int line = din.readInt();
        System.out.println("frames " + line);
        Thread th=new Thread(new client(line));
        line=din.readInt();
        data.add(line);
        th.start();
        while (line!=0) {
            line = din.readInt();
            data.add(line);
        }
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        close();
    }

    static void close() throws IOException {
        System.out.println("finished");
        din.close();
        d_out.close();
        socket.close();
    }
}
