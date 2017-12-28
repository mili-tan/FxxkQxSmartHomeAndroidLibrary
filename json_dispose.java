/*     */ package lib;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ public class json_dispose
/*     */ {
/*  11 */   public static JSONObject receive_data = new JSONObject();
/*  12 */   public static JSONObject send_receive = new JSONObject();
/*  13 */   public static JSONObject send_control = new JSONObject();
/*  14 */   private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */   
/*     */   public json_dispose() {
/*     */     try {
/*  18 */       send_receive.put("UserName", "bizideal");
/*     */       
/*  20 */       send_receive.put("Password", "123456");
/*     */       
/*  22 */       send_receive.put("Type", "GetData");
/*     */       
/*  24 */       send_receive.put("CurrentTime", this.df.format(new Date()));
/*     */     }
/*     */     catch (JSONException e) {
/*  27 */       e.printStackTrace();
/*     */     }
/*     */     try {
/*  30 */       receive_data.put("Temp", "0");
/*  31 */       receive_data.put("Humidity", "0");
/*  32 */       receive_data.put("Illumination", "0");
/*  33 */       receive_data.put("Smoke", "0");
/*  34 */       receive_data.put("Gas", "0");
/*  35 */       receive_data.put("PM2.5", "0");
/*  36 */       receive_data.put("Co2", "0");
/*  37 */       receive_data.put("AirPressure", "0");
/*  38 */       receive_data.put("StateHumanInfrared", "0");
/*  39 */       receive_data.put("StateHelpButton", "0");
/*  40 */       receive_data.put("RFIDTag", "0");
/*  41 */       receive_data.put("RFIDData", "0");
/*  42 */       receive_data.put("LedState", "0");
/*  43 */       receive_data.put("Relay4State", "0");
/*  44 */       receive_data.put("DCMotorState", "0");
/*  45 */       receive_data.put("FanState", "0");
/*  46 */       receive_data.put("DigtalState", "0");
/*  47 */       receive_data.put("CurtainState", "0");
/*  48 */       receive_data.put("LampState", "0");
/*  49 */       receive_data.put("BuzzState", "0");
/*  50 */       receive_data.put("WarningLightState", "0");
/*     */     }
/*     */     catch (JSONException e) {
/*  53 */       e.printStackTrace();
/*     */     }
/*     */     try {
/*  56 */       send_control.put("UserName", "bizideal");
/*     */       
/*  58 */       send_control.put("Password", "123456");
/*     */       
/*  60 */       send_control.put("Type", "Control");
/*     */       
/*  62 */       send_control.put("CurrentTime", this.df.format(new Date()));
/*     */       
/*  64 */       send_control.put("SenSorType", "");
/*     */       
/*  66 */       send_control.put("Custom", "0");
/*     */       
/*  68 */       send_control.put("Command", "0");
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/*  72 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean receive()
/*     */   {
/*  81 */     SocketThread.databuff = send_receive.toString();
/*  82 */     SocketThread.SocketHandle();
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean control(String SenSorType, int Custom, int Command)
/*     */   {
/*     */     try
/*     */     {
/*  98 */       send_control.put("SenSorType", SenSorType);
/*  99 */       send_control.put("Custom", Custom);
/* 100 */       send_control.put("Command", Command);
/*     */     }
/*     */     catch (JSONException e) {
/* 103 */       e.printStackTrace();
/*     */     }
/* 105 */     SocketThread.databuff = send_control.toString();
/* 106 */     SocketThread.SocketHandle();
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              F:\lib_2015_12_31.jar!\lib\json_dispose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */