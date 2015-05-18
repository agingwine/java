package com.racer.searchengine.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 邮件客户端示例
 * @author Ren Wanchun
 * @version 1.0
*/

public class SendMail extends javax.swing.JFrame{
	public SendMail(){
		//{{INIT_CONTROLS
		this.setTitle("SendMail Example");
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);

		System.out.println("init");
		this.setSize(736,312);
		this.setResizable(false);
		this.setVisible(false);
		this.JLabel1.setText("From:");
		getContentPane().add(JLabel1);
		JLabel1.setBounds(12,12,36,12);
		this.JLabel2.setText("To:");
		getContentPane().add(JLabel2);
		JLabel2.setBounds(12,48,36,12);
		this.JLabel3.setText("Subject:");
		getContentPane().add(JLabel3);
		JLabel3.setBounds(12,84,48,12);
		this.JLabel4.setText("SMTP Server:");
		getContentPane().add(JLabel4);
		JLabel4.setBounds(12,120,84,12);
		getContentPane().add(_from);
		_from.setBounds(96,12,300,24);
		getContentPane().add(_to);
		_to.setBounds(96,48,300,24);
		getContentPane().add(_subject);
		_subject.setBounds(96,84,300,24);
		getContentPane().add(_smtp);
		_smtp.setBounds(96,120,300,24);
		getContentPane().add(_scrollPane2);
		_scrollPane2.setBounds(12,156,384,108);
		_body.setText("Enter your message here");
		_scrollPane2.getViewport().add(_body);
		_body.setBounds(0,0,381,105);
		SendButton.setText("Send");
		SendButton.setActionCommand("Send");
		getContentPane().add(SendButton);
		SendButton.setBounds(60,276,132,24);
		CancelButton.setText("Cancel");
		CancelButton.setActionCommand("Cancel");
		getContentPane().add(CancelButton);
		CancelButton.setBounds(216,276,120,24);
		getContentPane().add(_scrollPane1);
		_scrollPane1.setBounds(408,12,312,288);
		getContentPane().add(_output);
		_output.setBounds(408,12,309,285);
		//}}

		//{{INIT_MENUS

		//}}

		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		SendButton.addActionListener(lSymAction);
		CancelButton.addActionListener(lSymAction);
		//}}

		_output.setModel(_model);
		_model.addElement("Server output displayed here:");
		_scrollPane1.getViewport().setView(_output);
		_scrollPane2.getViewport().setView(_body);
	}

	/**
	 * main函数
	 * @param args Command line arguments
	 */
	public static void main(String[] args){
		SendMail sm = new SendMail();
		sm.setVisible(true);
	}
	

	/**
	 * 显示时将窗口移动到指定位置
	 *
	 * @param b True to make visible, false to make invisible
	 */
	public void setVisible(boolean b){
		if(b)
			setLocation(50,50);
		super.setVisible(b);
	}

	
	public void addNotify(){
		Dimension size=this.getSize();
		super.addNotify();
		if(frameSizeAdjusted)
			return;
		frameSizeAdjusted=true;
		Insets insets=this.getInsets();
		javax.swing.JMenuBar menuBar = this.getRootPane().getJMenuBar();
		int menuBarHeight = 0;

		if(menuBar!=null){
			menuBarHeight = menuBar.getPreferredSize().height;
		}
		this.setSize(insets.left+insets.right+size.width,insets.top+insets.bottom+size.height+menuBarHeight);
	}

	// Used by addNotify
	boolean frameSizeAdjusted = false;
	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JTextField _from  = new javax.swing.JTextField();
	javax.swing.JTextField _to  = new javax.swing.JTextField();
	javax.swing.JTextField _subject  = new javax.swing.JTextField();
	javax.swing.JTextField _smtp  = new javax.swing.JTextField();
	javax.swing.JScrollPane _scrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JScrollPane _scrollPane2 = new javax.swing.JScrollPane();
	javax.swing.JTextArea _body= new javax.swing.JTextArea();
	javax.swing.JButton SendButton = new javax.swing.JButton();
	javax.swing.JButton CancelButton = new javax.swing.JButton();
	javax.swing.JList _output = new javax.swing.JList();
	javax.swing.DefaultListModel _model = new javax.swing.DefaultListModel();
	java.io.BufferedReader _in;
	java.io.PrintWriter _out;
	//}}

	//{{DECLARE_MENUS
	//}}

	/**
	 * @discription 分发事件的内部类
	 * @author Ren Wanchun
	 * @version v1.0
	 */
	class SymAction implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent event){
			Object object = event.getSource();
			if(object==SendButton){
				Send_actionPerformed(event);
			}
			else if(object==CancelButton){
				Cancel_actionPerformed(event);
			}
		}
	}

	/**
	 * 发送字符串
	 * 发送的字符串以及接收到的结果都将显示在JList _output中
	 * 传递null值将等待一个响应
	 */
	protected void send(String s)throws java.io.IOException{
		//Send the SMTP Command
		if(s!=null){
			_model.addElement("C:"+s);
			_out.println(s);
			_out.flush();
		}
		//Wait for the Response
		String line=_in.readLine();
		if(line!=null){
			_model.addElement("S:"+line);
		}
	}
	/**
	 * 当SendButton的点击时触发
	 */
	void Send_actionPerformed(java.awt.event.ActionEvent event){
		System.out.println("Send Click");
		try{
			//ip地址,端口25为smtp协议
			java.net.Socket socket = new java.net.Socket(_smtp.getText(),25);
			//装饰者模式
			_out = new java.io.PrintWriter(socket.getOutputStream());
			_in = new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
			send(null);
			send("HELO "+java.net.InetAddress.getLocalHost().getHostName());
			send("MAIL FROM: "+_from.getText());
			send("RCTP TO: "+_to.getText());
			send("DATA");
			_out.println("Subject:" + _subject.getText());
			_out.println(_body.getText());
			send(".");
			socket.close();
		}
		catch(Exception e){
			_model.addElement("Error: "+e);
		}
	}

	void Cancel_actionPerformed(java.awt.event.ActionEvent event){
		System.out.println("Cancel click");
		System.exit(0);
	}
}