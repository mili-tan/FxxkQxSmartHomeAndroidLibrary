package lib;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import lib.json_dispose;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SocketThread {

   public static Handler mHandler;
   public static Handler mHandlerSocketState;
   private static int Socket_time = 0;
   public static String DataWrite = null;
   public static DataOutputStream out = null;
   public static boolean State_Thread;
   public static String SocketIp;
   public static boolean Socket_flag;
   public static int Port;
   public static Socket socket = null;
   public static String databuff;
   public static boolean operation_succeed_flag;
   private static JSONArray receive_jsonArray;
   private static JSONObject receive_json;
   private static InetSocketAddress isa;


   public static void SocketHandle() {
      State_Thread = true;
      (new Thread() {
         public void run() {
            try {
               SocketThread.socket = new Socket();
               SocketThread.isa = new InetSocketAddress(SocketThread.SocketIp, SocketThread.Port);
               SocketThread.socket.connect(SocketThread.isa, 5000);
               if(SocketThread.socket.isConnected()) {
                  Message e = new Message();
                  Bundle msg1 = new Bundle();
                  msg1.putString("SocketThread_State", "OK");
                  SocketThread.Socket_flag = true;
                  e.setData(msg1);
                  SocketThread.mHandlerSocketState.sendMessage(e);
                  SocketThread.out = new DataOutputStream(SocketThread.socket.getOutputStream());

                  for(DataInputStream b1 = new DataInputStream(SocketThread.socket.getInputStream()); SocketThread.State_Thread; SocketThread.State_Thread = false) {
                     int[] buf_int = new int[400];
                     char[] buf_char = new char[400];
                     buf_int[1] = 45;
                     if(SocketThread.Socket_time != 0) {
                        SocketThread.out.write(SocketThread.databuff.getBytes());
                        SocketThread.out.writeChars("\r\n");
                        SocketThread.operation_succeed_flag = false;
                     }

                     SocketThread.Socket_time = SocketThread.Socket_time + 1;
                     String buf_string = b1.readLine();

                     try {
                        SocketThread.receive_json = new JSONObject(buf_string);
                        System.out.println(SocketThread.receive_json);
                        if(SocketThread.receive_json.get("state").equals("Success")) {
                           SocketThread.operation_succeed_flag = true;
                           SocketThread.receive_jsonArray = SocketThread.receive_json.getJSONArray("Data");
                           SocketThread.receive_json = SocketThread.receive_jsonArray.getJSONObject(0);
                           SocketThread.Updata_receive_data(SocketThread.receive_json, json_dispose.receive_data);
                        } else {
                           SocketThread.operation_succeed_flag = false;
                        }
                     } catch (Exception var9) {
                        System.out.println("无数据");
                     }
                  }

                  SocketThread.socket.close();
                  SocketThread.Socket_flag = false;
               } else {
                  SocketThread.socket.close();
                  SocketThread.Socket_flag = false;
               }
            } catch (Exception var10) {
               Message msg = new Message();
               Bundle b = new Bundle();
               b.putString("SocketThread_State", "error");
               SocketThread.Socket_flag = false;
               msg.setData(b);
               SocketThread.mHandlerSocketState.sendMessage(msg);
               System.out.println(var10);
            }

         }
      }).start();
   }

   private static void Updata_receive_data(JSONObject jsonObject, JSONObject receive_data) {
      try {
         receive_data.put("Temp", jsonObject.get("Temp"));
      } catch (JSONException var19) {
         var19.printStackTrace();
      }

      try {
         receive_data.put("Humidity", jsonObject.get("Humidity"));
      } catch (JSONException var18) {
         var18.printStackTrace();
      }

      try {
         receive_data.put("Illumination", jsonObject.get("Illumination"));
      } catch (JSONException var17) {
         var17.printStackTrace();
      }

      try {
         receive_data.put("Smoke", jsonObject.get("Smoke"));
      } catch (JSONException var16) {
         var16.printStackTrace();
      }

      try {
         receive_data.put("Gas", jsonObject.get("Gas"));
      } catch (JSONException var15) {
         var15.printStackTrace();
      }

      try {
         receive_data.put("PM2.5", jsonObject.get("PM2.5"));
      } catch (JSONException var14) {
         var14.printStackTrace();
      }

      try {
         receive_data.put("Co2", jsonObject.get("Co2"));
      } catch (JSONException var13) {
         var13.printStackTrace();
      }

      try {
         receive_data.put("AirPressure", jsonObject.get("AirPressure"));
      } catch (JSONException var12) {
         var12.printStackTrace();
      }

      try {
         receive_data.put("StateHumanInfrared", jsonObject.get("StateHumanInfrared"));
      } catch (JSONException var11) {
         var11.printStackTrace();
      }

      try {
         receive_data.put("StateHelpButton", jsonObject.get("StateHelpButton"));
      } catch (JSONException var10) {
         var10.printStackTrace();
      }

      try {
         receive_data.put("RFIDTag", jsonObject.get("RFIDTag"));
      } catch (JSONException var9) {
         var9.printStackTrace();
      }

      try {
         receive_data.put("RFIDData", jsonObject.get("RFIDData"));
      } catch (JSONException var8) {
         var8.printStackTrace();
      }

      try {
         receive_data.put("Relay4State", jsonObject.get("Relay4State"));
      } catch (JSONException var7) {
         var7.printStackTrace();
      }

      try {
         receive_data.put("FanState", jsonObject.get("FanState"));
      } catch (JSONException var6) {
         var6.printStackTrace();
      }

      try {
         receive_data.put("CurtainState", jsonObject.get("CurtainState"));
      } catch (JSONException var5) {
         var5.printStackTrace();
      }

      try {
         receive_data.put("LampState", jsonObject.get("LampState"));
      } catch (JSONException var4) {
         var4.printStackTrace();
      }

      try {
         receive_data.put("WarningLightState", jsonObject.get("WarningLightState"));
      } catch (JSONException var3) {
         var3.printStackTrace();
      }

   }
}
