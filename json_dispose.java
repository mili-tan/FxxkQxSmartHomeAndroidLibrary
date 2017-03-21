package lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import lib.SocketThread;
import org.json.JSONException;
import org.json.JSONObject;

public class json_dispose {

   public static JSONObject receive_data = new JSONObject();
   public static JSONObject send_receive = new JSONObject();
   public static JSONObject send_control = new JSONObject();
   private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


   public json_dispose() {
      try {
         send_receive.put("UserName", "bizideal");
         send_receive.put("Password", "123456");
         send_receive.put("Type", "GetData");
         send_receive.put("CurrentTime", this.df.format(new Date()));
      } catch (JSONException var4) {
         var4.printStackTrace();
      }

      try {
         receive_data.put("Temp", "0");
         receive_data.put("Humidity", "0");
         receive_data.put("Illumination", "0");
         receive_data.put("Smoke", "0");
         receive_data.put("Gas", "0");
         receive_data.put("PM2.5", "0");
         receive_data.put("Co2", "0");
         receive_data.put("AirPressure", "0");
         receive_data.put("StateHumanInfrared", "0");
         receive_data.put("StateHelpButton", "0");
         receive_data.put("RFIDTag", "0");
         receive_data.put("RFIDData", "0");
         receive_data.put("LedState", "0");
         receive_data.put("Relay4State", "0");
         receive_data.put("DCMotorState", "0");
         receive_data.put("FanState", "0");
         receive_data.put("DigtalState", "0");
         receive_data.put("CurtainState", "0");
         receive_data.put("LampState", "0");
         receive_data.put("BuzzState", "0");
         receive_data.put("WarningLightState", "0");
      } catch (JSONException var3) {
         var3.printStackTrace();
      }

      try {
         send_control.put("UserName", "bizideal");
         send_control.put("Password", "123456");
         send_control.put("Type", "Control");
         send_control.put("CurrentTime", this.df.format(new Date()));
         send_control.put("SenSorType", "");
         send_control.put("Custom", "0");
         send_control.put("Command", "0");
      } catch (JSONException var2) {
         var2.printStackTrace();
      }

   }

   public boolean receive() {
      SocketThread.databuff = send_receive.toString();
      SocketThread.SocketHandle();
      return true;
   }

   public boolean control(String SenSorType, int Custom, int Command) {
      try {
         send_control.put("SenSorType", SenSorType);
         send_control.put("Custom", Custom);
         send_control.put("Command", Command);
      } catch (JSONException var5) {
         var5.printStackTrace();
      }

      SocketThread.databuff = send_control.toString();
      SocketThread.SocketHandle();
      return true;
   }
}
