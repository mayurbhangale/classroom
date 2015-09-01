import java.awt.*;
import java.awt.event.*;
import java.applet.*;
 
public class Calculator extends Applet implements ActionListener
{
	String msg=" ";
	int v1,v2,result;
	TextField t1;
	Button b[]=new Button[10];
	Button add,sub,mul,div,clear,mod,equal;
	char OP;

	public void init()
	{		
		t1=new TextField(10);

		for(int i=0;i<10;i++)
		{
			b[i]=new Button(""+i);
		}

		add=new Button("+");
		sub=new Button("-");
		mul=new Button("*");
		div=new Button("/");
		mod=new Button("%");
		clear=new Button("C");
		equal=new Button("=");

		t1.addActionListener(this);
		add(t1);

		for(int i=0;i<10;i++)
		{
			add(b[i]);
		}

		add(add);
		add(sub);
		add(mul);
		add(div);
		add(mod);
		add(clear);
		add(equal);

		for(int i=0;i<10;i++)
		{
			b[i].addActionListener(this);
		}

		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		mod.addActionListener(this);
		clear.addActionListener(this);
		equal.addActionListener(this);
	}
 
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		char ch=str.charAt(0);

		if ( Character.isDigit(ch))
			t1.setText(t1.getText()+str);
		
		else if(str.equals("+")){
			v1=Integer.parseInt(t1.getText());
			OP='+';
			t1.setText("");
		}

		else if(str.equals("-")){
			v1=Integer.parseInt(t1.getText());
			OP='-';
			t1.setText("");
		}

		else if(str.equals("*")){
			v1=Integer.parseInt(t1.getText());
			OP='*';
			t1.setText("");
		}

		else if(str.equals("/")){
			v1=Integer.parseInt(t1.getText());
			OP='/';
			t1.setText("");
		}

		else if(str.equals("%")){
			v1=Integer.parseInt(t1.getText());
			OP='%';
			t1.setText("");
		}

		if(str.equals("=")){
			v2=Integer.parseInt(t1.getText());
			if(OP=='+')
				result=v1+v2;
			else if(OP=='-')
				result=v1-v2;
			else if(OP=='*')
				result=v1*v2;
			else if(OP=='/')
				result=v1/v2;
			else if(OP=='%')
				result=v1%v2;
			t1.setText(""+result);
		}
	
		if(str.equals("C")){
			t1.setText("");
		}
	}
}
