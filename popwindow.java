/*    */ package lib;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.graphics.drawable.BitmapDrawable;
/*    */ import android.text.Editable;
/*    */ import android.view.LayoutInflater;
/*    */ import android.view.View;
/*    */ import android.view.View.OnClickListener;
/*    */ import android.widget.Button;
/*    */ import android.widget.EditText;
/*    */ import android.widget.PopupWindow;
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
/*    */   private Button set;
/*    */   
/*    */   public popwindow(Context context)
/*    */   {
/* 28 */     this.context = context;
/*    */     
/*    */ 
/* 31 */     View view = LayoutInflater.from(context).inflate(2130903042, null);
/*    */     
/*    */ 
/* 34 */     this.port_EditText = ((EditText)view.findViewById(2131230807));
/* 35 */     this.IP_EditText = ((EditText)view.findViewById(2131230808));
/* 36 */     this.set = ((Button)view.findViewById(2131230809));
/*    */     
/*    */ 
/*    */ 
/* 40 */     this.popupWindow = new PopupWindow(view, 150, -2);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 46 */     this.popupWindow.setBackgroundDrawable(new BitmapDrawable());
/* 47 */     this.set.setOnClickListener(new View.OnClickListener()
/*    */     {
/*    */       public void onClick(View v)
/*    */       {
/* 51 */         SocketThread.SocketIp = popwindow.this.IP_EditText.getText().toString();
/* 52 */         SocketThread.Port = Integer.parseInt(popwindow.this.port_EditText.getText().toString());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/* 57 */   public void showAsDropDown(View parent) { this.popupWindow.showAsDropDown(parent, 10, 
/* 58 */       5);
/* 59 */     this.popupWindow.setFocusable(true);
/* 60 */     this.popupWindow.setOutsideTouchable(true);
/* 61 */     this.popupWindow.update();
/*    */   }
/*    */   
/*    */   public void dismiss()
/*    */   {
/* 66 */     this.popupWindow.dismiss();
/*    */   }
/*    */   
/* 69 */   public void setEdit_IP(String IP) { this.IP_EditText.setText(IP); }
/*    */   
/*    */   public void setEdit_port(int port) {
/* 72 */     this.port_EditText.setText(Integer.toString(port));
/*    */   }
/*    */ }


/* Location:              F:\lib_2015_12_31.jar!\lib\popwindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */