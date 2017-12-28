/*    */ package lib;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.app.Application;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SysApplication
/*    */   extends Application
/*    */ {
/* 15 */   private static List<Activity> mList = new LinkedList();
/*    */   
/*    */   private static SysApplication instance;
/*    */   
/*    */ 
/*    */   public static synchronized SysApplication getInstance()
/*    */   {
/* 22 */     if (instance == null) {
/* 23 */       instance = new SysApplication();
/*    */     }
/* 25 */     return instance;
/*    */   }
/*    */   
/*    */   public void addActivity(Activity activity) {
/* 29 */     mList.add(activity);
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public static void exit()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: getstatic 19	lib/SysApplication:mList	Ljava/util/List;
/*    */     //   3: invokeinterface 42 1 0
/*    */     //   8: astore_1
/*    */     //   9: goto +21 -> 30
/*    */     //   12: aload_1
/*    */     //   13: invokeinterface 46 1 0
/*    */     //   18: checkcast 52	android/app/Activity
/*    */     //   21: astore_0
/*    */     //   22: aload_0
/*    */     //   23: ifnull +7 -> 30
/*    */     //   26: aload_0
/*    */     //   27: invokevirtual 54	android/app/Activity:finish	()V
/*    */     //   30: aload_1
/*    */     //   31: invokeinterface 57 1 0
/*    */     //   36: ifne -24 -> 12
/*    */     //   39: goto +22 -> 61
/*    */     //   42: astore_0
/*    */     //   43: aload_0
/*    */     //   44: invokevirtual 61	java/lang/Exception:printStackTrace	()V
/*    */     //   47: iconst_0
/*    */     //   48: invokestatic 66	java/lang/System:exit	(I)V
/*    */     //   51: goto +14 -> 65
/*    */     //   54: astore_2
/*    */     //   55: iconst_0
/*    */     //   56: invokestatic 66	java/lang/System:exit	(I)V
/*    */     //   59: aload_2
/*    */     //   60: athrow
/*    */     //   61: iconst_0
/*    */     //   62: invokestatic 66	java/lang/System:exit	(I)V
/*    */     //   65: return
/*    */     // Line number table:
/*    */     //   Java source line #34	-> byte code offset #0
/*    */     //   Java source line #35	-> byte code offset #22
/*    */     //   Java source line #36	-> byte code offset #26
/*    */     //   Java source line #34	-> byte code offset #30
/*    */     //   Java source line #38	-> byte code offset #39
/*    */     //   Java source line #39	-> byte code offset #43
/*    */     //   Java source line #41	-> byte code offset #47
/*    */     //   Java source line #40	-> byte code offset #54
/*    */     //   Java source line #41	-> byte code offset #55
/*    */     //   Java source line #42	-> byte code offset #59
/*    */     //   Java source line #41	-> byte code offset #61
/*    */     //   Java source line #43	-> byte code offset #65
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   21	6	0	activity	Activity
/*    */     //   42	2	0	e	Exception
/*    */     //   8	23	1	localIterator	java.util.Iterator
/*    */     //   54	6	2	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	39	42	java/lang/Exception
/*    */     //   0	47	54	finally
/*    */   }
/*    */   
/*    */   public void onLowMemory()
/*    */   {
/* 46 */     super.onLowMemory();
/* 47 */     System.gc();
/*    */   }
/*    */ }


/* Location:              F:\lib_2015_12_31.jar!\lib\SysApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */