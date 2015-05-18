package com.racer.searchengine.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import com.racer.searchengine.bot.*;

/**
 * This application displays a dialog box that allow the user to specify any URL.
 * The URL is requested using the bot package, and displayed in this dialog box.
 * Both the body and header are displayed.
 * @author Ren Wanchun
 * @version v1.0
 * @see 
 */

public class ViewURL extends javax.swing.JFrame{
	/**
	 * The HTTP connection used by this application
	 */
	HTTP _http;

	/**
	 * The constructor. This method sets up all the components needed by this class.
	 * A new HTTPSocket object is aslo constructed to manage the connection.
	 */
	public ViewURL(){
		_http = new HTTPSocket();
		//{{
		setTitle("View URL");
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		setSize(495,341);
		System.out.println("init");
		this.setResizable(false);

		getContentPane().add(_pane2);
		_pane2.setBounds(12,168,456,144);
		_body.setEditable(false);
		_pane2.getViewport().add(_body);
		_body.setBounds(0,0,453,141);
		getContentPane().add(_pane1);
		_pane1.setBounds(12,72,456,72);
		_pane1.getViewport().add(_headers);
		_headers.setBounds(0,0,453,0);
		_label3.setText("Body");
		getContentPane().add(_label3);
		_label3.setBounds(12,144,456,12);
		_label1.setText("URL:");
		getContentPane().add(_label1);
		_label1.setBounds(12,12,36,24);
		_url.setText("http://www.jeffheaton.com");
		getContentPane().add(_url);
		_url.setBounds(48,12,348,24);
		_go.setText("Go");
		_go.setActionCommand("Go");
		getContentPane().add(_go);
		_go.setBounds(408,12,60,24);
		_label2.setText("HTTP Headers");
		getContentPane().add(_label2);
		_label2.setBounds(12,48,384,12);

		//}}

		//{{
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		_go.addActionListener(lSymAction);
		//}}
	}

	public void setVisible(boolean b){
		if(b){
			setLocation(50,50);
		}
		super.setVisible(b);
	}

	public static void main(String[] args) {
		ViewURL view= new ViewURL();
		view.setVisible(true);
	}

	public void addNotify(){
		System.out.println("add nofity");
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
	javax.swing.JScrollPane _pane1 = new javax.swing.JScrollPane();
	javax.swing.JScrollPane _pane2 = new javax.swing.JScrollPane();
	javax.swing.JTable _headers = new javax.swing.JTable();
	javax.swing.JTextArea _body = new javax.swing.JTextArea();
	javax.swing.JLabel _label1 = new javax.swing.JLabel();
	javax.swing.JLabel _label2 = new javax.swing.JLabel();
	javax.swing.JLabel _label3 = new javax.swing.JLabel();
	javax.swing.JTextField _url = new javax.swing.JTextField();
	javax.swing.JButton _go = new javax.swing.JButton();
	//}}

	class SymWindow extends java.awt.event.WindowAdapter{
		public void windowClosed(java.awt.event.WindowEvent event){
			Object object = event.getSource();
			if(object==ViewURL.this){
				ViewURL_windowClosed(event);
			}
		}
		public void windowClosing(java.awt.event.WindowEvent event){
			Object object = event.getSource();
			if(object==ViewURL.this)
				ViewURL_windowClosing(event);
		}
	}


	void ViewURL_windowClosing(java.awt.event.WindowEvent event){
		setVisible(false);
		dispose();
	}

	void ViewURL_windowClosed(java.awt.event.WindowEvent event){
		System.exit(0);
	}


	class SymAction implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent event){
			Object object=event.getSource();
			if(object==_go)
				Go_actionPerformed(event);
		}
	}

	void Go_actionPerformed(java.awt.event.ActionEvent event){
		try{
			System.out.println("go event");
			Log.setLevel(Log.LOG_LEVEL_DUMP);
			_http.send(_url.getText(),null);
			_body.setText(_http.getBody());
			_url.setText(_http.getURL());
			TableModel dataModel = new AbstractTableModel(){
				public int getColumnCount(){
					return 2;
				}
				public int getRowCount(){
					return _http.getServerHeaders().length();
				}
				public String getColumnName(int columnIndex){
					switch(columnIndex){
						case 0:return "HTTP Header";
						case 1:return "Value";
					}
					return "";
				}
				public Object getValueAt(int row,int col){
					if(col==0)
						return _http.getServerHeaders().get(row).getName();
					else
						return _http.getServerHeaders().get(row).getValue();
				}
			};
			_headers.setModel(dataModel);
			_headers.sizeColumnsToFit(0);

		}
		catch(Exception e){
			_body.setText(e.toString());
		}
	}
}


