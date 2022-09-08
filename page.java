import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class page implements ActionListener
 {
 Frame f;
 Label l1,l2,l3;
 TextField t1,t2,t3;
 TextArea ta;
 Button b1,b2,b3, b4,b5,b6,b7,b8,b9,b10,b11,b12;
 Connection co;
 ResultSet rs;
 PreparedStatement st;
 page()
 { f=new Frame("details");
 l1=new Label("name");
 l2=new Label("age");
 l3=new Label("sal");
 ta=new TextArea();
 b1=new Button("save");
 b2=new Button("show");
 b3=new Button("clear");
 b4=new Button("sName");
 b5=new Button("sAge");
 b6=new Button("sSal");
 
 b7=new Button("dName");
 b8=new Button("dAge");
 b9=new Button("dSal");
 b10=new Button("uName");
 b11=new Button("uAge");
 b12=new Button("uSal");
 
 t1=new TextField();
 t2=new TextField();
 t3= new TextField();
  f.setVisible(true);
  f.setSize(850,500);
  f.setLayout(null);
  f.add(l1);
  f.add(l2);
  f.add(l3);
  f.add(t1);
  f.add(t2);
  f.add(t3);
  f.add(b1);
  f.add(b2);
  f.add(b3);
  f.add(b4);
  f.add(b5);
  f.add(b6);
  f.add(b7);
  f.add(b8);
  f.add(b9);
  f.add(b10);
  f.add(b11);
  f.add(b12);
  f.add(ta);
  
l1.setBounds(100,50,100,40);
l2.setBounds(100,110,100,40);
l3.setBounds(100,170,100,40);
t1.setBounds(250,50,150,40);
t2.setBounds(250,110,150,40);
t3.setBounds(250,170,150,40);
ta.setBounds(100,300,690,100);
b1.setBounds(150,230,80,40);
b2.setBounds(270,230,80,40);  
b3.setBounds(385,425,80,40);

b4.setBounds(450,50,80,40);
b5.setBounds(580,50,80,40);  
b6.setBounds(710,50,80,40);
b7.setBounds(450,110,80,40);
b8.setBounds(580,110,80,40);  
b9.setBounds(710,110,80,40);
b10.setBounds(450,170,80,40);
b11.setBounds(580,170,80,40);  
b12.setBounds(710,170,80,40);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
 b5.addActionListener(this);
 b6.addActionListener(this);
 b7.addActionListener(this);
 b8.addActionListener(this);
 b9.addActionListener(this);
 b10.addActionListener(this);
 b11.addActionListener(this);
 b12.addActionListener(this);

try{
 Class.forName("com.mysql.cj.jdbc.Driver");
 co = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
 }
 catch(ClassNotFoundException e){
 System.out.println(e);
 }
 catch(SQLException e){
 System.out.println(e);
 }
 }
 
 public void actionPerformed(ActionEvent ae)
 {
	 if(ae.getSource()==b1)
	 {
	String s1=t1.getText();
	String s2=t2.getText();
	String s3=t3.getText();
	try{
	  st=co.prepareStatement("insert into emp values (?,?,?)");
	  st.setString(1,s1);
	  st.setInt(2,Integer.parseInt(s2));
	  st.setInt(3,Integer.parseInt(s3));
	  st.executeUpdate();
	  st.close();
	  JOptionPane.showMessageDialog(b1,"Data has been saved.");
	  t1.setText("");
	  t2.setText("");
	  t3.setText("");
	  
		
	}catch(SQLException e)
	{System.out.print("in err"+e);}
	 
 }
   else if(ae.getSource()==b2){
	   try{
	   st=co.prepareStatement("select * from emp");
	   rs=st.executeQuery();
	   String data="";
	   while(rs.next()){
		   data=data+rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+"\n";
	   }
	   JOptionPane.showMessageDialog(b2,"Data has been shown.");
	   ta.setText(data);
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
   else if(ae.getSource()==b3){
	   ta.setText("");
   }
   else if(ae.getSource()==b4)
	 {
	String s1=t1.getText();
	try{
	   st=co.prepareStatement("select * from emp where name=?");
	   st.setString(1,s1);
	   rs=st.executeQuery();
	   String data="";
	while(rs.next()){
		  data=data+rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+"\n";
	   }
	   JOptionPane.showMessageDialog(b2,"Data has been shown.");
	   ta.setText(data);
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
    else if(ae.getSource()==b5)
	 {
	String s1=t2.getText();
	try{
	   st=co.prepareStatement("select * from emp where age=?");
	   st.setInt(1,Integer.parseInt(s1));
	   rs=st.executeQuery();
	   String data="";
	while(rs.next()){
		  data=data+rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+"\n";
	   }
	   JOptionPane.showMessageDialog(b2,"Data has been shown.");
	   ta.setText(data);
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
   else if(ae.getSource()==b6)
	 {
	String s1=t3.getText();
	try{
	   st=co.prepareStatement("select * from emp where sal=?");
	   st.setInt(1,Integer.parseInt(s1));
	   rs=st.executeQuery();
	   String data="";
	while(rs.next()){
		  data=data+rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+"\n";
	   }
	   JOptionPane.showMessageDialog(b2,"Data has been shown.");
	   ta.setText(data);
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
   
   else if(ae.getSource()==b7)
	 {
	String s1=t1.getText();
	try{
	   st=co.prepareStatement("delete from emp where name=?");
	   st.setString(1,s1);
	   st.executeUpdate();
	   JOptionPane.showMessageDialog(b2,"Data has been deleted.");
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
   else if(ae.getSource()==b8)
	 {
	String s1=t2.getText();
	try{
	   st=co.prepareStatement("delete from emp where age=?");
	   st.setInt(1,Integer.parseInt(s1));
	   st.executeUpdate();
	   JOptionPane.showMessageDialog(b2,"Data has been deleted.");
	
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
   
else if(ae.getSource()==b9)
	 {
	String s1=t3.getText();
	try{
	   st=co.prepareStatement("delete from emp where sal=?");
	   st.setInt(1,Integer.parseInt(s1));
	   st.executeUpdate();
	   JOptionPane.showMessageDialog(b2,"Data has been deleted.");
	
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }   
   else if(ae.getSource()==b10)
	 {
	String s1=t1.getText();
	String s2=t2.getText();
	String s3=t3.getText();
	try{
	   st=co.prepareStatement("update emp set age=?,sal=? where name=?");
	   st.setInt(1,Integer.parseInt(s2));
	   st.setInt(2,Integer.parseInt(s3));
	   st.setString(3,s1);
	   st.executeUpdate();
	   JOptionPane.showMessageDialog(b2,"Data has been updated.");
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
   else if(ae.getSource()==b11)
	 {
	String s1=t1.getText();
	String s2=t2.getText();
	String s3=t3.getText();
	try{
	   st=co.prepareStatement("update emp set name=?,sal=? where age=?");
	   st.setString(1,s1);
	   st.setInt(2,Integer.parseInt(s3));
	   st.setInt(3,Integer.parseInt(s2));
	   st.executeUpdate();
	   JOptionPane.showMessageDialog(b2,"Data has been updated.");
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }
 else if(ae.getSource()==b12)
	 {
	String s1=t1.getText();
	String s2=t2.getText();
	String s3=t3.getText();
	try{
	   st=co.prepareStatement("update emp set name=?,age=? where sal=?");
	   st.setString(1,s1);
	   st.setInt(2,Integer.parseInt(s2));
	   st.setInt(3,Integer.parseInt(s3));
	   st.executeUpdate();
	   JOptionPane.showMessageDialog(b2,"Data has been updated.");
	   st.close();
	   
	   }
	   catch(Exception e){
		   System.out.print("in err"+e);
	   }
   }

 }
 
 public static void main(String arr[])
 {page a1= new page();}
 }
 