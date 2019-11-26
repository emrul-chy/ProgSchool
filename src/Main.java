import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;

import java.sql.*;

public class Main extends JFrame{
	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{

					JFrame frame = new Main();
					frame.setTitle("ProgSchool");
					frame.setVisible(true);
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
	}
	

	int isAdmin=0;
	
	Connection conn = null;
	
	public Main() {
		
		
		UIManager.put("OptionPane.messageFont", new Font("Ubuntu", Font.PLAIN, 15));
		UIManager.put("OptionPane.buttonFont", new Font("Ubuntu", Font.PLAIN, 13));

		// setUndecorated(true);
		JMenuBar jmb = new JMenuBar();
		
		
		JMenu container = new JMenu("ProgSchool");
		container.setModel(new FixedStateButtonModel());
		container.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		
		jmb.add(container);
		
		JMenuItem menuLogin = new JMenuItem("Log In");
		JMenuItem menuLogout = new JMenuItem("Logout");
		JMenuItem menuSignup = new JMenuItem("Sign Up");
		JMenuItem menuDashboard = new JMenuItem("Dashboard");
		JMenuItem menuExit = new JMenuItem("Exit");
		JMenuItem menuProfile = new JMenuItem("Profile");
		JMenuItem menuAbout = new JMenuItem("About");
		
		menuLogin.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		menuLogout.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		menuSignup.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		menuDashboard.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		menuExit.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		menuProfile.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		menuAbout.setFont(new Font("Ubuntu", Font.PLAIN, 17));

		container.add(menuLogin);
		container.add(menuSignup); container.add(menuAbout);
		container.add(menuExit);
		

		JLabel nameUser = new JLabel();

		
		JPanel panelTutorial = new JPanel();

		JPanel panelProblem = new JPanel();
		
		
		conn = sqlConnection.dbConnection();
		setSize(1366, 768);
		setLayout(null);
		ImageIcon ic = new ImageIcon("images/sys_logo.png");

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setLayout(null);
		// setResizable(false);
		JLabel logo = new JLabel(ic);

		ic = new ImageIcon("images/background.jpg");
		//final Image image = requestImage();
		
		
		ImagePanel panel = new ImagePanel(ic.getImage());
		//setBackground(ic);
		setBounds(0,0,1366,768);
		setLayout(null);

		logo.setBounds(1366-290-20, 20, 290, 64);
		add(logo);
		logo.setVisible(true);
		
		JLabel containerText= new JLabel("Log In");
		containerText.setBounds(20,0, 300, 64);
		containerText.setForeground(new Color(51, 54, 102));
		containerText.setFont(new Font("Ubuntu", Font.BOLD, 33));
		
		add(containerText);
		
	//	JLabel containerText = new JLabel("Username");

		
		ic = new ImageIcon("images/user_icon.png");
		
		JLabel user_ic = new JLabel(ic);
		
		
		///***********Login Panel
		
		JPanel panelLogin = new JPanel();
		add(panelLogin);
		panelLogin.setOpaque(false);
		panelLogin.setVisible(false);
		panelLogin.setBounds(0,0,1366,768);
		panelLogin.setLayout(null);

		
		panelLogin.add(user_ic);
		
		
		int X=170;
		int Y=583;
		user_ic.setBounds(Y+40, X, 130,130);
		
		X += 150;
		
		JTextField user_name_form = new JTextField("Username");
		user_name_form.setBounds(Y, X, 210, 45);
		user_name_form.setBorder(new RoundedBorder(4));
		user_name_form.setForeground(new Color(51, 54, 102));
		user_name_form.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		
		panelLogin.add(user_name_form);
		
		X+=50;
		
		JLabel user_name = new JLabel("Username");
		user_name.setBounds(Y, X, 210, 30);
		user_name.setForeground(new Color(51, 54, 102));
		user_name.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelLogin.add(user_name);
		
		

		
		X+=40;

		
		
		JPasswordField password_form = new JPasswordField("");
		password_form.setBounds(Y, X, 210, 45);
		password_form.setBorder(new RoundedBorder(4));
		password_form.setForeground(new Color(51, 54, 102));
		password_form.setFont(new Font("Ubuntu", Font.PLAIN, 15));

		panelLogin.add(password_form);

		X+=50;
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(Y, X, 210, 30);
		pass.setForeground(new Color(51, 54, 102));
		pass.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelLogin.add(pass);
		
		user_name_form.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	user_name_form.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        // nothing
		    }

		});
		
		X+=40;
		
		
		
		ic = new ImageIcon("images/login_ic.png");
		JLabel login_button = new JLabel(ic);
		login_button.setBounds(Y, X, 100, 45);
		//login_button.setBackground(null);
		login_button.setBorder(null);
		//login_button.setC
	//	login_button.setFocusPainted(false);
	
		
		panelLogin.add(login_button);

		ic = new ImageIcon("images/signup_ic.png");
		JLabel btn_signup = new JLabel(ic);
		btn_signup.setBounds(693, X+1, 100, 45);
		btn_signup.setBorder(null);
		
		X+=45;
		//System.out.println(X);
		panelLogin.add(btn_signup);
		panelLogin.setVisible(true);
		
		
		
		/// ---------------------ADMIN PANEL-------------------//
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setOpaque(false);
		panelAdmin.setVisible(false);
		panelAdmin.setBounds(0,0,1366,768);
		panelAdmin.setLayout(null);
		
		int y = 44;
		int x = 120;
		int wd = 220;
		int ht = 30;
		
		// Tutorial List
		
		JLabel adminTutorialList = new JLabel("Tutorial List");
		adminTutorialList.setBounds(y, x, wd, ht);
		adminTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminTutorialList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminTutorialList);
		
		JComboBox<String> combo_adminTutorialList = new JComboBox<String>();
		
		
		combo_adminTutorialList.setBounds(y, x+40, wd, ht);
		combo_adminTutorialList.setVisible(true);
		combo_adminTutorialList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminTutorialList.setBackground(Color.WHITE);
		combo_adminTutorialList.setForeground(new Color(51, 54, 102));
		combo_adminTutorialList.setBorder(null);
		combo_adminTutorialList.setFocusable(false);
		panelAdmin.add(combo_adminTutorialList);
		
		JButton btn_adminSelectTutorialList = new JButton("Select");
		btn_adminSelectTutorialList.setBounds(y, x+85, 105, 30);
		btn_adminSelectTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminSelectTutorialList.setForeground(Color.WHITE);
		btn_adminSelectTutorialList.setModel(new FixedStateButtonModel());
		btn_adminSelectTutorialList.setBorder(null);
		btn_adminSelectTutorialList.setFocusable(false);
		panelAdmin.add(btn_adminSelectTutorialList);
		
		JButton btn_adminAddTutorialList = new JButton("Add New");
		btn_adminAddTutorialList.setBounds(y+115, x+85, 105, 30);
		btn_adminAddTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminAddTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminAddTutorialList.setForeground(Color.WHITE);
		btn_adminAddTutorialList.setModel(new FixedStateButtonModel());
		btn_adminAddTutorialList.setBorder(null);
		btn_adminAddTutorialList.setFocusable(false);
		panelAdmin.add(btn_adminAddTutorialList);
		
		
		JButton btn_adminEditTutorialList = new JButton("Edit");
		btn_adminEditTutorialList.setBounds(y, x+125, 105, 30);
		btn_adminEditTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminEditTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminEditTutorialList.setForeground(Color.WHITE);
		btn_adminEditTutorialList.setModel(new FixedStateButtonModel());
		btn_adminEditTutorialList.setBorder(null);
		btn_adminEditTutorialList.setFocusable(false);
		btn_adminEditTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminEditTutorialList);
		
		
		JButton btn_adminDeleteTutorialList = new JButton("Delete");
		btn_adminDeleteTutorialList.setBounds(y+115, x+125, 105, 30);
		btn_adminDeleteTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteTutorialList.setForeground(Color.WHITE);
		btn_adminDeleteTutorialList.setModel(new FixedStateButtonModel());
		btn_adminDeleteTutorialList.setBorder(null);
		btn_adminDeleteTutorialList.setFocusable(false);
		btn_adminDeleteTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteTutorialList);
		
		JLabel adminTutorialTitle = new JLabel("Title");
		adminTutorialTitle.setBounds(y, x+165, wd, 30);
		adminTutorialTitle.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminTutorialTitle.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminTutorialTitle);
		
		JTextField txt_adminTutorialTitle = new JTextField();
		txt_adminTutorialTitle.setBounds(y, x+205, wd, 30);
		txt_adminTutorialTitle.setBorder(new RoundedBorder(4));
		txt_adminTutorialTitle.setForeground(new Color(51, 54, 102));
		txt_adminTutorialTitle.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txt_adminTutorialTitle.setEditable(false);
		panelAdmin.add(txt_adminTutorialTitle);
		
		JLabel adminTutorialBody = new JLabel("Body");
		adminTutorialBody.setBounds(y, x+245, wd, 30);
		adminTutorialBody.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminTutorialBody.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminTutorialBody);
		
		JTextArea txt_adminTutorialBody = new JTextArea();
		txt_adminTutorialBody.setBounds(y, x+285, wd, 100);
		txt_adminTutorialBody.setBorder(new RoundedBorder(4));
		txt_adminTutorialBody.setForeground(new Color(51, 54, 102));
		txt_adminTutorialBody.setFont(new Font("Ubuntu", Font.PLAIN, 15));
	//	txt_adminTutorialBody.setemrEditable(false);
	//	panelAdmin.add(txt_adminTutorialBody);
		
		JScrollPane srl_adminTutorialBody = new JScrollPane(txt_adminTutorialBody);
		srl_adminTutorialBody.setBounds(y, x+285, wd, 150);
	//	srl_adminTutorialBody.setBorder(new RoundedBorder(4));
		srl_adminTutorialBody.setForeground(new Color(51, 54, 102));
		srl_adminTutorialBody.setBorder(null);
		srl_adminTutorialBody.setFont(new Font("Courier New", Font.PLAIN, 15));
		txt_adminTutorialBody.setEditable(false);
		panelAdmin.add(srl_adminTutorialBody);
		
		JButton btn_adminUpdateInsertTutorialList = new JButton("Update / Insert");
		btn_adminUpdateInsertTutorialList.setBounds(y, x+445, wd, 30);
		btn_adminUpdateInsertTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminUpdateInsertTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminUpdateInsertTutorialList.setForeground(Color.WHITE);
		btn_adminUpdateInsertTutorialList.setModel(new FixedStateButtonModel());
		btn_adminUpdateInsertTutorialList.setBorder(null);
		btn_adminUpdateInsertTutorialList.setFocusable(false);
		btn_adminUpdateInsertTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminUpdateInsertTutorialList);
		
		JButton btn_adminCancelTutorialList = new JButton("Cancel");
		btn_adminCancelTutorialList.setBounds(y, x+485, wd, 30);
		btn_adminCancelTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminCancelTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminCancelTutorialList.setForeground(Color.WHITE);
		btn_adminCancelTutorialList.setModel(new FixedStateButtonModel());
		btn_adminCancelTutorialList.setBorder(null);
		btn_adminCancelTutorialList.setFocusable(false);
		btn_adminCancelTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminCancelTutorialList);
		
		btn_adminSelectTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_tutorial where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminTutorialList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					btn_adminSelectTutorialList.setEnabled(true);
					int  cnt=0;
					while(rs.next())
					{
						txt_adminTutorialTitle.setText(rs.getString("Title"));
						txt_adminTutorialTitle.setEnabled(true);
						txt_adminTutorialTitle.setEditable(false);
						txt_adminTutorialBody.setText(rs.getString("Body"));
						txt_adminTutorialBody.setCaretPosition(0);
						txt_adminTutorialBody.setEnabled(true);
						txt_adminTutorialBody.setEditable(false);
						btn_adminUpdateInsertTutorialList.setText("Update");
						cnt = cnt+1;
					}
					
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				btn_adminEditTutorialList.setEnabled(true);
				btn_adminDeleteTutorialList.setEnabled(true);
				btn_adminAddTutorialList.setEnabled(false);
				btn_adminSelectTutorialList.setEnabled(false);
				btn_adminCancelTutorialList.setEnabled(true);
			}
		});
		
		btn_adminAddTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn_adminUpdateInsertTutorialList.setEnabled(true);
				btn_adminUpdateInsertTutorialList.setText("Insert");
				txt_adminTutorialBody.setText("");
				txt_adminTutorialBody.setEditable(true);
				txt_adminTutorialBody.setEnabled(true);
				txt_adminTutorialTitle.setText("");
				txt_adminTutorialTitle.setEditable(true);
				txt_adminTutorialTitle.setEnabled(true);
				btn_adminDeleteTutorialList.setEnabled(false);
				btn_adminEditTutorialList.setEnabled(false);
				btn_adminCancelTutorialList.setEnabled(true);
			}
		});
		
		btn_adminEditTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				btn_adminUpdateInsertTutorialList.setEnabled(true);
				btn_adminEditTutorialList.setEnabled(false);
				txt_adminTutorialBody.setEditable(true);
				txt_adminTutorialBody.setEnabled(true);
				txt_adminTutorialTitle.setEnabled(true);
				btn_adminSelectTutorialList.setEnabled(false);
			}
		});
		
		btn_adminDeleteTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "delete from tbl_tutorial where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminTutorialList.getSelectedItem().toString());
					pst.execute();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
				combo_adminTutorialList.removeAllItems();
				
				try
				{
					String query = "select * from tbl_tutorial";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					int  cnt=0;
					while(rs.next())
					{
						combo_adminTutorialList.addItem(rs.getString("Title"));
						cnt = cnt+1;
					}
					
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
				if(combo_adminTutorialList.getItemCount()==0)
				{

					btn_adminSelectTutorialList.setEnabled(false);
				}
				else
				{

					btn_adminSelectTutorialList.setEnabled(true);
				}
				
				
				btn_adminEditTutorialList.setEnabled(false);
				btn_adminDeleteTutorialList.setEnabled(false);
				btn_adminAddTutorialList.setEnabled(true);
				txt_adminTutorialBody.setEnabled(false);
				txt_adminTutorialTitle.setEnabled(false);
				txt_adminTutorialBody.setEditable(false);
				txt_adminTutorialTitle.setEnabled(false);
				txt_adminTutorialBody.setText("");
				txt_adminTutorialTitle.setText("");
				btn_adminUpdateInsertTutorialList.setEnabled(false);
				btn_adminUpdateInsertTutorialList.setText("Update / Insert");
				btn_adminCancelTutorialList.setEnabled(false);
			}
		});
		
		btn_adminUpdateInsertTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(btn_adminUpdateInsertTutorialList.getText().equals("Update"))
				{
					try
					{
						String qry = "Update tbl_tutorial Set Body = ? where Title = ?";
						PreparedStatement pst1 = conn.prepareStatement(qry);
						pst1.setString(2, txt_adminTutorialTitle.getText());
						pst1.setString(1, txt_adminTutorialBody.getText());
						
						
						pst1.execute();
						pst1.close();
						JOptionPane.showMessageDialog(null, "Tutorial updated successfully!");	
					} catch (Exception e2)
					{
						e2.printStackTrace();
					}
				}
				else
				{
					try
					{
						String query = "select * from tbl_tutorial where Title=?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, txt_adminTutorialTitle.getText());
				//		System.out.println(combo_adminTutorialList.getSelectedItem().toString());
						ResultSet rs = pst.executeQuery();
						
						int cnt=0;
						
						while(rs.next())
						{
							cnt = cnt+1;
						}
						if(cnt == 1)
						{
							JOptionPane.showMessageDialog(null, "Tutorial already exits.");
							
						}
						else if(txt_adminTutorialTitle.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null, "Tutorial Name is required!.");
						}
						else if(txt_adminTutorialBody.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null, "Tutorial Body can not be empty.");
						}
						
						else if(btn_adminUpdateInsertTutorialList.getText().equals("Insert"))
						{
							try
							{
								String qry = "insert into tbl_tutorial(Title, Body) values(?, ?)";
								PreparedStatement pst1 = conn.prepareStatement(qry);
								pst1.setString(1, txt_adminTutorialTitle.getText());
								pst1.setString(2, txt_adminTutorialBody.getText());
								
								
								pst1.execute();
								pst1.close();
								
								JOptionPane.showMessageDialog(null, "Tutorial addded successfully!");	
							} catch (Exception e2)
							{
								e2.printStackTrace();
							}
							
						}
						rs.close();
						pst.close();
						
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
					combo_adminTutorialList.removeAllItems();
					
					try
					{
						String query = "select * from tbl_tutorial";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						int  cnt=0;
						while(rs.next())
						{
							combo_adminTutorialList.addItem(rs.getString("Title"));
							cnt = cnt+1;
						}
						
						
						rs.close();
						pst.close();
						
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
						
					}
				
				}
				btn_adminEditTutorialList.setEnabled(false);
				btn_adminDeleteTutorialList.setEnabled(false);
				btn_adminSelectTutorialList.setEnabled(true);
				btn_adminAddTutorialList.setEnabled(true);
				txt_adminTutorialBody.setEnabled(false);
				txt_adminTutorialTitle.setEnabled(false);
				txt_adminTutorialBody.setEditable(false);
				txt_adminTutorialTitle.setEnabled(false);
				txt_adminTutorialBody.setText("");
				txt_adminTutorialTitle.setText("");
				btn_adminUpdateInsertTutorialList.setEnabled(false);
				btn_adminUpdateInsertTutorialList.setText("Update / Insert");
				btn_adminCancelTutorialList.setEnabled(false);
			}
		});
		
		btn_adminCancelTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_adminEditTutorialList.setEnabled(false);
				btn_adminDeleteTutorialList.setEnabled(false);
				btn_adminSelectTutorialList.setEnabled(true);
				btn_adminAddTutorialList.setEnabled(true);
				txt_adminTutorialBody.setEnabled(false);
				txt_adminTutorialTitle.setEnabled(false);
				txt_adminTutorialBody.setEditable(false);
				txt_adminTutorialTitle.setEnabled(false);
				txt_adminTutorialBody.setText("");
				txt_adminTutorialTitle.setText("");
				btn_adminUpdateInsertTutorialList.setEnabled(false);
				btn_adminUpdateInsertTutorialList.setText("Update / Insert");
				btn_adminCancelTutorialList.setEnabled(false);

			}
		});
		
		//Request Tutorial List
		
		y+=264;
		
		JLabel adminRequestTutorialList = new JLabel("Requested Tutorial List");
		adminRequestTutorialList.setBounds(y, x, wd, ht);
		adminRequestTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminRequestTutorialList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminRequestTutorialList);
		
		JComboBox<String> combo_adminRequestTutorialList = new JComboBox<String>();
		
		
		combo_adminRequestTutorialList.setBounds(y, x+40, wd, ht);
		combo_adminRequestTutorialList.setVisible(true);
		combo_adminRequestTutorialList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminRequestTutorialList.setBackground(Color.WHITE);
		combo_adminRequestTutorialList.setForeground(new Color(51, 54, 102));
		combo_adminRequestTutorialList.setBorder(null);
		combo_adminRequestTutorialList.setFocusable(false);
		panelAdmin.add(combo_adminRequestTutorialList);
		
		JButton btn_adminSelectRequestTutorialList = new JButton("Select");
		btn_adminSelectRequestTutorialList.setBounds(y, x+85, 105, 30);
		btn_adminSelectRequestTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectRequestTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminSelectRequestTutorialList.setForeground(Color.WHITE);
		btn_adminSelectRequestTutorialList.setModel(new FixedStateButtonModel());
		btn_adminSelectRequestTutorialList.setBorder(null);
		btn_adminSelectRequestTutorialList.setFocusable(false);
		panelAdmin.add(btn_adminSelectRequestTutorialList);
		
		JButton btn_adminDeleteRequestTutorialList = new JButton("Delete");
		btn_adminDeleteRequestTutorialList.setBounds(y+115, x+85, 105, 30);
		btn_adminDeleteRequestTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteRequestTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteRequestTutorialList.setForeground(Color.WHITE);
		btn_adminDeleteRequestTutorialList.setModel(new FixedStateButtonModel());
		btn_adminDeleteRequestTutorialList.setBorder(null);
		btn_adminDeleteRequestTutorialList.setFocusable(false);
		btn_adminDeleteRequestTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteRequestTutorialList);
		
		JTextArea adminShowRequestTutorialList = new JTextArea("");
		adminShowRequestTutorialList.setBounds(y, x+130, 220, 300);
		adminShowRequestTutorialList.setForeground(new Color(51, 54, 102));
		adminShowRequestTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 14));
		adminShowRequestTutorialList.setOpaque(false);
		adminShowRequestTutorialList.setWrapStyleWord(true);
		adminShowRequestTutorialList.setLineWrap(true);
		adminShowRequestTutorialList.setEditable(false);
		panelAdmin.add(adminShowRequestTutorialList);
		
		btn_adminSelectRequestTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_request_tutorial where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminRequestTutorialList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					btn_adminDeleteRequestTutorialList.setEnabled(true);
					
					int  cnt=0;
					while(rs.next())
					{
						adminShowRequestTutorialList.setText(
								"Title: " +
								rs.getString("Title") + "\n\n" +
								"Requested by: " + rs.getString("Author")+ "\n\n"
								
						);
						cnt = cnt+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}	
			}
		});
		
		btn_adminDeleteRequestTutorialList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "delete from tbl_request_tutorial where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminRequestTutorialList.getSelectedItem().toString());
					pst.execute();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
				combo_adminRequestTutorialList.removeAllItems();
				
				try
				{
					String query = "select * from tbl_request_tutorial";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					int  cnt=0;
					while(rs.next())
					{
						combo_adminRequestTutorialList.addItem(rs.getString("Title"));
						cnt = cnt+1;
					}
					
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				adminShowRequestTutorialList.setText("");
				
				if(combo_adminRequestTutorialList.getItemCount()==0)
				{

					btn_adminSelectRequestTutorialList.setEnabled(false);
				}
				else
				{

					btn_adminSelectRequestTutorialList.setEnabled(true);
				}
				
				
				btn_adminDeleteRequestTutorialList.setEnabled(false);
			}
		});

		
		y+=264;
		
		
		
		
		//problem List
		
		JLabel adminProblemList = new JLabel("Problem List");
		adminProblemList.setBounds(y, x, wd, ht);
		adminProblemList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminProblemList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminProblemList);
		
		JComboBox<String> combo_adminProblemList = new JComboBox<String>();
		
		
		combo_adminProblemList.setBounds(y, x+40, wd, ht);
		combo_adminProblemList.setVisible(true);
		combo_adminProblemList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminProblemList.setBackground(Color.WHITE);
		combo_adminProblemList.setForeground(new Color(51, 54, 102));
		combo_adminProblemList.setBorder(null);
		combo_adminProblemList.setFocusable(false);
		panelAdmin.add(combo_adminProblemList);
		
		JButton btn_adminSelectProblemList = new JButton("Select");
		btn_adminSelectProblemList.setBounds(y, x+85, 105, 30);
		btn_adminSelectProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectProblemList.setBackground(new Color(51, 54, 102));
		btn_adminSelectProblemList.setForeground(Color.WHITE);
		btn_adminSelectProblemList.setModel(new FixedStateButtonModel());
		btn_adminSelectProblemList.setBorder(null);
		btn_adminSelectProblemList.setFocusable(false);
		panelAdmin.add(btn_adminSelectProblemList);
		
		JButton btn_adminAddProblemList = new JButton("Add New");
		btn_adminAddProblemList.setBounds(y+115, x+85, 105, 30);
		btn_adminAddProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminAddProblemList.setBackground(new Color(51, 54, 102));
		btn_adminAddProblemList.setForeground(Color.WHITE);
		btn_adminAddProblemList.setModel(new FixedStateButtonModel());
		btn_adminAddProblemList.setBorder(null);
		btn_adminAddProblemList.setFocusable(false);
		panelAdmin.add(btn_adminAddProblemList);
		
		
		JButton btn_adminEditProblemList = new JButton("Edit");
		btn_adminEditProblemList.setBounds(y, x+125, 105, 30);
		btn_adminEditProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminEditProblemList.setBackground(new Color(51, 54, 102));
		btn_adminEditProblemList.setForeground(Color.WHITE);
		btn_adminEditProblemList.setModel(new FixedStateButtonModel());
		btn_adminEditProblemList.setBorder(null);
		btn_adminEditProblemList.setFocusable(false);
		btn_adminEditProblemList.setEnabled(false);
		panelAdmin.add(btn_adminEditProblemList);
		
		
		JButton btn_adminDeleteProblemList = new JButton("Delete");
		btn_adminDeleteProblemList.setBounds(y+115, x+125, 105, 30);
		btn_adminDeleteProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteProblemList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteProblemList.setForeground(Color.WHITE);
		btn_adminDeleteProblemList.setModel(new FixedStateButtonModel());
		btn_adminDeleteProblemList.setBorder(null);
		btn_adminDeleteProblemList.setFocusable(false);
		btn_adminDeleteProblemList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteProblemList);
		
		JLabel adminProblemTitle = new JLabel("Title");
		adminProblemTitle.setBounds(y, x+165, wd, 30);
		adminProblemTitle.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminProblemTitle.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminProblemTitle);
		
		JTextField txt_adminProblemTitle = new JTextField();
		txt_adminProblemTitle.setBounds(y, x+205, wd, 30);
		txt_adminProblemTitle.setBorder(new RoundedBorder(4));
		txt_adminProblemTitle.setForeground(new Color(51, 54, 102));
		txt_adminProblemTitle.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txt_adminProblemTitle.setEditable(false);
		panelAdmin.add(txt_adminProblemTitle);
		
		JLabel adminProblemBody = new JLabel("Body");
		adminProblemBody.setBounds(y, x+245, wd, 30);
		adminProblemBody.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminProblemBody.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminProblemBody);
		
		JTextArea txt_adminProblemBody = new JTextArea();
		txt_adminProblemBody.setBounds(y, x+285, wd, 100);
		txt_adminProblemBody.setBorder(new RoundedBorder(4));
		txt_adminProblemBody.setForeground(new Color(51, 54, 102));
		txt_adminProblemBody.setFont(new Font("Courier New", Font.PLAIN, 15));
	//	txt_adminProblemBody.setemrEditable(false);
	//	panelAdmin.add(txt_adminProblemBody);
		
		JScrollPane srl_adminProblemBody = new JScrollPane(txt_adminProblemBody);
		srl_adminProblemBody.setBounds(y, x+285, wd, 150);
	//	srl_adminProblemBody.setBorder(new RoundedBorder(4));
		srl_adminProblemBody.setForeground(new Color(51, 54, 102));
		srl_adminProblemBody.setBorder(null);
		srl_adminProblemBody.setFont(new Font("Courier New", Font.PLAIN, 15));
		txt_adminProblemBody.setEditable(false);
		panelAdmin.add(srl_adminProblemBody);
		
		JButton btn_adminUpdateInsertProblemList = new JButton("Update / Insert");
		btn_adminUpdateInsertProblemList.setBounds(y, x+445, wd, 30);
		btn_adminUpdateInsertProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminUpdateInsertProblemList.setBackground(new Color(51, 54, 102));
		btn_adminUpdateInsertProblemList.setForeground(Color.WHITE);
		btn_adminUpdateInsertProblemList.setModel(new FixedStateButtonModel());
		btn_adminUpdateInsertProblemList.setBorder(null);
		btn_adminUpdateInsertProblemList.setFocusable(false);
		btn_adminUpdateInsertProblemList.setEnabled(false);
		panelAdmin.add(btn_adminUpdateInsertProblemList);
		
		JButton btn_adminCancelProblemList = new JButton("Cancel");
		btn_adminCancelProblemList.setBounds(y, x+485, wd, 30);
		btn_adminCancelProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminCancelProblemList.setBackground(new Color(51, 54, 102));
		btn_adminCancelProblemList.setForeground(Color.WHITE);
		btn_adminCancelProblemList.setModel(new FixedStateButtonModel());
		btn_adminCancelProblemList.setBorder(null);
		btn_adminCancelProblemList.setFocusable(false);
		btn_adminCancelProblemList.setEnabled(false);
		panelAdmin.add(btn_adminCancelProblemList);
		
		btn_adminSelectProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_problem where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminProblemList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					btn_adminSelectProblemList.setEnabled(true);
					int  cnt=0;
					while(rs.next())
					{
						txt_adminProblemTitle.setText(rs.getString("Title"));
						txt_adminProblemTitle.setEnabled(true);
						txt_adminProblemTitle.setEditable(false);
						txt_adminProblemBody.setText(rs.getString("Body"));
						txt_adminProblemBody.setCaretPosition(0);
						txt_adminProblemBody.setEnabled(true);
						txt_adminProblemBody.setEditable(false);
						btn_adminUpdateInsertProblemList.setText("Update");
						cnt = cnt+1;
					}
					
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				btn_adminEditProblemList.setEnabled(true);
				btn_adminDeleteProblemList.setEnabled(true);
				btn_adminAddProblemList.setEnabled(false);
				btn_adminSelectProblemList.setEnabled(false);
				btn_adminCancelProblemList.setEnabled(true);
			}
		});
		
		combo_adminProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_problem where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminProblemList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					btn_adminSelectProblemList.setEnabled(true);
					int  cnt=0;
					while(rs.next())
					{
						txt_adminProblemTitle.setText(rs.getString("Title"));
						txt_adminProblemTitle.setEnabled(true);
						txt_adminProblemTitle.setEditable(false);
						txt_adminProblemBody.setText(rs.getString("Body"));
						txt_adminProblemBody.setCaretPosition(0);
						txt_adminProblemBody.setEnabled(true);
						txt_adminProblemBody.setEditable(false);
						btn_adminUpdateInsertProblemList.setText("Update");
						cnt = cnt+1;
					}
					
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				btn_adminEditProblemList.setEnabled(true);
				btn_adminDeleteProblemList.setEnabled(true);
				btn_adminAddProblemList.setEnabled(false);
				btn_adminSelectProblemList.setEnabled(false);
				btn_adminCancelProblemList.setEnabled(true);

			}
		});
		
		btn_adminAddProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn_adminUpdateInsertProblemList.setEnabled(true);
				btn_adminUpdateInsertProblemList.setText("Insert");
				txt_adminProblemBody.setText("");
				txt_adminProblemBody.setEditable(true);
				txt_adminProblemBody.setEnabled(true);
				txt_adminProblemTitle.setText("");
				txt_adminProblemTitle.setEditable(true);
				txt_adminProblemTitle.setEnabled(true);
				btn_adminDeleteProblemList.setEnabled(false);
				btn_adminEditProblemList.setEnabled(false);
				btn_adminCancelProblemList.setEnabled(true);
			}
		});
		
		btn_adminEditProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				btn_adminUpdateInsertProblemList.setEnabled(true);
				btn_adminEditProblemList.setEnabled(false);
				txt_adminProblemBody.setEditable(true);
				txt_adminProblemBody.setEnabled(true);
				txt_adminProblemTitle.setEnabled(true);
				btn_adminSelectProblemList.setEnabled(false);
			}
		});
		
		btn_adminDeleteProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "delete from tbl_problem where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminProblemList.getSelectedItem().toString());
					pst.execute();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
				combo_adminProblemList.removeAllItems();
				
				try
				{
					String query = "select * from tbl_problem";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					int  cnt=0;
					while(rs.next())
					{
						combo_adminProblemList.addItem(rs.getString("Title"));
						cnt = cnt+1;
					}
					
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
				if(combo_adminProblemList.getItemCount() == 0)
				{
					btn_adminSelectProblemList.setEnabled(false);
				}
				else
				{
					btn_adminSelectProblemList.setEnabled(true);
				}
				
				btn_adminEditProblemList.setEnabled(false);
				btn_adminDeleteProblemList.setEnabled(false);
				btn_adminAddProblemList.setEnabled(true);
				txt_adminProblemBody.setEnabled(false);
				txt_adminProblemTitle.setEnabled(false);
				txt_adminProblemBody.setEditable(false);
				txt_adminProblemTitle.setEnabled(false);
				txt_adminProblemBody.setText("");
				txt_adminProblemTitle.setText("");
				btn_adminUpdateInsertProblemList.setEnabled(false);
				btn_adminUpdateInsertProblemList.setText("Update / Insert");
				btn_adminCancelProblemList.setEnabled(false);
			}
		});
		
		btn_adminUpdateInsertProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(btn_adminUpdateInsertProblemList.getText().equals("Update"))
				{
					try
					{
						String qry = "Update tbl_problem Set Body = ? where Title = ?";
						PreparedStatement pst1 = conn.prepareStatement(qry);
						pst1.setString(2, txt_adminProblemTitle.getText());
						pst1.setString(1, txt_adminProblemBody.getText());
						
						
						pst1.execute();
						pst1.close();
						JOptionPane.showMessageDialog(null, "Problem updated successfully!");	
					} catch (Exception e2)
					{
						e2.printStackTrace();
					}
				}
				else
				{
					try
					{
						String query = "select * from tbl_problem where Title=?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, txt_adminProblemTitle.getText());
						//System.out.println(combo_adminProblemList.getSelectedItem().toString());
						ResultSet rs = pst.executeQuery();
						
						int cnt=0;
						
						while(rs.next())
						{
							cnt = cnt+1;
						}
						if(cnt == 1)
						{
							JOptionPane.showMessageDialog(null, "Problem already exits.");
							
						}
						else if(txt_adminProblemTitle.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null, "Problem Name is required!.");
						}
						else if(txt_adminProblemBody.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null, "Problem Body can not be empty.");
						}
						
						else if(btn_adminUpdateInsertProblemList.getText().equals("Insert"))
						{
							try
							{
								String qry = "insert into tbl_problem(Title, Body) values(?, ?)";
								PreparedStatement pst1 = conn.prepareStatement(qry);
								pst1.setString(1, txt_adminProblemTitle.getText());
								pst1.setString(2, txt_adminProblemBody.getText());
								
								
								pst1.execute();
								pst1.close();
								
								JOptionPane.showMessageDialog(null, "Problem addded successfully!");	
							} catch (Exception e2)
							{
								e2.printStackTrace();
							}
							
						}
						rs.close();
						pst.close();
						
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
					combo_adminProblemList.removeAllItems();
					
					try
					{
						String query = "select * from tbl_problem";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						int  cnt=0;
						while(rs.next())
						{
							combo_adminProblemList.addItem(rs.getString("Title"));
							cnt = cnt+1;
						}
						
						
						rs.close();
						pst.close();
						
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
						
					}
				
				}
				btn_adminEditProblemList.setEnabled(false);
				btn_adminDeleteProblemList.setEnabled(false);
				btn_adminSelectProblemList.setEnabled(true);
				btn_adminAddProblemList.setEnabled(true);
				txt_adminProblemBody.setEnabled(false);
				txt_adminProblemTitle.setEnabled(false);
				txt_adminProblemBody.setEditable(false);
				txt_adminProblemTitle.setEnabled(false);
				txt_adminProblemBody.setText("");
				txt_adminProblemTitle.setText("");
				btn_adminUpdateInsertProblemList.setEnabled(false);
				btn_adminUpdateInsertProblemList.setText("Update / Insert");
				btn_adminCancelProblemList.setEnabled(false);
			}
		});
		
		btn_adminCancelProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_adminEditProblemList.setEnabled(false);
				btn_adminDeleteProblemList.setEnabled(false);
				btn_adminSelectProblemList.setEnabled(true);
				btn_adminAddProblemList.setEnabled(true);
				txt_adminProblemBody.setEnabled(false);
				txt_adminProblemTitle.setEnabled(false);
				txt_adminProblemBody.setEditable(false);
				txt_adminProblemTitle.setEnabled(false);
				txt_adminProblemBody.setText("");
				txt_adminProblemTitle.setText("");
				btn_adminUpdateInsertProblemList.setEnabled(false);
				btn_adminUpdateInsertProblemList.setText("Update / Insert");
				btn_adminCancelProblemList.setEnabled(false);

			}
		});

		y+=264;
		
		
		//Requested Problem List
		
		JLabel adminRequestProblemList = new JLabel("Requested Problem List");
		adminRequestProblemList.setBounds(y, x, wd, ht);
		adminRequestProblemList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminRequestProblemList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminRequestProblemList);
		
		JComboBox<String> combo_adminRequestProblemList = new JComboBox<String>();
		
		
		combo_adminRequestProblemList.setBounds(y, x+40, wd, ht);
		combo_adminRequestProblemList.setVisible(true);
		combo_adminRequestProblemList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminRequestProblemList.setBackground(Color.WHITE);
		combo_adminRequestProblemList.setForeground(new Color(51, 54, 102));
		combo_adminRequestProblemList.setBorder(null);
		combo_adminRequestProblemList.setFocusable(false);
		panelAdmin.add(combo_adminRequestProblemList);
		
		JButton btn_adminSelectRequestProblemList = new JButton("Select");
		btn_adminSelectRequestProblemList.setBounds(y, x+85, 105, 30);
		btn_adminSelectRequestProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectRequestProblemList.setBackground(new Color(51, 54, 102));
		btn_adminSelectRequestProblemList.setForeground(Color.WHITE);
		btn_adminSelectRequestProblemList.setModel(new FixedStateButtonModel());
		btn_adminSelectRequestProblemList.setBorder(null);
		btn_adminSelectRequestProblemList.setFocusable(false);
		panelAdmin.add(btn_adminSelectRequestProblemList);
		
		JButton btn_adminDeleteRequestProblemList = new JButton("Delete");
		btn_adminDeleteRequestProblemList.setBounds(y+115, x+85, 105, 30);
		btn_adminDeleteRequestProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteRequestProblemList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteRequestProblemList.setForeground(Color.WHITE);
		btn_adminDeleteRequestProblemList.setModel(new FixedStateButtonModel());
		btn_adminDeleteRequestProblemList.setBorder(null);
		btn_adminDeleteRequestProblemList.setFocusable(false);
		btn_adminDeleteRequestProblemList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteRequestProblemList);
		
		JTextArea adminShowRequestProblemList = new JTextArea("");
		adminShowRequestProblemList.setBounds(y, x+130, 220, 300);
		adminShowRequestProblemList.setForeground(new Color(51, 54, 102));
		adminShowRequestProblemList.setFont(new Font("Ubuntu", Font.BOLD, 14));
		adminShowRequestProblemList.setOpaque(false);
		adminShowRequestProblemList.setWrapStyleWord(true);
		adminShowRequestProblemList.setLineWrap(true);
		adminShowRequestProblemList.setEditable(false);
		panelAdmin.add(adminShowRequestProblemList);
		
		btn_adminSelectRequestProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_request_problem where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminRequestProblemList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					btn_adminDeleteRequestProblemList.setEnabled(true);
					
					int  cnt=0;
					while(rs.next())
					{
						adminShowRequestProblemList.setText(
								"Title: " +
								rs.getString("Title") + "\n\n" +
								"Requested by: " + rs.getString("Author")+ "\n\n"
								
						);
						cnt = cnt+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}	
			}
		});
		
		btn_adminDeleteRequestProblemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "delete from tbl_request_problem where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminRequestProblemList.getSelectedItem().toString());
					pst.execute();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
				combo_adminRequestProblemList.removeAllItems();
				
				try
				{
					String query = "select * from tbl_request_problem";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					int  cnt=0;
					while(rs.next())
					{
						combo_adminRequestProblemList.addItem(rs.getString("Title"));
						cnt = cnt+1;
					}
					
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
				adminShowRequestProblemList.setText("");
				
				if(combo_adminProblemList.getItemCount() == 0)
				{
					btn_adminSelectRequestProblemList.setEnabled(false);
				}
				else
				{
					btn_adminSelectRequestProblemList.setEnabled(true);
				}
				
				
				btn_adminDeleteRequestProblemList.setEnabled(false);
			}
		});
		

		y+=264;
		
		
		// User List
		
		JLabel adminUser = new JLabel("User List");
		adminUser.setBounds(y, x, wd, ht);
		adminUser.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminUser.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminUser);
		
		JComboBox<String> combo_adminUserList = new JComboBox<String>();
		
		
		combo_adminUserList.setBounds(y, x+40, wd, ht);
		combo_adminUserList.setVisible(true);
		combo_adminUserList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminUserList.setBackground(Color.WHITE);
		combo_adminUserList.setForeground(new Color(51, 54, 102));
		combo_adminUserList.setBorder(null);
		combo_adminUserList.setFocusable(false);
		panelAdmin.add(combo_adminUserList);
		
		
		JButton btn_adminSelectUserList = new JButton("Select");
		btn_adminSelectUserList.setBounds(y, x+85, 105, 30);
		btn_adminSelectUserList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectUserList.setBackground(new Color(51, 54, 102));
		btn_adminSelectUserList.setForeground(Color.WHITE);
		btn_adminSelectUserList.setModel(new FixedStateButtonModel());
		btn_adminSelectUserList.setBorder(null);
		btn_adminSelectUserList.setFocusable(false);
		panelAdmin.add(btn_adminSelectUserList);
		
		JTextArea adminShowUserInfo = new JTextArea("");
		adminShowUserInfo.setBounds(y, x+130, 220, 300);
		adminShowUserInfo.setForeground(new Color(51, 54, 102));
		adminShowUserInfo.setFont(new Font("Ubuntu", Font.BOLD, 14));
		adminShowUserInfo.setOpaque(false);
		adminShowUserInfo.setWrapStyleWord(true);
		adminShowUserInfo.setLineWrap(true);
		adminShowUserInfo.setEditable(false);
		panelAdmin.add(adminShowUserInfo);
		
		JButton btn_adminChangeUserRole = new JButton("Change Role");
		btn_adminChangeUserRole.setBounds(y+115, x+85, 105, 30);
		btn_adminChangeUserRole.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminChangeUserRole.setBackground(new Color(51, 54, 102));
		btn_adminChangeUserRole.setForeground(Color.WHITE);
		btn_adminChangeUserRole.setModel(new FixedStateButtonModel());
		btn_adminChangeUserRole.setBorder(null);
		btn_adminChangeUserRole.setFocusable(false);
		btn_adminChangeUserRole.setEnabled(false);
		panelAdmin.add(btn_adminChangeUserRole);
		
		add(panelAdmin);
		
		
		
		try
		{
			String query = "select * from tbl_tutorial";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			int  cnt=0;
			while(rs.next())
			{
				
				combo_adminTutorialList.addItem(rs.getString("Title"));
				
				cnt = cnt+1;
			}
			
			rs.close();
			pst.close();
			
		}
		catch (Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
			
		}		

		try
		{
			String query = "select * from tbl_request_tutorial";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			int  cnt=0;
			while(rs.next())
			{
				
				combo_adminRequestTutorialList.addItem(rs.getString("Title"));
				
				cnt = cnt+1;
			}
			
			rs.close();
			pst.close();
			
		}
		catch (Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
			
		}		

		try
		{
			String query = "select * from tbl_request_problem";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			int  cnt=0;
			while(rs.next())
			{
				
				combo_adminRequestProblemList.addItem(rs.getString("Title"));
				
				cnt = cnt+1;
			}
			
			rs.close();
			pst.close();
			
		}
		catch (Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
			
		}		

		
		try
		{
			String query = "select * from tbl_problem";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			int  cnt=0;
			while(rs.next())
			{
				
				combo_adminProblemList.addItem(rs.getString("Title"));
				
				cnt = cnt+1;
			}
			
			rs.close();
			pst.close();
			
		}
		catch (Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
			
		}		

		
		try
		{
			String query = "select * from tbl_sys";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			int  cnt=0;
			while(rs.next())
			{
				
				combo_adminUserList.addItem(rs.getString("Username"));
				
				cnt = cnt+1;
			}
			
			rs.close();
			pst.close();
			
		}
		catch (Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
			
		}	
		
		
		btn_adminSelectUserList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_sys where Username=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminUserList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					btn_adminChangeUserRole.setEnabled(true);
					int  cnt=0;
					while(rs.next())
					{
						adminShowUserInfo.setText(
								"User Information:\n\n" +
								rs.getString("Name") + " (" + rs.getString("Username") + ")\n" + "\n" +
								rs.getString("Uni_name")+ "\n\n" +
								rs.getString("Email")+ "\n\n" +
								"Role: " + rs.getString("Role") + "\n"
								
						);
						cnt = cnt+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}	
			}
		});
		
		btn_adminChangeUserRole.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_sys where Username=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminUserList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					
					btn_adminChangeUserRole.setEnabled(false);
					int  cnt=0;
					while(rs.next())
					{
						if(rs.getString("Role").equals("Admin"))
						{
							try
							{
								String query1 = "Update tbl_sys Set Role=? where Username=?";
								PreparedStatement pst1 = conn.prepareStatement(query1);
						//		System.out.println(query1);
								pst1.setString(1, "User");
								pst1.setString(2, rs.getString("Username"));
								pst1.execute();
								pst1.close();
								
							}
							catch (Exception e2)
							{
								JOptionPane.showMessageDialog(null, e2);
								
							}
							
						}
						else
						{
							try
							{
								String query1 = "Update tbl_sys Set Role=? where Username=?";
								PreparedStatement pst1 = conn.prepareStatement(query1);
								pst1.setString(1, "Admin");
								pst1.setString(2, rs.getString("Username"));
								pst1.execute();
								pst1.close();
							}
							catch (Exception e2)
							{
								JOptionPane.showMessageDialog(null, e2);
								
							}
							
						}
						
						cnt = cnt+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}	
				
				try
				{
					String query = "select * from tbl_sys where Username=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, combo_adminUserList.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery();
					
					
					btn_adminChangeUserRole.setEnabled(false);
					int  cnt=0;
					while(rs.next())
					{
						
						adminShowUserInfo.setText(
								"User Information:\n\n" +
								rs.getString("Name") + " (" + rs.getString("Username") + ")\n" + "\n" +
								rs.getString("Uni_name")+ "\n\n" +
								rs.getString("Email")+ "\n\n" +
								"Role: " + rs.getString("Role") + "\n"
								
						);
						
						cnt = cnt+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}	
			}
		});

		/// ----------------------Second Page-----------------///
		
		/// Dashboard Panel

		JPanel panelDashboard = new JPanel();
		panelDashboard.setOpaque(false);
		panelDashboard.setVisible(false);
		panelDashboard.setBounds(0,0,1366,768);
		panelDashboard.setLayout(null);
		
		
		int y_ = 333;
		int x_ = 230;
		JButton btn_tutorial = new JButton("Tutorials");
		btn_tutorial.setBounds(y_, x_, 200, 100);
		btn_tutorial.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btn_tutorial.setBackground(new Color(255, 51, 51));
		btn_tutorial.setForeground(Color.WHITE);
		btn_tutorial.setModel(new FixedStateButtonModel());
		btn_tutorial.setBorder(null);
		btn_tutorial.setFocusable(false);
		panelDashboard.add(btn_tutorial);

		/// Problem Button
		
		y_+=250;

		JButton btn_problem = new JButton("Problems");
		btn_problem.setBounds(y_, x_, 200, 100);
		btn_problem.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btn_problem.setBackground(new Color(255, 51, 51));
		btn_problem.setForeground(Color.WHITE);
		btn_problem.setModel(new FixedStateButtonModel());
		btn_problem.setBorder(null);
		btn_problem.setFocusable(false);
		panelDashboard.add(btn_problem);
		
		y_+=250;

		/// Submission Button

		JButton btn_admin = new JButton("Submission");
		btn_admin.setBounds(y_, x_, 200, 100);
		btn_admin.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btn_admin.setBackground(new Color(255, 51, 51));
		btn_admin.setForeground(Color.WHITE);
		btn_admin.setModel(new FixedStateButtonModel());
		btn_admin.setBorder(null);
		btn_admin.setFocusable(false);
		btn_admin.setEnabled(false);
		panelDashboard.add(btn_admin);

		
		y_ = 333;
		x_ = 230+150;
		
		/// Profile Button

		JButton btn_profile = new JButton("Profile");
		btn_profile.setBounds(y_, x_, 200, 100);
		btn_profile.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btn_profile.setBackground(new Color(255, 51, 51));
		btn_profile.setForeground(Color.WHITE);
		btn_profile.setModel(new FixedStateButtonModel());
		btn_profile.setBorder(null);
		btn_profile.setFocusable(false);
		panelDashboard.add(btn_profile);

		/// Progress Button
		
		y_+=250;

		JButton btn_progress = new JButton("Progress");
		btn_progress.setBounds(y_, x_, 200, 100);
		btn_progress.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btn_progress.setBackground(new Color(255, 51, 51));
		btn_progress.setForeground(Color.WHITE);
		btn_progress.setModel(new FixedStateButtonModel());
		btn_progress.setBorder(null);
		btn_progress.setFocusable(false);
		btn_progress.setEnabled(false);
		panelDashboard.add(btn_progress);
		
		/// Logout Button

		y_+=250;
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.setBounds(y_, x_, 200, 100);
		btn_logout.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btn_logout.setBackground(new Color(255, 51, 51));
		btn_logout.setForeground(Color.WHITE);
		btn_logout.setModel(new FixedStateButtonModel());
		btn_logout.setBorder(null);
		btn_logout.setFocusable(false);
		panelDashboard.add(btn_logout);
		
		
		add(panelDashboard);
		
		
		/// Problem Panel
		
		panelProblem.setOpaque(false);
		panelProblem.setVisible(false);
		panelProblem.setBounds(0,0,1366,768);
		panelProblem.setLayout(null);
		
		
	    y = 40;
		x = 160;
		wd = 200;
	    ht = 30;
		
		JLabel setSelectProblem = new JLabel("Select Problem");
		setSelectProblem.setBounds(y, x, wd, ht);
		setSelectProblem.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setSelectProblem.setForeground(new Color(255, 51, 51));
		panelProblem.add(setSelectProblem);
		
		JComboBox<String> comboProblem = new JComboBox<String>();
		
		x += 40;
		
		comboProblem.setBounds(y, x, wd, ht);
		comboProblem.setVisible(true);
		comboProblem.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		comboProblem.setBackground(Color.WHITE);
		comboProblem.setForeground(new Color(51, 54, 102));
		comboProblem.setBorder(null);
		comboProblem.setFocusable(false);
		panelProblem.add(comboProblem);
		
		x += 45;
		
		JButton btn_selectProblem = new JButton("Select");
		btn_selectProblem.setBounds(y, x, wd, ht+5);
		btn_selectProblem.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_selectProblem.setBackground(new Color(255, 51, 51));
		btn_selectProblem.setForeground(Color.WHITE);
		btn_selectProblem.setModel(new FixedStateButtonModel());
		btn_selectProblem.setBorder(null);
		btn_selectProblem.setFocusable(false);
		
		
		panelProblem.add(btn_selectProblem);
		
		x += 80;
		
		JLabel setSearchProblem = new JLabel("Search Problem");
		setSearchProblem.setBounds(y, x, wd, ht);
		setSearchProblem.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setSearchProblem.setForeground(new Color(255, 51, 51));
		panelProblem.add(setSearchProblem);
		
		
		x += 40;
		
		JTextField getSearchProblem = new JTextField();
		getSearchProblem.setBounds(y, x, wd, ht);
		getSearchProblem.setBorder(new RoundedBorder(4));
		getSearchProblem.setForeground(new Color(51, 54, 102));
		getSearchProblem.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		
		
		panelProblem.add(getSearchProblem);
		
		x += 45;
		
		JButton btn_searchProblem = new JButton("Serach");
		btn_searchProblem.setBounds(y, x, wd, ht+5);
		btn_searchProblem.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_searchProblem.setBackground(new Color(255, 51, 51));
		btn_searchProblem.setForeground(Color.WHITE);
		btn_searchProblem.setModel(new FixedStateButtonModel());
		btn_searchProblem.setBorder(null);
		btn_searchProblem.setFocusable(false);
		
		
		panelProblem.add(btn_searchProblem);
		
		
		x += 80;
		
		JLabel setRequestProblem = new JLabel("New Problem");
		setRequestProblem.setBounds(y, x, wd, ht);
		setRequestProblem.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setRequestProblem.setForeground(new Color(255, 51, 51));
		panelProblem.add(setRequestProblem);
		
		
		x += 40;
		
		JTextField getRequestProblem = new JTextField();
		getRequestProblem.setBounds(y, x, wd, ht);
		getRequestProblem.setBorder(new RoundedBorder(4));
		getRequestProblem.setForeground(new Color(51, 54, 102));
		getRequestProblem.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		
		
		panelProblem.add(getRequestProblem);
		
		x += 45;
		
		JButton btn_requestProblem = new JButton("Request");
		btn_requestProblem.setBounds(y, x, wd, ht+5);
		btn_requestProblem.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_requestProblem.setBackground(new Color(255, 51, 51));
		btn_requestProblem.setForeground(Color.WHITE);
		btn_requestProblem.setModel(new FixedStateButtonModel());
		btn_requestProblem.setBorder(null);
		btn_requestProblem.setFocusable(false);
		
		
		panelProblem.add(btn_requestProblem);
		
		y = 273+820+33;
		x = 160;
		
		
		JLabel setRecenttProblem = new JLabel("Recently Added");
		setRecenttProblem.setBounds(y, x, wd, ht);
		setRecenttProblem.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setRecenttProblem.setForeground(new Color(255, 51, 51));
		panelProblem.add(setRecenttProblem);
		
		
		
		JTextArea note_problem = new JTextArea();
		
		JLabel setTitle_problem = new JLabel("");
		setTitle_problem.setBounds(273, 115, 820, 30);
		setTitle_problem.setFont(new Font("Ubuntu", Font.BOLD, 25));
		setTitle_problem.setForeground(new Color(51, 54, 102));
		setTitle_problem.setHorizontalAlignment(SwingConstants.CENTER);
		setTitle_problem.setVerticalAlignment(SwingConstants.CENTER);
		
		note_problem.setOpaque(false);
		
		note_problem.setMargin(new Insets(30, 30, 30, 30));
		note_problem.setEditable(false);
		note_problem.setFont(new Font("Courier New", Font.PLAIN, 16));
		note_problem.setLineWrap(true);
		note_problem.setWrapStyleWord(true);
		
		JScrollPane sp_problem = new JScrollPane(note_problem);
		
		sp_problem.setBounds(273, 160, 820, 450);
		sp_problem.setOpaque(false);
		sp_problem.setBorder(null);
		
	//	add(note);
		
		
		panelProblem.add(setTitle_problem);
		

		btn_selectProblem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_problem where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, comboProblem.getSelectedItem().toString());
					
					ResultSet rs = pst.executeQuery();
					
					int cnt=0;
					
					while(rs.next())
					{
						setTitle_problem.setText(rs.getString("Title"));
						note_problem.setText(rs.getString("Body"));
						note_problem.setCaretPosition(0);
						cnt = cnt+1;
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}

			}
		});
		
		btn_searchProblem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_problem where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, getSearchProblem.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int cnt=0;
					
					while(rs.next())
					{
						setTitle_problem.setText(rs.getString("Title"));
						note_problem.setText(rs.getString("Body"));
						note_problem.setCaretPosition(0);
						cnt = cnt+1;
					}
					if(cnt == 1)
					{
						JOptionPane.showMessageDialog(null, "Problem found!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Problem not found!\nDon't worry!\nYou can request for new Problem.");
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}

			}
		});
			
		btn_requestProblem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "insert into tbl_request_problem(Title, Author) Values(?, ?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, getRequestProblem.getText());
					pst.setString(2, nameUser.getText());
					
					pst.execute();
					pst.close();
					
					JOptionPane.showMessageDialog(null, "Request Sent");
					getRequestProblem.setText("");
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}

				combo_adminRequestProblemList.removeAllItems();
				
				try
				{
					String query = "select * from tbl_request_problem";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next())
					{
						combo_adminRequestProblemList.addItem(rs.getString("Title"));
					}
					
					pst.close();
					
					getRequestProblem.setText("");
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		
		
		
		add(sp_problem);

		panelProblem.setVisible(false);
		add(panelProblem);

		
		
		
		

		///*************Tutorial Page

		/// Data Type

		
		//********First Page Design
		
		
		login_button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_sys where Username=? and Password=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, user_name_form.getText());
					pst.setString(2, password_form.getText());
					
					nameUser.setText(user_name_form.getText());
					ResultSet rs = pst.executeQuery();
					
					int cnt=0;
					
					while(rs.next())
					{
						container.setText(rs.getString("Name"));
						if(rs.getString("Role").equals("Admin"))
						{
							btn_admin.setEnabled(true);
							btn_admin.setText("Admin Panel");
							isAdmin = 1;
						}
						else
						{
							btn_admin.setEnabled(false);
							btn_admin.setText("Submission");
						}
						cnt = cnt+1;
					}
					if(cnt == 1)
					{
						container.remove(menuSignup); container.remove(menuAbout);
						container.remove(menuLogin);
						container.remove(menuExit);
						
						container.add(menuDashboard);
						container.add(menuProfile);
						container.add(menuLogout); container.add(menuAbout);
						panelLogin.setVisible(false);
						
					//	JOptionPane.showMessageDialog(null, "Login Sucess! ");
						panelDashboard.setVisible(true);
						containerText.setText("Dashboard");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Username of Password!");
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}

		});


		
		
		
		///***** panelSignup
		
		JPanel panelSignup = new JPanel();
		
		
		add(panelSignup);
		panelSignup.setOpaque(false);
		panelSignup.setVisible(false);
		panelSignup.setBounds(0,0,1366,768);
		panelSignup.setLayout(null);
		
		Y = 513;
		X = 203;
		
		
		JLabel getName_lbl = new JLabel("Name");
		getName_lbl.setBounds(Y, X+7, 120, 30);
		getName_lbl.setForeground(new Color(51, 54, 102));
		getName_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelSignup.add(getName_lbl);
		
		JTextField getName = new JTextField();
		getName.setBounds(Y+140, X, 210, 40);
		getName.setBorder(new RoundedBorder(4));
		getName.setForeground(new Color(51, 54, 102));
		getName.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		
		panelSignup.add(getName);
		
		X += 55;
		
		JLabel getUniName_lbl = new JLabel("University Name");
		getUniName_lbl.setBounds(Y, X+7, 120, 30);
		getUniName_lbl.setForeground(new Color(51, 54, 102));
		getUniName_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelSignup.add(getUniName_lbl);
		
		JTextField getUniName = new JTextField();
		getUniName.setBounds(Y+140, X, 210, 40);
		getUniName.setBorder(new RoundedBorder(4));
		getUniName.setForeground(new Color(51, 54, 102));
		getUniName.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelSignup.add(getUniName);
		
		X += 55;
		
		JLabel getEmail_lbl = new JLabel("Email");
		getEmail_lbl.setBounds(Y, X+7, 120, 30);
		getEmail_lbl.setForeground(new Color(51, 54, 102));
		getEmail_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelSignup.add(getEmail_lbl);
		
		
		JTextField getEmail = new JTextField();
		getEmail.setBounds(Y+140, X, 210, 40);
		getEmail.setBorder(new RoundedBorder(4));
		getEmail.setForeground(new Color(51, 54, 102));
		getEmail.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelSignup.add(getEmail);
		
		X += 55;
		
		JLabel getUserame_lbl = new JLabel("Username");
		getUserame_lbl.setBounds(Y, X+7, 120, 30);
		getUserame_lbl.setForeground(new Color(51, 54, 102));
		getUserame_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelSignup.add(getUserame_lbl);
		
		JTextField getUsername = new JTextField();
		getUsername.setBounds(Y+140, X, 210, 40);
		getUsername.setBorder(new RoundedBorder(4));
		getUsername.setForeground(new Color(51, 54, 102));
		getUsername.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelSignup.add(getUsername);

		X += 55;
		
		JLabel getPassword_lbl = new JLabel("Password");
		getPassword_lbl.setBounds(Y, X+7, 120, 30);
		getPassword_lbl.setForeground(new Color(51, 54, 102));
		getPassword_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelSignup.add(getPassword_lbl);
		
		JPasswordField getPassword = new JPasswordField();
		getPassword.setBounds(Y+140, X, 210, 40);
		getPassword.setBorder(new RoundedBorder(4));
		getPassword.setForeground(new Color(51, 54, 102));
		getPassword.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelSignup.add(getPassword);

		X += 65;
		
		JButton btn_signup_back = new JButton("Back");
		btn_signup_back.setFocusPainted(false);
		btn_signup_back.setBounds(Y, X, 170, 45);
		btn_signup_back.setBorder(null);
		btn_signup_back.setFont(new Font("Ubuntu", Font.BOLD, 18));
		btn_signup_back.setBackground(new Color(51, 54, 102));
		btn_signup_back.setForeground(Color.WHITE);
		btn_signup_back.setModel(new FixedStateButtonModel());
		panelSignup.add(btn_signup_back);
		
	//	ic = new ImageIcon("images/signup_form_ic.png");
		JButton btn_submit = new JButton("Submit");
		btn_submit.setFocusPainted(false);
		btn_submit.setBounds(Y+180, X, 170, 45);
		btn_submit.setBorder(null);
		btn_submit.setFont(new Font("Ubuntu", Font.BOLD, 18));
		btn_submit.setBackground(new Color(51, 54, 102));
		btn_submit.setForeground(Color.WHITE);
		btn_submit.setModel(new FixedStateButtonModel());
		panelSignup.add(btn_submit);
		
		

		
		btn_signup.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				panelLogin.setVisible(false);
				panelSignup.setVisible(true);
				containerText.setText("Sign Up");
			}
		});
		
		
		btn_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_sys where Username=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, getUsername.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int cnt=0;
					
					while(rs.next())
					{
						cnt = cnt+1;
					}
					if(cnt == 1)
					{
						JOptionPane.showMessageDialog(null, "Username already exits. Try with another.");
						
					}
					else if(getName.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null, "Name is required!.");
					}
					else if(getUniName.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null, "University Name is required!.");
					}
					else if(getEmail.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null, "Email is required!.");
					}
					else if(getUsername.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null, "Username is required!.");
					}
					else if(getPassword.getText().length()<6)
					{
						JOptionPane.showMessageDialog(null, "Password length should be at lease 6.");
					}
					else
					{
						try
						{
							String qry = "insert into tbl_sys(Name, Uni_name, Email, Username, Password, Role) values(?, ?, ?, ?, ?, ?)";
							PreparedStatement pst1 = conn.prepareStatement(qry);
							pst1.setString(1, getName.getText());
							pst1.setString(2, getUniName.getText());
							pst1.setString(3, getEmail.getText());
							pst1.setString(4, getUsername.getText());
							pst1.setString(5, getPassword.getText());
							pst1.setString(6, "User");
							
							
							getName.setText("");
							getUniName.setText("");
							getEmail.setText("");
							getUsername.setText("");
							getPassword.setText("");
							
							pst1.execute();
							pst1.close();
							JOptionPane.showMessageDialog(null, "Signup Successful! Now you can login!");
							panelSignup.setVisible(false);
							panelLogin.setVisible(true);
							containerText.setText("Log In");
						
						} catch (Exception e2)
						{
							e2.printStackTrace();
						}
						
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}

				
			}
		});
		
		
				
		btn_signup_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelSignup.setVisible(false);
				panelLogin.setVisible(true);
				containerText.setText("Log In");
			}
		});
		
		
		
		
		
		

		//TUTORIAL PANEL
		
		
		

		panelTutorial.setOpaque(false);
		panelTutorial.setVisible(false);
		panelTutorial.setBounds(0,0,1366,768);
		panelTutorial.setLayout(null);
		
		
	    y = 40;
		x = 160;
		wd = 200;
	    ht = 30;
		
		JLabel setSelectTutorial = new JLabel("Select Tutorial");
		setSelectTutorial.setBounds(y, x, wd, ht);
		setSelectTutorial.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setSelectTutorial.setForeground(new Color(255, 51, 51));
		panelTutorial.add(setSelectTutorial);
		
		JComboBox<String> comboTutorial = new JComboBox<String>();
		
		x += 40;
		
		comboTutorial.setBounds(y, x, wd, ht);
		comboTutorial.setVisible(true);
		comboTutorial.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		comboTutorial.setBackground(Color.WHITE);
		comboTutorial.setForeground(new Color(51, 54, 102));
		comboTutorial.setBorder(null);
		comboTutorial.setFocusable(false);
		panelTutorial.add(comboTutorial);
		
		x += 45;
		
		JButton btn_selectTutorial = new JButton("Select");
		btn_selectTutorial.setBounds(y, x, wd, ht+5);
		btn_selectTutorial.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_selectTutorial.setBackground(new Color(255, 51, 51));
		btn_selectTutorial.setForeground(Color.WHITE);
		btn_selectTutorial.setModel(new FixedStateButtonModel());
		btn_selectTutorial.setBorder(null);
		btn_selectTutorial.setFocusable(false);
		
		
		panelTutorial.add(btn_selectTutorial);
		
		x += 80;
		
		JLabel setSearchTutorial = new JLabel("Search Tutorial");
		setSearchTutorial.setBounds(y, x, wd, ht);
		setSearchTutorial.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setSearchTutorial.setForeground(new Color(255, 51, 51));
		panelTutorial.add(setSearchTutorial);
		
		
		x += 40;
		
		JTextField getSearchTutorial = new JTextField();
		getSearchTutorial.setBounds(y, x, wd, ht);
		getSearchTutorial.setBorder(new RoundedBorder(4));
		getSearchTutorial.setForeground(new Color(51, 54, 102));
		getSearchTutorial.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		
		
		panelTutorial.add(getSearchTutorial);
		
		x += 45;
		
		JButton btn_searchTutorial = new JButton("Serach");
		btn_searchTutorial.setBounds(y, x, wd, ht+5);
		btn_searchTutorial.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_searchTutorial.setBackground(new Color(255, 51, 51));
		btn_searchTutorial.setForeground(Color.WHITE);
		btn_searchTutorial.setModel(new FixedStateButtonModel());
		btn_searchTutorial.setBorder(null);
		btn_searchTutorial.setFocusable(false);
		
		
		panelTutorial.add(btn_searchTutorial);
		
		
		x += 80;
		
		JLabel setRequestTutorial = new JLabel("New Tutorial");
		setRequestTutorial.setBounds(y, x, wd, ht);
		setRequestTutorial.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setRequestTutorial.setForeground(new Color(255, 51, 51));
		panelTutorial.add(setRequestTutorial);
		
		
		x += 40;
		
		JTextField getRequestTutorial = new JTextField();
		getRequestTutorial.setBounds(y, x, wd, ht);
		getRequestTutorial.setBorder(new RoundedBorder(4));
		getRequestTutorial.setForeground(new Color(51, 54, 102));
		getRequestTutorial.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		
		
		panelTutorial.add(getRequestTutorial);
		
		x += 45;
		
		JButton btn_requestTutorial = new JButton("Request");
		btn_requestTutorial.setBounds(y, x, wd, ht+5);
		btn_requestTutorial.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_requestTutorial.setBackground(new Color(255, 51, 51));
		btn_requestTutorial.setForeground(Color.WHITE);
		btn_requestTutorial.setModel(new FixedStateButtonModel());
		btn_requestTutorial.setBorder(null);
		btn_requestTutorial.setFocusable(false);
		
		
		panelTutorial.add(btn_requestTutorial);
		
		y = 273+820+33;
		x = 160;
		
		
		JLabel setRecenttTutorial = new JLabel("Recently Added");
		setRecenttTutorial.setBounds(y, x, wd, ht);
		setRecenttTutorial.setFont(new Font("Ubuntu", Font.BOLD, 20));
		setRecenttTutorial.setForeground(new Color(255, 51, 51));
		panelTutorial.add(setRecenttTutorial);
		
		
		
		JLabel setTitle_tutorial = new JLabel();
		setTitle_tutorial.setBounds(273, 115, 820, 30);
		setTitle_tutorial.setFont(new Font("Ubuntu", Font.BOLD, 25));
		setTitle_tutorial.setForeground(new Color(51, 54, 102));
		setTitle_tutorial.setHorizontalAlignment(SwingConstants.CENTER);
		setTitle_tutorial.setVerticalAlignment(SwingConstants.CENTER);
		panelTutorial.add(setTitle_tutorial);
		
		JTextArea note_tutorial = new JTextArea();
		note_tutorial.setOpaque(false);
		note_tutorial.setMargin(new Insets(30, 30, 30, 30));
		note_tutorial.setEditable(false);
		note_tutorial.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		note_tutorial.setLineWrap(true);
		note_tutorial.setWrapStyleWord(true);
		
		JScrollPane sp_tutorial = new JScrollPane(note_tutorial);
		sp_tutorial.setBounds(273, 160, 820, 450);
		sp_tutorial.setOpaque(false);
		sp_tutorial.setBorder(null);
		//sp_tutorial.setMar
		
		
		
		
		
		btn_selectTutorial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_tutorial where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, comboTutorial.getSelectedItem().toString());
					
					ResultSet rs = pst.executeQuery();
					
					int cnt=0;
					
					while(rs.next())
					{
						setTitle_tutorial.setText(rs.getString("Title"));
						note_tutorial.setText(rs.getString("Body"));
						note_tutorial.setCaretPosition(0);
						cnt = cnt+1;
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}

			}
		});
		
		btn_searchTutorial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "select * from tbl_tutorial where Title=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, getSearchTutorial.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int cnt=0;
					
					while(rs.next())
					{
						setTitle_tutorial.setText(rs.getString("Title"));
						note_tutorial.setText(rs.getString("Body"));
						note_tutorial.setCaretPosition(0);
						cnt = cnt+1;
					}
					if(cnt == 1)
					{
						JOptionPane.showMessageDialog(null, "Tutorial found!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Tutorial not found!\nDon't worry!\nYou can request for new tutorial.");
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}

			}
		});
		
		btn_requestTutorial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					String query = "insert into tbl_request_tutorial(Title, Author) Values(?, ?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, getRequestTutorial.getText());
					pst.setString(2, nameUser.getText());
					
					pst.execute();
					pst.close();
					
					JOptionPane.showMessageDialog(null, "Request Sent");
					getRequestTutorial.setText("");
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}

				combo_adminRequestTutorialList.removeAllItems();
				
				try
				{
					String query = "select * from tbl_request_tutorial";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next())
					{
						combo_adminRequestTutorialList.addItem(rs.getString("Title"));
					}
					
					pst.close();
					
					getRequestTutorial.setText("");
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}

			}
		});
		


		add(sp_tutorial);

		panelTutorial.setVisible(false);
		add(panelTutorial);

		


		
		
		note_tutorial.setVisible(false); note_problem.setVisible(false);
		sp_tutorial.setVisible(false); sp_problem.setVisible(false);
		
		
		
		/// Profile Panel
		
		
		JPanel panelProfile = new JPanel();
		
		
		add(panelProfile);
		panelProfile.setOpaque(false);
		panelProfile.setVisible(false);
		panelProfile.setBounds(0,0,1366,768);
		panelProfile.setLayout(null);
		
		Y = 513;
		X = 203;
		

		JLabel showProfileRole = new JLabel();
		
		JLabel showProfileTitle = new JLabel();
		showProfileTitle.setBounds(Y, X-60, 350, 40);
		showProfileTitle.setForeground(new Color(51, 54, 102));
		showProfileTitle.setFont(new Font("Ubuntu", Font.BOLD, 22));
		showProfileTitle.setHorizontalAlignment(SwingConstants.CENTER);
		showProfileTitle.setVerticalAlignment(SwingConstants.CENTER);
		
		panelProfile.add(showProfileTitle);
		
		
		JLabel showName_lbl = new JLabel("Name");
		showName_lbl.setBounds(Y, X+7, 120, 30);
		showName_lbl.setForeground(new Color(51, 54, 102));
		showName_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelProfile.add(showName_lbl);
		
		JTextField showName = new JTextField();
		showName.setBounds(Y+140, X, 210, 40);
		showName.setBorder(new RoundedBorder(4));
		showName.setForeground(new Color(51, 54, 102));
		showName.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		
		panelProfile.add(showName);
		
		X += 55;
		
		JLabel showUniName_lbl = new JLabel("University Name");
		showUniName_lbl.setBounds(Y, X+7, 120, 30);
		showUniName_lbl.setForeground(new Color(51, 54, 102));
		showUniName_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelProfile.add(showUniName_lbl);
		
		JTextField showUniName = new JTextField();
		showUniName.setBounds(Y+140, X, 210, 40);
		showUniName.setBorder(new RoundedBorder(4));
		showUniName.setForeground(new Color(51, 54, 102));
		showUniName.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelProfile.add(showUniName);
		
		X += 55;
		
		JLabel showEmail_lbl = new JLabel("Email");
		showEmail_lbl.setBounds(Y, X+7, 120, 30);
		showEmail_lbl.setForeground(new Color(51, 54, 102));
		showEmail_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelProfile.add(showEmail_lbl);
		
		
		JTextField showEmail = new JTextField();
		showEmail.setBounds(Y+140, X, 210, 40);
		showEmail.setBorder(new RoundedBorder(4));
		showEmail.setForeground(new Color(51, 54, 102));
		showEmail.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelProfile.add(showEmail);
		
		X += 55;
		
		JLabel showUserame_lbl = new JLabel("Username");
		showUserame_lbl.setBounds(Y, X+7, 120, 30);
		showUserame_lbl.setForeground(new Color(51, 54, 102));
		showUserame_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelProfile.add(showUserame_lbl);
		
		JTextField showUsername = new JTextField();
		showUsername.setBounds(Y+140, X, 210, 40);
		showUsername.setBorder(new RoundedBorder(4));
		showUsername.setForeground(new Color(51, 54, 102));
		showUsername.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelProfile.add(showUsername);

		X += 55;
		
		JLabel showPassword_lbl = new JLabel("Password");
		showPassword_lbl.setBounds(Y, X+7, 120, 30);
		showPassword_lbl.setForeground(new Color(51, 54, 102));
		showPassword_lbl.setFont(new Font("Ubuntu", Font.BOLD, 14));
		panelProfile.add(showPassword_lbl);
		
		JPasswordField showPassword = new JPasswordField();
		showPassword.setBounds(Y+140, X, 210, 40);
		showPassword.setBorder(new RoundedBorder(4));
		showPassword.setForeground(new Color(51, 54, 102));
		showPassword.setFont(new Font("Ubuntu", Font.PLAIN, 14));

		panelProfile.add(showPassword);

		X += 65;
		
		JButton btn_editProfile = new JButton("Edit");
		btn_editProfile.setFocusPainted(false);
		btn_editProfile.setBounds(Y, X, 170, 45);
		btn_editProfile.setBorder(null);
		btn_editProfile.setFont(new Font("Ubuntu", Font.BOLD, 18));
		btn_editProfile.setBackground(new Color(51, 54, 102));
		btn_editProfile.setForeground(Color.WHITE);
		btn_editProfile.setModel(new FixedStateButtonModel());
		panelProfile.add(btn_editProfile);
		
	//	ic = new ImageIcon("images/signup_form_ic.png");
		JButton btn_updateProfile = new JButton("Update");
		btn_updateProfile.setFocusPainted(false);
		btn_updateProfile.setBounds(Y+180, X, 170, 45);
		btn_updateProfile.setBorder(null);
		btn_updateProfile.setFont(new Font("Ubuntu", Font.BOLD, 18));
		btn_updateProfile.setBackground(new Color(51, 54, 102));
		btn_updateProfile.setForeground(Color.WHITE);
		btn_updateProfile.setModel(new FixedStateButtonModel());

		btn_updateProfile.setEnabled(false);
		
		panelProfile.add(btn_updateProfile);
		
		
		
		panelProfile.setVisible(false);
		
		
		
		
		btn_profile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelDashboard.setVisible(false);
				panelProfile.setVisible(true);
				try
				{
					String query = "select * from tbl_sys where Username=?";
					PreparedStatement pst = conn.prepareStatement(query);

					System.out.println(nameUser.getText());
					pst.setString(1, nameUser.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int tr = 1;
					
					while(rs.next())
					{
						showName.setText(rs.getString("Name"));
						showName.setEditable(false);
						
						showUniName.setText(rs.getString("Uni_name"));
						showUniName.setEditable(false);
						
						showEmail.setText(rs.getString("Email"));
						showEmail.setEditable(false);
						
						showUsername.setText(rs.getString("Username"));
						showUsername.setEditable(false);
						
						showPassword.setText(rs.getString("Password"));
						showPassword.setEditable(false);
						

						containerText.setText("Profile");
						showProfileRole.setText(rs.getString("Role"));
						showProfileTitle.setText(showProfileRole.getText() +": "+showName.getText());
						
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		
		btn_editProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn_editProfile.setEnabled(false);
				btn_updateProfile.setEnabled(true);
				
				
				showName.setEditable(true);
				showUniName.setEditable(true);
				showPassword.setEditable(true);
				showEmail.setEditable(true);
				showPassword.setText("");

				containerText.setText("Edit Profile");
				
			}
		});
		
		
		
		btn_updateProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn_editProfile.setEnabled(true);
				btn_updateProfile.setEnabled(false);
				
				if(showName.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Name is required!.");
				}
				else if(showUniName.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "University Name is required!.");
				}
				else if(showEmail.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Email is required!.");
				}
				else if(showPassword.getText().length()<6)
				{
					JOptionPane.showMessageDialog(null, "Password length should be at lease 6.");
				}
				else
				{
					try
					{
						String qry = "Update tbl_sys Set Name = ?, Uni_name = ?, Email = ?, Password = ? where Username=?";
			//			System.out.println(qry);
						PreparedStatement pst1 = conn.prepareStatement(qry);
						pst1.setString(1, showName.getText());
						pst1.setString(2, showUniName.getText());
						pst1.setString(3, showEmail.getText());
						pst1.setString(4, showPassword.getText());
						pst1.setString(5, nameUser.getText());
						pst1.execute();
						pst1.close();
						
						
						showName.setEditable(false);
						showUniName.setEditable(false);
						showEmail.setEditable(false);
						showUsername.setEditable(false);
						showPassword.setEditable(false);
						

						containerText.setText("Profile");
						
						JOptionPane.showMessageDialog(null, "Information Updated!");;
					
					} catch (Exception e2)
					{
						e2.printStackTrace();
					}
					
				}
			}
		});
		
		//sp_tutorial.setLayout(new BorderLayout());
		
		///TUTORIAL AND PROBLEM ADD/UPDATE/DELETE
		
		
		///
		
		btn_admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panelDashboard.setVisible(false);
				panelAdmin.setVisible(true);
				containerText.setText("Admin Panel");
				
				if(combo_adminTutorialList.getItemCount() == 0)
				{
					btn_adminSelectTutorialList.setEnabled(false);
				}
				else
				{
					btn_adminSelectTutorialList.setEnabled(true);
				}
				
				if(combo_adminRequestTutorialList.getItemCount() == 0)
				{
					btn_adminSelectRequestTutorialList.setEnabled(false);
				}
				else
				{
					btn_adminSelectRequestTutorialList.setEnabled(true);
				}
				
				if(combo_adminProblemList.getItemCount() == 0)
				{
					btn_adminSelectTutorialList.setEnabled(false);
				}
				else
				{
					btn_adminSelectProblemList.setEnabled(true);
				}
				
				if(combo_adminRequestProblemList.getItemCount() == 0)
				{
					btn_adminSelectRequestProblemList.setEnabled(false);
				}
				else
				{
					btn_adminSelectRequestProblemList.setEnabled(true);
				}
				
				if(combo_adminUserList.getItemCount() == 0)
				{
					btn_adminSelectUserList.setEnabled(false);
				}
				else
				{
					btn_adminSelectUserList.setEnabled(true);
				}
			}
		});
		
		JLabel showTutorial[] = new JLabel[15];

		x+=40;
		
		for(int i=0; i<10; i++)
		{
			showTutorial[i] = new JLabel();
			showTutorial[i].setBounds(y, x, wd, ht);
			showTutorial[i].setFont(new Font("Ubuntu", Font.BOLD, 15));
			showTutorial[i].setForeground(new Color(51, 54, 102));
			showTutorial[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panelTutorial.add(showTutorial[i]);
			x+=40;
		}
		
		btn_tutorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(false);
				panelAdmin.setVisible(false);
				panelProblem.setVisible(false);
				panelTutorial.setVisible(true);
				panelProfile.setVisible(false);
				note_tutorial.setVisible(true);
				sp_tutorial.setVisible(true);
				setTitle_tutorial.setVisible(true);
				
				containerText.setText("Tutorials");
				comboTutorial.removeAllItems();
				

				int ct=0;
				try
				{
					String query = "select * from tbl_tutorial";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					
				    ct=0;
					while(rs.next())
					{
						
						comboTutorial.addItem(rs.getString("Title"));
						if(rs.getString("Title").equals("Hello World"))
						{
							setTitle_tutorial.setText(rs.getString("Title"));
							note_tutorial.setText(rs.getString("Body"));
							note_tutorial.setCaretPosition(0);
						}
						ct = ct+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}		
				

				int idx = ct-10;
				
				JLabel lbl_recentTutorial[] = new JLabel[15];
				JLabel lbl_recentTutorialName[] = new JLabel[15];
				
				int cur = 0;
				
				while(idx<0)
				{
					idx++;
				}
				
				int y = 273+820+33;
				int x = 200;
				int wd = 200;
				int ht = 30;
				
				try
				{
					String query = "select * from tbl_tutorial";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					
					int cnt=0;
					while(rs.next())
					{
						if(cnt>=idx)
						{
							lbl_recentTutorialName[cur] = new JLabel();
							
							
							showTutorial[cur].setText("• "+rs.getString("Title"));
							lbl_recentTutorialName[cur].setText(rs.getString("Title"));

							
							
							cur++;
						}
						
						cnt = cnt+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}	
				
				
				int j=cur-1;
				
				for(int i=0; i<j;i++)
				{
					String s1 = showTutorial[i].getText();
					String s2 = showTutorial[j].getText();
					

					showTutorial[i].setText(s2);
					showTutorial[j].setText(s1);
					
					s1 = lbl_recentTutorialName[i].getText();
					s2 = lbl_recentTutorialName[j].getText();
					
					lbl_recentTutorialName[i].setText(s2);
					lbl_recentTutorialName[j].setText(s1);
					
					j--;
				}
				
				for(int i=0; i<cur;i++)
				{
					final Integer cur_idx = new Integer(i);
				//System.out.println(lbl_recentTutorialName[cur_idx].getText());
					
					showTutorial[cur_idx].addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent arg0) {
							// TODO Auto-generated method stub
							try
							{
								String query = "select * from tbl_tutorial where Title=?";
								PreparedStatement pst = conn.prepareStatement(query);
								
								pst.setString(1, lbl_recentTutorialName[cur_idx].getText());
								
								ResultSet rs = pst.executeQuery();
								
								int ct=0;
								while(rs.next())
								{
									
									setTitle_tutorial.setText(rs.getString("Title"));
									note_tutorial.setText(rs.getString("Body"));
									note_tutorial.setCaretPosition(0);
									ct = ct+1;
								}
								
								rs.close();
								pst.close();
							}
							catch (Exception e1)
							{
								JOptionPane.showMessageDialog(null, e1);
								
							}
						}
					});
					
				}
			}
		});
		
		JLabel showProblem[] = new JLabel[15];

		x=200;
		
		for(int i=0; i<10; i++)
		{
			showProblem[i] = new JLabel();
			showProblem[i].setBounds(y, x, wd, ht);
			showProblem[i].setFont(new Font("Ubuntu", Font.BOLD, 15));
			showProblem[i].setForeground(new Color(51, 54, 102));
			showProblem[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panelProblem.add(showProblem[i]);
			x+=40;
		}
		
		btn_problem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(false);
				panelAdmin.setVisible(false);
				panelProblem.setVisible(false);
				panelProblem.setVisible(true);
				panelProfile.setVisible(false);
				note_problem.setVisible(true);
				sp_problem.setVisible(true);
				setTitle_problem.setVisible(true);
				
				containerText.setText("Problems");
				comboProblem.removeAllItems();
				

				int ct=0;
				try
				{
					String query = "select * from tbl_problem";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					
				    ct=0;
					while(rs.next())
					{
						
						comboProblem.addItem(rs.getString("Title"));
						if(rs.getString("Title").equals("Print Hello World"))
						{
							setTitle_problem.setText(rs.getString("Title"));
							note_problem.setText(rs.getString("Body"));
							note_problem.setCaretPosition(0);
						}
						ct = ct+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}		
				

				int idx = ct-10;
				
				JLabel lbl_recentProblem[] = new JLabel[15];
				JLabel lbl_recentProblemName[] = new JLabel[15];
				
				int cur = 0;
				
				while(idx<0)
				{
					idx++;
				}
				
				int y = 273+820+33;
				int x = 200;
				int wd = 200;
				int ht = 30;
				
				try
				{
					String query = "select * from tbl_problem";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					
					int cnt=0;
					while(rs.next())
					{
						if(cnt>=idx)
						{
							lbl_recentProblemName[cur] = new JLabel();
							
							
							showProblem[cur].setText("• "+rs.getString("Title"));
							lbl_recentProblemName[cur].setText(rs.getString("Title"));

							
							
							cur++;
						}
						
						cnt = cnt+1;
					}
					
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				}	
				
				
				int j=cur-1;
				
				for(int i=0; i<j;i++)
				{
					String s1 = showProblem[i].getText();
					String s2 = showProblem[j].getText();
					

					showProblem[i].setText(s2);
					showProblem[j].setText(s1);
					
					s1 = lbl_recentProblemName[i].getText();
					s2 = lbl_recentProblemName[j].getText();
					
					lbl_recentProblemName[i].setText(s2);
					lbl_recentProblemName[j].setText(s1);
					
					j--;
				}
				
				for(int i=0; i<cur;i++)
				{
					final Integer cur_idx = new Integer(i);
				//System.out.println(lbl_recentProblemName[cur_idx].getText());
					
					showProblem[cur_idx].addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent arg0) {
							// TODO Auto-generated method stub
							try
							{
								String query = "select * from tbl_problem where Title=?";
								PreparedStatement pst = conn.prepareStatement(query);
								
								pst.setString(1, lbl_recentProblemName[cur_idx].getText());
								
								ResultSet rs = pst.executeQuery();
								
								int ct=0;
								while(rs.next())
								{
									
									setTitle_problem.setText(rs.getString("Title"));
									note_problem.setText(rs.getString("Body"));
									note_problem.setCaretPosition(0);
									ct = ct+1;
								}
								
								rs.close();
								pst.close();
							}
							catch (Exception e1)
							{
								JOptionPane.showMessageDialog(null, e1);
								
							}
						}
					});
					
				}
			}
		});

		btn_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelLogin.setVisible(true);
				
				container.remove(menuLogout);
				container.remove(menuProfile);
				container.remove(menuDashboard);
				
				container.add(menuLogin);
				container.add(menuSignup); container.add(menuAbout);
				container.add(menuExit);


				containerText.setText("Log In");
				container.setText("ProgSchool");
				
				panelAdmin.setVisible(false);
				panelDashboard.setVisible(false);

				user_name_form.setText("");
				password_form.setText("");
				
				
			}
		});
		
		
		
		menuLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelSignup.setVisible(false);
				panelLogin.setVisible(true);
				panelDashboard.setVisible(false);
				panelAdmin.setVisible(false);

				containerText.setText("Log In");
				
				
			}
		});
		
		
		menuSignup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				panelLogin.setVisible(false);
				panelSignup.setVisible(true);

				containerText.setText("Sign Up");
				
			}
		});
		
		
		
		menuLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				btn_editProfile.setEnabled(true);
				btn_updateProfile.setEnabled(false);
				
				container.remove(menuLogout);
				container.remove(menuDashboard);
				container.remove(menuProfile);
				
				container.add(menuLogin);
				container.add(menuSignup); container.add(menuAbout);
				container.add(menuExit);
				
				user_name_form.setText("");
				password_form.setText("");
				
				setTitle_tutorial.setVisible(true);
				note_tutorial.setVisible(false); note_problem.setVisible(false);
				sp_tutorial.setVisible(false); sp_problem.setVisible(false);
				
				container.setText("ProgSchool");
				
				containerText.setText("Log In");
				
				panelDashboard.setVisible(false);
				panelTutorial.setVisible(false);
				panelProfile.setVisible(false);
				panelProblem.setVisible(false);
				panelAdmin.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		

		menuExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		menuDashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_editProfile.setEnabled(true);
				btn_updateProfile.setEnabled(false);
				
				panelProfile.setVisible(false);
				sp_tutorial.setVisible(false); sp_problem.setVisible(false);
				setTitle_tutorial.setVisible(false);
				note_tutorial.setVisible(false); note_problem.setVisible(false);
				panelTutorial.setVisible(false);
				panelAdmin.setVisible(false);
				panelProblem.setVisible(false);
				
				containerText.setText("Dashboard");
				
				
				panelDashboard.setVisible(true);
			}
		});
		
		menuProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_editProfile.setEnabled(true);
				btn_updateProfile.setEnabled(false);
				
				panelDashboard.setVisible(false);
				panelProfile.setVisible(true);
				sp_tutorial.setVisible(false); sp_problem.setVisible(false);
				setTitle_tutorial.setVisible(false);
				note_tutorial.setVisible(false); note_problem.setVisible(false);
				panelTutorial.setVisible(false);
				panelAdmin.setVisible(false);
				panelDashboard.setVisible(false);
				panelProblem.setVisible(false);
				panelProfile.setVisible(true);
				containerText.setText("Profile");
				
				try
				{
					String query = "select * from tbl_sys where Username=?";
					PreparedStatement pst = conn.prepareStatement(query);

					System.out.println(nameUser.getText());
					pst.setString(1, nameUser.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int tr = 1;
					
					while(rs.next())
					{
						showName.setText(rs.getString("Name"));
						showName.setEditable(false);
						
						showUniName.setText(rs.getString("Uni_name"));
						showUniName.setEditable(false);
						
						showEmail.setText(rs.getString("Email"));
						showEmail.setEditable(false);
						
						showUsername.setText(rs.getString("Username"));
						showUsername.setEditable(false);
						
						showPassword.setText(rs.getString("Password"));
						showPassword.setEditable(false);
						
						showProfileRole.setText(rs.getString("Role"));
						showProfileTitle.setText(showProfileRole.getText() +": "+showName.getText());
						
					}
					rs.close();
					pst.close();
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		ic = new ImageIcon("images/logo_frame.png");
		menuAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ImageIcon ic = new ImageIcon("images/about.png");
				JOptionPane.showMessageDialog(
                        null,
                        "ProgSchool 1.0\n\nDeveloper: Emrul Chowdhury\n38 Batch, Department of CSE\nMetropolitan University, Sylhet\n\nProject Supervisor: Sharif Ahmed\nLecturer, Department of CSE\nMetropolitan University, Sylhet",
                        "About", JOptionPane.INFORMATION_MESSAGE,ic);
			}
		});
		

		ic = new ImageIcon("images/background.jpg");
		
		ImagePanel nel = new ImagePanel(ic.getImage());
		
		getContentPane().add(nel);
		try {
		    setIconImage(ImageIO.read(new File("images/logo_frame.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		setJMenuBar(jmb);
		setVisible(true);

	}
	
	
}


class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String ic) {
	    this(new ImageIcon(ic).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	}







