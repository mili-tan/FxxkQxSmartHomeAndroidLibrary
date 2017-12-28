/*    */ package lib;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import android.os.Message;
/*    */ 
/*    */ public class Updata_activity implements Runnable
/*    */ {
/*    */   public static Handler updatahandler;
/*    */   public static boolean mode;
/*    */   
/*    */   public void run()
/*    */   {
/* 13 */     mode = true;
/* 14 */     while (mode) {
/*    */       try {
/* 16 */         Thread.sleep(2000L);
/*    */         
/* 18 */         Message msg = new Message();
/* 19 */         msg.what = 1;
/*    */         
/*    */ 
/*    */ 
/* 23 */         updatahandler.sendMessage(msg);
/*    */       }
/*    */       catch (InterruptedException e) {
/* 26 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              F:\使用材料\安卓更新V2.0\库文件\smarthometest.jar!\lib\Updata_activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */