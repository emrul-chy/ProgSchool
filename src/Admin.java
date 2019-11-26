import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;

public class Admin {

	
	JPanel panelAdmin;
	JLabel adminTutorialList;
	JComboBox<String> combo_adminTutorialList;
	JButton btn_adminSelectTutorialList;
	JButton btn_adminAddTutorialList;
	JButton btn_adminEditTutorialList; 
	JButton btn_adminDeleteTutorialList;
	JLabel adminTutorialTitle;
	JTextField txt_adminTutorialTitle;
	JLabel adminTutorialBody;
	JTextArea txt_adminTutorialBody;
	JScrollPane srl_adminTutorialBody;
	JButton btn_adminUpdateInsertTutorialList;
	JButton btn_adminCancelTutorialList;
	
	JLabel adminProblemList;
	JComboBox<String> combo_adminProblemList;
	JButton btn_adminSelectProblemList;
	JButton btn_adminAddProblemList;
	JButton btn_adminEditProblemList; 
	JButton btn_adminDeleteProblemList;
	JLabel adminProblemTitle;
	JTextField txt_adminProblemTitle;
	JLabel adminProblemBody;
	JTextArea txt_adminProblemBody;
	JScrollPane srl_adminProblemBody;
	JButton btn_adminUpdateInsertProblemList;
	JButton btn_adminCancelProblemList;
	
	JLabel adminRequestTutorialList;
	JComboBox<String> combo_adminRequestTutorialList;
	JButton btn_adminSelectRequestTutorialList;
	JButton btn_adminAddRequestTutorialList;
	JButton btn_adminDeleteRequestTutorialList;
	JTextArea adminShowRequestTutorialList;
	

	JLabel adminRequestProblemList;
	JComboBox<String> combo_adminRequestProblemList;
	JButton btn_adminSelectRequestProblemList;
	JButton btn_adminDeleteRequestProblemList;
	JTextArea adminShowRequestProblemList;
	
	JLabel adminUser;
	JComboBox<String> combo_adminUserList;
	JButton btn_adminSelectUserList;
	JButton btn_adminChangeUserRole;
	JTextArea adminShowUserInfo;
	
	
	
	public Admin()
	{
		Connection conn = sqlConnection.dbConnection();
		panelAdmin.setOpaque(false);
		panelAdmin.setVisible(false);
		panelAdmin.setBounds(0,0,1366,768);
		panelAdmin.setLayout(null);
		
		int y = 44;
		int x = 120;
		int wd = 220;
		int ht = 30;
		
		// Tutorial List
		
		adminTutorialList = new JLabel("Tutorial List");
		adminTutorialList.setBounds(y, x, wd, ht);
		adminTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminTutorialList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminTutorialList);
		
		combo_adminTutorialList = new JComboBox<String>();
		
		
		combo_adminTutorialList.setBounds(y, x+40, wd, ht);
		combo_adminTutorialList.setVisible(true);
		combo_adminTutorialList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminTutorialList.setBackground(Color.WHITE);
		combo_adminTutorialList.setForeground(new Color(51, 54, 102));
		combo_adminTutorialList.setBorder(null);
		combo_adminTutorialList.setFocusable(false);
		panelAdmin.add(combo_adminTutorialList);
		
		btn_adminSelectTutorialList = new JButton("Select");
		btn_adminSelectTutorialList.setBounds(y, x+85, 105, 30);
		btn_adminSelectTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminSelectTutorialList.setForeground(Color.WHITE);
		btn_adminSelectTutorialList.setModel(new FixedStateButtonModel());
		btn_adminSelectTutorialList.setBorder(null);
		btn_adminSelectTutorialList.setFocusable(false);
		panelAdmin.add(btn_adminSelectTutorialList);
		
		
		btn_adminAddTutorialList = new JButton("Add New");
		btn_adminAddTutorialList.setBounds(y+115, x+85, 105, 30);
		btn_adminAddTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminAddTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminAddTutorialList.setForeground(Color.WHITE);
		btn_adminAddTutorialList.setModel(new FixedStateButtonModel());
		btn_adminAddTutorialList.setBorder(null);
		btn_adminAddTutorialList.setFocusable(false);
		panelAdmin.add(btn_adminAddTutorialList);
		
		
		
		btn_adminEditTutorialList = new JButton("Edit");
		btn_adminEditTutorialList.setBounds(y, x+125, 105, 30);
		btn_adminEditTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminEditTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminEditTutorialList.setForeground(Color.WHITE);
		btn_adminEditTutorialList.setModel(new FixedStateButtonModel());
		btn_adminEditTutorialList.setBorder(null);
		btn_adminEditTutorialList.setFocusable(false);
		btn_adminEditTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminEditTutorialList);
		
		
		
		btn_adminDeleteTutorialList = new JButton("Delete");
		btn_adminDeleteTutorialList.setBounds(y+115, x+125, 105, 30);
		btn_adminDeleteTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteTutorialList.setForeground(Color.WHITE);
		btn_adminDeleteTutorialList.setModel(new FixedStateButtonModel());
		btn_adminDeleteTutorialList.setBorder(null);
		btn_adminDeleteTutorialList.setFocusable(false);
		btn_adminDeleteTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteTutorialList);
		
		adminTutorialTitle = new JLabel("Title");
		adminTutorialTitle.setBounds(y, x+165, wd, 30);
		adminTutorialTitle.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminTutorialTitle.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminTutorialTitle);
		
		
		txt_adminTutorialTitle = new JTextField();
		txt_adminTutorialTitle.setBounds(y, x+205, wd, 30);
		txt_adminTutorialTitle.setBorder(new RoundedBorder(4));
		txt_adminTutorialTitle.setForeground(new Color(51, 54, 102));
		txt_adminTutorialTitle.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txt_adminTutorialTitle.setEditable(false);
		panelAdmin.add(txt_adminTutorialTitle);
		
		adminTutorialBody = new JLabel("Body");
		adminTutorialBody.setBounds(y, x+245, wd, 30);
		adminTutorialBody.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminTutorialBody.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminTutorialBody);
		
		
		txt_adminTutorialBody = new JTextArea();
		txt_adminTutorialBody.setBounds(y, x+285, wd, 100);
		txt_adminTutorialBody.setBorder(new RoundedBorder(4));
		txt_adminTutorialBody.setForeground(new Color(51, 54, 102));
		txt_adminTutorialBody.setFont(new Font("Ubuntu", Font.PLAIN, 15));
	//	txt_adminTutorialBody.setemrEditable(false);
	//	panelAdmin.add(txt_adminTutorialBody);
		
		srl_adminTutorialBody = new JScrollPane(txt_adminTutorialBody);
		srl_adminTutorialBody.setBounds(y, x+285, wd, 150);
	//	srl_adminTutorialBody.setBorder(new RoundedBorder(4));
		srl_adminTutorialBody.setForeground(new Color(51, 54, 102));
		srl_adminTutorialBody.setBorder(null);
		srl_adminTutorialBody.setFont(new Font("Courier New", Font.PLAIN, 15));
		txt_adminTutorialBody.setEditable(false);
		panelAdmin.add(srl_adminTutorialBody);
		
		btn_adminUpdateInsertTutorialList = new JButton("Update / Insert");
		btn_adminUpdateInsertTutorialList.setBounds(y, x+445, wd, 30);
		btn_adminUpdateInsertTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminUpdateInsertTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminUpdateInsertTutorialList.setForeground(Color.WHITE);
		btn_adminUpdateInsertTutorialList.setModel(new FixedStateButtonModel());
		btn_adminUpdateInsertTutorialList.setBorder(null);
		btn_adminUpdateInsertTutorialList.setFocusable(false);
		btn_adminUpdateInsertTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminUpdateInsertTutorialList);
		
		btn_adminCancelTutorialList = new JButton("Cancel");
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
		
		adminRequestTutorialList = new JLabel("Requested Tutorial List");
		adminRequestTutorialList.setBounds(y, x, wd, ht);
		adminRequestTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminRequestTutorialList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminRequestTutorialList);
		
		combo_adminRequestTutorialList = new JComboBox<String>();
		
		
		combo_adminRequestTutorialList.setBounds(y, x+40, wd, ht);
		combo_adminRequestTutorialList.setVisible(true);
		combo_adminRequestTutorialList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminRequestTutorialList.setBackground(Color.WHITE);
		combo_adminRequestTutorialList.setForeground(new Color(51, 54, 102));
		combo_adminRequestTutorialList.setBorder(null);
		combo_adminRequestTutorialList.setFocusable(false);
		panelAdmin.add(combo_adminRequestTutorialList);
		
		btn_adminSelectRequestTutorialList = new JButton("Select");
		btn_adminSelectRequestTutorialList.setBounds(y, x+85, 105, 30);
		btn_adminSelectRequestTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectRequestTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminSelectRequestTutorialList.setForeground(Color.WHITE);
		btn_adminSelectRequestTutorialList.setModel(new FixedStateButtonModel());
		btn_adminSelectRequestTutorialList.setBorder(null);
		btn_adminSelectRequestTutorialList.setFocusable(false);
		panelAdmin.add(btn_adminSelectRequestTutorialList);
		
		btn_adminDeleteRequestTutorialList = new JButton("Delete");
		btn_adminDeleteRequestTutorialList.setBounds(y+115, x+85, 105, 30);
		btn_adminDeleteRequestTutorialList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteRequestTutorialList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteRequestTutorialList.setForeground(Color.WHITE);
		btn_adminDeleteRequestTutorialList.setModel(new FixedStateButtonModel());
		btn_adminDeleteRequestTutorialList.setBorder(null);
		btn_adminDeleteRequestTutorialList.setFocusable(false);
		btn_adminDeleteRequestTutorialList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteRequestTutorialList);
		
		adminShowRequestTutorialList = new JTextArea("");
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
		
		adminProblemList = new JLabel("Problem List");
		adminProblemList.setBounds(y, x, wd, ht);
		adminProblemList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminProblemList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminProblemList);
		
		combo_adminProblemList = new JComboBox<String>();
		
		
		combo_adminProblemList.setBounds(y, x+40, wd, ht);
		combo_adminProblemList.setVisible(true);
		combo_adminProblemList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminProblemList.setBackground(Color.WHITE);
		combo_adminProblemList.setForeground(new Color(51, 54, 102));
		combo_adminProblemList.setBorder(null);
		combo_adminProblemList.setFocusable(false);
		panelAdmin.add(combo_adminProblemList);
		
		btn_adminSelectProblemList = new JButton("Select");
		btn_adminSelectProblemList.setBounds(y, x+85, 105, 30);
		btn_adminSelectProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectProblemList.setBackground(new Color(51, 54, 102));
		btn_adminSelectProblemList.setForeground(Color.WHITE);
		btn_adminSelectProblemList.setModel(new FixedStateButtonModel());
		btn_adminSelectProblemList.setBorder(null);
		btn_adminSelectProblemList.setFocusable(false);
		panelAdmin.add(btn_adminSelectProblemList);
		
		btn_adminAddProblemList = new JButton("Add New");
		btn_adminAddProblemList.setBounds(y+115, x+85, 105, 30);
		btn_adminAddProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminAddProblemList.setBackground(new Color(51, 54, 102));
		btn_adminAddProblemList.setForeground(Color.WHITE);
		btn_adminAddProblemList.setModel(new FixedStateButtonModel());
		btn_adminAddProblemList.setBorder(null);
		btn_adminAddProblemList.setFocusable(false);
		panelAdmin.add(btn_adminAddProblemList);
		
		
		btn_adminEditProblemList = new JButton("Edit");
		btn_adminEditProblemList.setBounds(y, x+125, 105, 30);
		btn_adminEditProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminEditProblemList.setBackground(new Color(51, 54, 102));
		btn_adminEditProblemList.setForeground(Color.WHITE);
		btn_adminEditProblemList.setModel(new FixedStateButtonModel());
		btn_adminEditProblemList.setBorder(null);
		btn_adminEditProblemList.setFocusable(false);
		btn_adminEditProblemList.setEnabled(false);
		panelAdmin.add(btn_adminEditProblemList);
		
		
		btn_adminDeleteProblemList = new JButton("Delete");
		btn_adminDeleteProblemList.setBounds(y+115, x+125, 105, 30);
		btn_adminDeleteProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteProblemList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteProblemList.setForeground(Color.WHITE);
		btn_adminDeleteProblemList.setModel(new FixedStateButtonModel());
		btn_adminDeleteProblemList.setBorder(null);
		btn_adminDeleteProblemList.setFocusable(false);
		btn_adminDeleteProblemList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteProblemList);
		
		adminProblemTitle = new JLabel("Title");
		adminProblemTitle.setBounds(y, x+165, wd, 30);
		adminProblemTitle.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminProblemTitle.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminProblemTitle);
		
		txt_adminProblemTitle = new JTextField();
		txt_adminProblemTitle.setBounds(y, x+205, wd, 30);
		txt_adminProblemTitle.setBorder(new RoundedBorder(4));
		txt_adminProblemTitle.setForeground(new Color(51, 54, 102));
		txt_adminProblemTitle.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txt_adminProblemTitle.setEditable(false);
		panelAdmin.add(txt_adminProblemTitle);
		
		adminProblemBody = new JLabel("Body");
		adminProblemBody.setBounds(y, x+245, wd, 30);
		adminProblemBody.setFont(new Font("Ubuntu", Font.BOLD, 15));
		adminProblemBody.setForeground(new Color(51, 54, 102));
		panelAdmin.add(adminProblemBody);
		
		txt_adminProblemBody = new JTextArea();
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
		
		btn_adminUpdateInsertProblemList = new JButton("Update / Insert");
		btn_adminUpdateInsertProblemList.setBounds(y, x+445, wd, 30);
		btn_adminUpdateInsertProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminUpdateInsertProblemList.setBackground(new Color(51, 54, 102));
		btn_adminUpdateInsertProblemList.setForeground(Color.WHITE);
		btn_adminUpdateInsertProblemList.setModel(new FixedStateButtonModel());
		btn_adminUpdateInsertProblemList.setBorder(null);
		btn_adminUpdateInsertProblemList.setFocusable(false);
		btn_adminUpdateInsertProblemList.setEnabled(false);
		panelAdmin.add(btn_adminUpdateInsertProblemList);
		
		btn_adminCancelProblemList = new JButton("Cancel");
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
		
		adminRequestProblemList = new JLabel("Requested Problem List");
		adminRequestProblemList.setBounds(y, x, wd, ht);
		adminRequestProblemList.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminRequestProblemList.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminRequestProblemList);
		
		combo_adminRequestProblemList = new JComboBox<String>();
		
		
		combo_adminRequestProblemList.setBounds(y, x+40, wd, ht);
		combo_adminRequestProblemList.setVisible(true);
		combo_adminRequestProblemList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminRequestProblemList.setBackground(Color.WHITE);
		combo_adminRequestProblemList.setForeground(new Color(51, 54, 102));
		combo_adminRequestProblemList.setBorder(null);
		combo_adminRequestProblemList.setFocusable(false);
		panelAdmin.add(combo_adminRequestProblemList);
		
		btn_adminSelectRequestProblemList = new JButton("Select");
		btn_adminSelectRequestProblemList.setBounds(y, x+85, 105, 30);
		btn_adminSelectRequestProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectRequestProblemList.setBackground(new Color(51, 54, 102));
		btn_adminSelectRequestProblemList.setForeground(Color.WHITE);
		btn_adminSelectRequestProblemList.setModel(new FixedStateButtonModel());
		btn_adminSelectRequestProblemList.setBorder(null);
		btn_adminSelectRequestProblemList.setFocusable(false);
		panelAdmin.add(btn_adminSelectRequestProblemList);
		
		btn_adminDeleteRequestProblemList = new JButton("Delete");
		btn_adminDeleteRequestProblemList.setBounds(y+115, x+85, 105, 30);
		btn_adminDeleteRequestProblemList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminDeleteRequestProblemList.setBackground(new Color(51, 54, 102));
		btn_adminDeleteRequestProblemList.setForeground(Color.WHITE);
		btn_adminDeleteRequestProblemList.setModel(new FixedStateButtonModel());
		btn_adminDeleteRequestProblemList.setBorder(null);
		btn_adminDeleteRequestProblemList.setFocusable(false);
		btn_adminDeleteRequestProblemList.setEnabled(false);
		panelAdmin.add(btn_adminDeleteRequestProblemList);
		
		adminShowRequestProblemList = new JTextArea("");
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
		
		adminUser = new JLabel("User List");
		adminUser.setBounds(y, x, wd, ht);
		adminUser.setFont(new Font("Ubuntu", Font.BOLD, 18));
		adminUser.setForeground(new Color(255, 51, 51));
		panelAdmin.add(adminUser);
		
		combo_adminUserList = new JComboBox<String>();
		
		
		combo_adminUserList.setBounds(y, x+40, wd, ht);
		combo_adminUserList.setVisible(true);
		combo_adminUserList.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		combo_adminUserList.setBackground(Color.WHITE);
		combo_adminUserList.setForeground(new Color(51, 54, 102));
		combo_adminUserList.setBorder(null);
		combo_adminUserList.setFocusable(false);
		panelAdmin.add(combo_adminUserList);
		
		
		btn_adminSelectUserList = new JButton("Select");
		btn_adminSelectUserList.setBounds(y, x+85, 105, 30);
		btn_adminSelectUserList.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminSelectUserList.setBackground(new Color(51, 54, 102));
		btn_adminSelectUserList.setForeground(Color.WHITE);
		btn_adminSelectUserList.setModel(new FixedStateButtonModel());
		btn_adminSelectUserList.setBorder(null);
		btn_adminSelectUserList.setFocusable(false);
		panelAdmin.add(btn_adminSelectUserList);
		
		adminShowUserInfo = new JTextArea("");
		adminShowUserInfo.setBounds(y, x+130, 220, 300);
		adminShowUserInfo.setForeground(new Color(51, 54, 102));
		adminShowUserInfo.setFont(new Font("Ubuntu", Font.BOLD, 14));
		adminShowUserInfo.setOpaque(false);
		adminShowUserInfo.setWrapStyleWord(true);
		adminShowUserInfo.setLineWrap(true);
		adminShowUserInfo.setEditable(false);
		panelAdmin.add(adminShowUserInfo);
		
		btn_adminChangeUserRole = new JButton("Change Role");
		btn_adminChangeUserRole.setBounds(y+115, x+85, 105, 30);
		btn_adminChangeUserRole.setFont(new Font("Ubuntu", Font.BOLD, 16));
		btn_adminChangeUserRole.setBackground(new Color(51, 54, 102));
		btn_adminChangeUserRole.setForeground(Color.WHITE);
		btn_adminChangeUserRole.setModel(new FixedStateButtonModel());
		btn_adminChangeUserRole.setBorder(null);
		btn_adminChangeUserRole.setFocusable(false);
		btn_adminChangeUserRole.setEnabled(false);
		panelAdmin.add(btn_adminChangeUserRole);
		
		
		
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


	}
}
