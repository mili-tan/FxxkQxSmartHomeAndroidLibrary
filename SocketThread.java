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
/*  93 */               if (SocketThread.Socket_time != 0)
/*     */               {
/*  95 */                 SocketThread.out.write(SocketThread.databuff.getBytes());
/*  96 */                 SocketThread.out.writeChars("\r\n");
/*  97 */                 SocketThread.operation_succeed_flag = false;
/*     */               }
/*  99 */               SocketThread.Socket_time += 1;
/* 100 */               String buf_string = rec.readLine();
/*     */               
/*     */ 
/*     */               try
/*     */               {
/* 105 */                 SocketThread.receive_json = new JSONObject(buf_string);
/* 106 */                 System.out.println(SocketThread.receive_json);
/* 107 */                 if (SocketThread.receive_json.get("state").equals("Success"))
/*     */                 {
/* 109 */                   SocketThread.operation_succeed_flag = true;
/* 110 */                   SocketThread.receive_jsonArray = SocketThread.receive_json.getJSONArray("Data");
/* 111 */                   SocketThread.receive_json = SocketThread.receive_jsonArray.getJSONObject(0);
/* 112 */                   SocketThread.Updata_receive_data(SocketThread.receive_json, json_dispose.receive_data);
/*     */                 }
/*     */                 else
/*     */                 {
/* 116 */                   SocketThread.operation_succeed_flag = false;
/*     */                 }
/*     */               }
/*     */               catch (Exception e) {
/* 120 */                 System.out.println("无数据");
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 130 */               SocketThread.State_Thread = false;
/*     */             }
/*     */             
/*     */ 
/* 134 */             SocketThread.socket.close();
/* 135 */             SocketThread.Socket_flag = false;
/*     */           }
/*     */           else
/*     */           {
/* 139 */             SocketThread.socket.close();
/* 140 */             SocketThread.Socket_flag = false;
/*     */           }
/*     */           
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 146 */           Message msg = new Message();
/* 147 */           Bundle b = new Bundle();
/* 148 */           b.putString("SocketThread_State", "error");
/* 149 */           SocketThread.Socket_flag = false;
/* 150 */           msg.setData(b);
/* 151 */           SocketThread.mHandlerSocketState.sendMessage(msg);
/* 152 */           System.out.println(e);
/*     */         }
/*     */       }
/*     */     }.start();
/*     */   }
/*     */   
/*     */   private static void Updata_receive_data(JSONObject jsonObject, JSONObject receive_data) {
/*     */     try {
/* 160 */       receive_data.put("Temp", jsonObject.get("Temp"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 164 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 167 */       receive_data.put("Humidity", jsonObject.get("Humidity"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 171 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 174 */       receive_data.put("Illumination", jsonObject.get("Illumination"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 178 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 181 */       receive_data.put("Smoke", jsonObject.get("Smoke"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 185 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 188 */       receive_data.put("Gas", jsonObject.get("Gas"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 192 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 195 */       receive_data.put("PM2.5", jsonObject.get("PM2.5"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 199 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 202 */       receive_data.put("Co2", jsonObject.get("Co2"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 206 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 209 */       receive_data.put("AirPressure", jsonObject.get("AirPressure"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 213 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 216 */       receive_data.put("StateHumanInfrared", jsonObject.get("StateHumanInfrared"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 220 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 223 */       receive_data.put("StateHelpButton", jsonObject.get("StateHelpButton"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 227 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 230 */       receive_data.put("RFIDTag", jsonObject.get("RFIDTag"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 234 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 237 */       receive_data.put("RFIDData", jsonObject.get("RFIDData"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 241 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 244 */       receive_data.put("Relay4State", jsonObject.get("Relay4State"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 248 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 251 */       receive_data.put("FanState", jsonObject.get("FanState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 255 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 258 */       receive_data.put("CurtainState", jsonObject.get("CurtainState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 262 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 265 */       receive_data.put("LampState", jsonObject.get("LampState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 269 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 272 */       receive_data.put("WarningLightState", jsonObject.get("WarningLightState"));
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 276 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              F:\lib_2015_12_31.jar!\lib\SocketThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */