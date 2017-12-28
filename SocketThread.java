/*     */ package lib;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.Message;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SocketThread
/*     */ {
/*     */   public static Handler mHandler;
/*     */   public static Handler mHandlerSocketState;
/*  30 */   private static int Socket_time = 0;
/*     */   
/*  32 */   public static String DataWrite = null;
/*     */   
/*  34 */   public static DataOutputStream out = null;
/*     */   
/*     */   public static boolean State_Thread;
/*     */   
/*     */   public static String SocketIp;
/*     */   
/*     */   public static boolean Socket_flag;
/*     */   
/*     */   public static int Port;
/*     */   
/*  44 */   public static Socket socket = null;
/*     */   
/*     */   public static String databuff;
/*     */   
/*     */   public static boolean operation_succeed_flag;
/*     */   private static JSONArray receive_jsonArray;
/*     */   private static JSONObject receive_json;
/*     */   private static InetSocketAddress isa;
/*     */   
/*     */   public static void SocketHandle()
/*     */   {
/*  55 */     State_Thread = true;
/*     */     
/*  57 */     new Thread()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/*     */         try
/*     */         {
/*  64 */           SocketThread.socket = new Socket();
/*  65 */           SocketThread.isa = new InetSocketAddress(SocketThread.SocketIp, SocketThread.Port);
/*  66 */           SocketThread.socket.connect(SocketThread.isa, 5000);
/*  67 */           if (SocketThread.socket.isConnected())
/*     */           {
/*     */ 
/*  70 */             Message msg1 = new Message();
/*  71 */             Bundle b1 = new Bundle();
/*  72 */             b1.putString("SocketThread_State", "OK");
/*  73 */             SocketThread.Socket_flag = true;
/*  74 */             msg1.setData(b1);
/*  75 */             SocketThread.mHandlerSocketState.sendMessage(msg1);
/*     */             
/*     */ 
/*  78 */             SocketThread.out = new DataOutputStream(SocketThread.socket.getOutputStream());
/*     */             
/*     */ 
/*  81 */             DataInputStream rec = new DataInputStream(SocketThread.socket.getInputStream());
/*     */             
/*  83 */             while (SocketThread.State_Thread)
/*     */             {
/*     */ 
/*  86 */               int[] buf_int = new int['Ɛ'];
/*     */               
/*     */ 
/*  89 */               char[] buf_char = new char['Ɛ'];
/*  90 */               buf_int[1] = 45;
/*     */               
/*     */ 
/*     */ 
/*  94 */               if (SocketThread.Socket_time != 0)
/*     */               {
/*  96 */                 SocketThread.out.write(SocketThread.databuff.getBytes());
/*  97 */                 SocketThread.out.writeChars("\r\n");
/*  98 */                 SocketThread.operation_succeed_flag = false;
/*     */               }
/* 100 */               SocketThread.Socket_time += 1;
/* 101 */               String buf_string = rec.readLine();
/*     */               
/*     */ 
/*     */               try
/*     */               {
/* 106 */                 SocketThread.receive_json = new JSONObject(buf_string);
/*     */                 
/* 108 */                 if (SocketThread.receive_json.get("state").equals("Success"))
/*     */                 {
/* 110 */                   SocketThread.operation_succeed_flag = true;
/* 111 */                   SocketThread.receive_jsonArray = SocketThread.receive_json.getJSONArray("Data");
/* 112 */                   SocketThread.receive_json = SocketThread.receive_jsonArray.getJSONObject(0);
/* 113 */                   SocketThread.Updata_receive_data(SocketThread.receive_json, json_dispose.receive_data);
/*     */                 }
/*     */                 else
/*     */                 {
/* 117 */                   SocketThread.operation_succeed_flag = false;
/*     */                 }
/*     */               }
/*     */               catch (Exception e) {
/* 121 */                 System.out.println("无数据");
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */               SocketThread.State_Thread = false;
/*     */             }
/*     */             
/*     */ 
/* 135 */             SocketThread.socket.close();
/* 136 */             SocketThread.Socket_flag = false;
/*     */           }
/*     */           else
/*     */           {
/* 140 */             SocketThread.socket.close();
/* 141 */             SocketThread.Socket_flag = false;
/*     */           }
/*     */           
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 147 */           Message msg = new Message();
/* 148 */           Bundle b = new Bundle();
/* 149 */           b.putString("SocketThread_State", "error");
/* 150 */           SocketThread.Socket_flag = false;
/* 151 */           msg.setData(b);
/* 152 */           SocketThread.mHandlerSocketState.sendMessage(msg);
/* 153 */           System.out.println(e);
/*     */         }
/*     */       }
/*     */     }.start();
/*     */   }
/*     */   
/*     */   private static void Updata_receive_data(JSONObject jsonObject, JSONObject receive_data) {
/*     */     try {
/* 161 */       receive_data.put("Temp", jsonObject.get("Temp"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 165 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 168 */       receive_data.put("Humidity", jsonObject.get("Humidity"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 172 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 175 */       receive_data.put("Illumination", jsonObject.get("Illumination"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 179 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 182 */       receive_data.put("Smoke", jsonObject.get("Smoke"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 186 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 189 */       receive_data.put("Gas", jsonObject.get("Gas"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 193 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 196 */       receive_data.put("PM25", jsonObject.get("PM25"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 200 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 203 */       receive_data.put("Co2", jsonObject.get("Co2"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 207 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 210 */       receive_data.put("AirPressure", jsonObject.get("AirPressure"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 214 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 217 */       receive_data.put("StateHumanInfrared", jsonObject.get("StateHumanInfrared"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 221 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 224 */       receive_data.put("StateHelpButton", jsonObject.get("StateHelpButton"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 228 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 231 */       receive_data.put("RFIDTag", jsonObject.get("RFIDTag"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 235 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 238 */       receive_data.put("RFIDData", jsonObject.get("RFIDData"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 242 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 245 */       receive_data.put("Relay4State", jsonObject.get("Relay4State"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 249 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 252 */       receive_data.put("FanState", jsonObject.get("FanState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 256 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 259 */       receive_data.put("CurtainState", jsonObject.get("CurtainState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 263 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 266 */       receive_data.put("LampState", jsonObject.get("LampState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 270 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 273 */       receive_data.put("WarningLightState", jsonObject.get("WarningLightState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 277 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              F:\使用材料\安卓更新V2.0\库文件\smarthometest.jar!\lib\SocketThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */