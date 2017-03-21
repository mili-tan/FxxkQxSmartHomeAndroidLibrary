package lib;

import android.app.Activity;
import android.app.Application;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SysApplication extends Application {

   private static List mList = new LinkedList();
   private static SysApplication instance;


   public static synchronized SysApplication getInstance() {
      if(instance == null) {
         instance = new SysApplication();
      }

      return instance;
   }

   public void addActivity(Activity activity) {
      mList.add(activity);
   }

   public static void exit() {
      try {
         Iterator var1 = mList.iterator();

         while(var1.hasNext()) {
            Activity e = (Activity)var1.next();
            if(e != null) {
               e.finish();
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         System.exit(0);
      }

   }

   public void onLowMemory() {
      super.onLowMemory();
      System.gc();
   }
}
