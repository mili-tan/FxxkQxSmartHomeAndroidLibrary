package lib;

import java.io.IOException;
import java.net.UnknownHostException;
import lib.SocketThread;

public class MyThread implements Runnable {

   public static boolean socket_state;


   public void run() {
      socket_state = true;

      while(socket_state) {
         try {
            Thread.sleep(5000L);
         } catch (InterruptedException var6) {
            var6.printStackTrace();
         }

         try {
            SocketThread.socket.sendUrgentData(255);
            System.out.println("网络通");
         } catch (IOException var5) {
            System.out.println("网络断开");

            try {
               SocketThread.socket.close();
               SocketThread.SocketHandle();
            } catch (UnknownHostException var3) {
               var3.printStackTrace();
            } catch (IOException var4) {
               var4.printStackTrace();
            }
         }
      }

   }
}
