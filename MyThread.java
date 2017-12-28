/*    */ package lib;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.net.Socket;
/*    */ import java.net.UnknownHostException;
/*    */ 
/*    */ public class MyThread
/*    */   implements Runnable
/*    */ {
/*    */   public static boolean socket_state;
/*    */   
/*    */   public void run()
/*    */   {
/* 15 */     socket_state = true;
/* 16 */     while (socket_state)
/*    */     {
/*    */       try {
/* 19 */         Thread.sleep(5000L);
/*    */       }
/*    */       catch (InterruptedException e1)
/*    */       {
/* 23 */         e1.printStackTrace();
/*    */       }
/*    */       try {
/* 26 */         SocketThread.socket.sendUrgentData(255);
/* 27 */         System.out.println("网络通");
/*    */       }
/*    */       catch (IOException e)
/*    */       {
/* 31 */         System.out.println("网络断开");
/*    */         try {
/* 33 */           SocketThread.socket.close();
/* 34 */           SocketThread.SocketHandle();
/*    */         }
/*    */         catch (UnknownHostException e1)
/*    */         {
/* 38 */           e1.printStackTrace();
/*    */         }
/*    */         catch (IOException e1)
/*    */         {
/* 42 */           e1.printStackTrace();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              F:\lib_2015_12_31.jar!\lib\MyThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */