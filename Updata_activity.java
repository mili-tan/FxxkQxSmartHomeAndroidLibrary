package com.bizideal.smarthometest.lib;

import android.os.Handler;
import android.os.Message;

public class Updata_activity implements Runnable {

   public static Handler updatahandler;
   public static boolean mode;


   public void run() {
      mode = true;

      while(mode) {
         try {
            Thread.sleep(2000L);
            Message e = new Message();
            e.what = 1;
            updatahandler.sendMessage(e);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }
      }

   }
}
