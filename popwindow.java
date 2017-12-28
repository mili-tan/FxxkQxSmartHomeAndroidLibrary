/*    */ package lib;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.graphics.Color;
/*    */ import android.graphics.drawable.BitmapDrawable;
/*    */ import android.text.Editable;
/*    */ import android.view.LayoutInflater;
/*    */ import android.view.View;
/*    */ import android.view.View.OnClickListener;
/*    */ import android.widget.Button;
/*    */ import android.widget.EditText;
/*    */ import android.widget.PopupWindow;
/*    */ import android.widget.TextView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class popwindow
/*    */ {
/*    */   private Context context;
/*    */   private PopupWindow popupWindow;
/*    */   private EditText IP_EditText;
/*    */   private EditText port_EditText;
/*    */   private EditText camera_EditText;
/*    */   private TextView IP_TextView;
/*    */   private TextView port_TextView;
/*    */   private TextView camera_TextView;
/*    */   private Button set;
/*    */   public static String cameraAdress;
/*    */   
/*    */   public popwindow(Context context)
/*    */   {
/* 35 */     this.context = context;
/*    */     
/*    */ 
/* 38 */     View view = LayoutInflater.from(context).inflate(2130903042, null);
/*    */     
/*    */ 
/* 41 */     this.port_EditText = ((EditText)view.findViewById(2131230807));
/* 42 */     this.IP_EditText = ((EditText)view.findViewById(2131230808));
/* 43 */     this.camera_EditText = ((EditText)view.findViewById(2131230809));
/*    */     
/* 45 */     this.IP_TextView = ((TextView)view.findViewById(2131230729));
/* 46 */     this.port_TextView = ((TextView)view.findViewById(2131230732));
/* 47 */     this.camera_TextView = ((TextView)view.findViewById(2131230742));
/*    */     
/* 49 */     this.IP_TextView.setTextColor(Color.parseColor("#FFFFFF"));
/* 50 */     this.port_TextView.setTextColor(Color.parseColor("#FFFFFF"));
/* 51 */     this.camera_TextView.setTextColor(Color.parseColor("#FFFFFF"));
/* 52 */     this.set = ((Button)view.findViewById(2131230810));
/*    */     
/*    */ 
/*    */ 
/* 56 */     this.popupWindow = new PopupWindow(view, 150, -2);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 62 */     this.popupWindow.setBackgroundDrawable(new BitmapDrawable());
/* 63 */     this.set.setOnClickListener(new View.OnClickListener()
/*    */     {
/*    */       public void onClick(View v)
/*    */       {
/* 67 */         SocketThread.SocketIp = popwindow.this.IP_EditText.getText().toString();
/* 68 */         SocketThread.Port = Integer.parseInt(popwindow.this.port_EditText.getText().toString());
/* 69 */         popwindow.cameraAdress = popwindow.this.camera_EditText.getText().toString();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public void showAsDropDown(View parent) {
/* 75 */     this.popupWindow.showAsDropDown(parent, 10, 
/* 76 */       5);
/* 77 */     this.popupWindow.setFocusable(true);
/* 78 */     this.popupWindow.setOutsideTouchable(true);
/* 79 */     this.popupWindow.update();
/*    */   }
/*    */   
/*    */   public void dismiss()
/*    */   {
/* 84 */     this.popupWindow.dismiss();
/*    */   }
/*    */   
/* 87 */   public void setEdit_IP(String IP) { this.IP_EditText.setText(IP); }
/*    */   
/*    */   public void setEdit_port(int port) {
/* 90 */     this.port_EditText.setText(Integer.toString(port));
/*    */   }
/*    */ }


/* Location:              F:\使用材料\安卓更新V2.0\库文件\smarthometest.jar!\lib\popwindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */