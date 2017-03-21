package lib;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import lib.SocketThread;

public class popwindow {

   private Context context;
   private PopupWindow popupWindow;
   private EditText IP_EditText;
   private EditText port_EditText;
   private Button set;


   public popwindow(Context context) {
      this.context = context;
      View view = LayoutInflater.from(context).inflate(2130903042, (ViewGroup)null);
      this.port_EditText = (EditText)view.findViewById(2131230807);
      this.IP_EditText = (EditText)view.findViewById(2131230808);
      this.set = (Button)view.findViewById(2131230809);
      this.popupWindow = new PopupWindow(view, 150, -2);
      this.popupWindow.setBackgroundDrawable(new BitmapDrawable());
      this.set.setOnClickListener(new OnClickListener() {
         public void onClick(View v) {
            SocketThread.SocketIp = popwindow.this.IP_EditText.getText().toString();
            SocketThread.Port = Integer.parseInt(popwindow.this.port_EditText.getText().toString());
         }
      });
   }

   public void showAsDropDown(View parent) {
      this.popupWindow.showAsDropDown(parent, 10, 5);
      this.popupWindow.setFocusable(true);
      this.popupWindow.setOutsideTouchable(true);
      this.popupWindow.update();
   }

   public void dismiss() {
      this.popupWindow.dismiss();
   }

   public void setEdit_IP(String IP) {
      this.IP_EditText.setText(IP);
   }

   public void setEdit_port(int port) {
      this.port_EditText.setText(Integer.toString(port));
   }
}
