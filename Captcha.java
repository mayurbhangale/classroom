import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/* <applet code="Captcha.class" width="320" height="120">
If your browser was Java-enabled, a "Hello, World"
message would appear here.
</applet> */
public class Generate {  
    public String generateCaptcha() {  
	int len = 5;		
	Random rnd = new Random();  
	StringBuffer captString = new StringBuffer();

	for(int i=0 ; i<len ; i++){
       	  int charNum = 0;  
	  int GenNum = Math.abs(random.nextInt()) % 80;  
     
	  if (GenNum < 26) { charNum = 65 + GenNum;  }
	  else if (GenNum < 52) {charNum =  97 + (GenNum - 26); }
	  else{ charNum = 48 + (GenNum - 52);}
	
	captchaStringBuffer.append((char)charNumber);  
      }  
      return captchaStringBuffer.toString();  
     }   
    }

public class Captcha extends Applet implements ActionListener{
	public void init(){
		Generate g1 = new Generate();
		String str = g1.generateCaptcha();
		String str2;

		Button b1 ,b2;
		Label l1,l2,l3;
		TextField t1;	
		
		b1 = new Button("Submit");
		b2 = new Button("Refresh");
		l1 = new Label("Enter CAPTCHA");
		l2 = new Label(" ");
		l3 = new Label(" ");
		t1 = new TextField(15);

		b1.addActionListener(this);
		b2.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent ac){
		cmd = ac.getActionCommand();
		if(cmd.equals("Submit")){
			if (t1.getText().equals(str)){
				l2.setText("Success");
			}
			else{
				l2.setText("Failure");
			}
			}
			else if(cmd.equals("Refresh")){
				Generate obj1 = new Generate();
			str2 = obj1.generateCaptcha();
			l1.setText(str2);
			l2.setText(" ");
			l3.setText(" ");
			}
		}
	}			
}	 	
