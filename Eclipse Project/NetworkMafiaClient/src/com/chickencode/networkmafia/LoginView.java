package com.chickencode.networkmafia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginView extends JPanel
{
	static private boolean haveInstance = false;
	static private LoginView instance;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JTextField inputId;
	private JPasswordField inputPassword;
	private Color colorBackground = new Color(0X11 ,0X11, 0X11);
	
	private LoginView()
	{ 
		this.setBounds(0,0, 540, 960);
		this.setLayout(null);
		this.setVisible(true);
		inputId = new JTextField();
		inputId.setBounds(150, 600, 340, 70);
		inputId.setBorder(new EmptyBorder(0, 0, 0, 0));
		inputId.setFont(new Font("���� ����" , Font.PLAIN , 30));
		inputId.setForeground(Color.GRAY);
		inputId.setText("���̵�");
		inputId.addFocusListener(new FocusListener() 	//placeHolder ȿ��
		{
			boolean first = true;
			public void focusGained(FocusEvent e) {
				if(first)
				{
					first = false;
					inputId.setForeground(Color.black);
					inputId.setText("");
				}
			}
			public void focusLost(FocusEvent e) {}
		});
		
		this.add(inputId);
		inputPassword = new JPasswordField();
		inputPassword.setBounds(150, 700, 340, 70);
		inputPassword.setBorder(new EmptyBorder(0, 0, 0, 0));
		inputPassword.setFont(new Font("���� ����" , Font.PLAIN , 30));
		inputPassword.setForeground(Color.GRAY);
		inputPassword.setText("��й�ȣ");
		inputPassword.addFocusListener(new FocusListener() 	//placeHolder ȿ��
		{
			boolean first = true;
			public void focusGained(FocusEvent e) {
				if(first)
				{
					first = false;
					inputPassword.setForeground(Color.black);
					inputPassword.setText("");
				}
			}
			public void focusLost(FocusEvent e) {}
		});
		this.add(inputPassword);
		
		btnLogin = new JButton();
		btnLogin.setBounds(50,800,220,70);
		btnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogin.setFont(new Font("���� ����" , Font.PLAIN , 30));
		btnLogin.setText("�α���");
		btnLogin.setBackground(new Color(0xaa,0xff,0xaa));
		this.add(btnLogin);
		
		btnSignUp = new JButton();
		btnSignUp.setBounds(270,800,220,70);
		btnSignUp.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSignUp.setFont(new Font("���� ����" , Font.PLAIN , 30));
		btnSignUp.setText("ȸ������");
		btnSignUp.setBackground(new Color(0xff,0xff,0xaa));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				MainFrame.getInstance().changeView(SignUpView.getInstance());
			}
		});
		this.add(btnSignUp);
	}
	static public LoginView getInstance()	//SingleTon
	{
		if(!haveInstance)
		{
			haveInstance = false;
			instance = new LoginView();
		}
		return instance;
	}
	public void paint(Graphics g)
	{
		g.setColor(colorBackground);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(DataBase.getDataBase().getImage("img_logo"), 50 , 20 ,400,150, this);
		g.drawImage(DataBase.getDataBase().getImage("img_mafia") ,0 , 200 , 540 , 300,this);
		
		g.setColor(new Color(0xFF,0xCC,0x44));
		g.fillRect(50,600,100,70);
		g.fillRect(50,700,100,70);
		
		g.drawImage(DataBase.getDataBase().getImage("img_lock"),75,610,50,50, this);
		g.drawImage(DataBase.getDataBase().getImage("img_key") ,75,710,50,50,this);
		
		this.paintComponents(g);
	}

}
