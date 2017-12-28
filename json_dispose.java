/*     */ package lib;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class json_dispose
/*     */ {
/*  13 */   public static JSONObject receive_data = new JSONObject();
/*  14 */   public static JSONObject send_receive = new JSONObject();
/*  15 */   public static JSONObject send_control = new JSONObject();
/*  16 */   private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */   
/*     */   public json_dispose() {
/*     */     try {
/*  20 */       send_receive.put("UserName", "bizideal");
/*     */       
/*  22 */       send_receive.put("Password", "123456");
/*     */       
/*  24 */       send_receive.put("Type", "GetData");
/*     */       
/*  26 */       send_receive.put("CurrentTime", this.df.format(new Date()));
/*     */     }
/*     */     catch (JSONException e) {
/*  29 */       e.printStackTrace();
/*     */     }
/*     */     try {
/*  32 */       receive_data.put("Temp", "0");
/*  33 */       receive_data.put("Humidity", "0");
/*  34 */       receive_data.put("Illumination", "0");
/*  35 */       receive_data.put("Smoke", "0");
/*  36 */       receive_data.put("Gas", "0");
/*  37 */       receive_data.put("PM25", "0");
/*  38 */       receive_data.put("Co2", "0");
/*  39 */       receive_data.put("AirPressure", "0");
/*  40 */       receive_data.put("StateHumanInfrared", "0");
/*  41 */       receive_data.put("StateHelpButton", "0");
/*  42 */       receive_data.put("RFIDTag", "0");
/*  43 */       receive_data.put("RFIDData", "0");
/*  44 */       receive_data.put("LedState", "0");
/*  45 */       receive_data.put("Relay4State", "0");
/*  46 */       receive_data.put("DCMotorState", "0");
/*  47 */       receive_data.put("FanState", "0");
/*  48 */       receive_data.put("DigtalState", "0");
/*  49 */       receive_data.put("CurtainState", "0");
/*  50 */       receive_data.put("LampState", "0");
/*  51 */       receive_data.put("BuzzState", "0");
/*  52 */       receive_data.put("WarningLightState", "0");
/*     */     }
/*     */     catch (JSONException e) {
/*  55 */       e.printStackTrace();
/*     */     }
/*     */     try {
/*  58 */       send_control.put("UserName", "bizideal");
/*     */       
/*  60 */       send_control.put("Password", "123456");
/*     */       
/*  62 */       send_control.put("Type", "Control");
/*     */       
/*  64 */       send_control.put("CurrentTime", this.df.format(new Date()));
/*     */       
/*  66 */       send_control.put("SenSorType", "");
/*     */       
/*  68 */       send_control.put("Custom", "0");
/*     */       
/*  70 */       send_control.put("Command", "0");
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/*  74 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean receive()
/*     */   {
/*  83 */     SocketThread.databuff = send_receive.toString();
/*  84 */     SocketThread.SocketHandle();
/*  85 */     return true;
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
/* 100 */       send_control.put("SenSorType", SenSorType);
/* 101 */       send_control.put("Custom", Custom);
/* 102 */       send_control.put("Command", Command);
/*     */     }
/*     */     catch (JSONException e) {
/* 105 */       e.printStackTrace();
/*     */     }
/* 107 */     SocketThread.databuff = send_control.toString();
/* 108 */     SocketThread.SocketHandle();
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              F:\使用材料\安卓更新V2.0\库文件\smarthometest.jar!\lib\json_dispose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */