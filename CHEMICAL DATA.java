-----Write a pgm in Java to Read ,Update and Delete any record from the Element table. The table
Element has following fields (Atomic weight, Name and Chemical symbol). The input should be
provided through Command Line Argument along with the appropriate data..------------



package sample1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Scanner;

	public class Pgm {

		public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			String c=s.nextLine();		
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/practise","root","root");
					switch(c) 
					{
					case "I":
					Float f =s.nextFloat();
					String str=s.next();
					String strr=s.next();	
					PreparedStatement ps=con.prepareStatement("insert into ChemicalD values(?,?,?)");
					ps.setFloat(1, f);
					ps.setString(2, str);
					ps.setString(3, strr);
					int i=ps.executeUpdate();
					  if(i>0)
					   {
						   System.out.println("Successfully inserted");
					   }
					break;
					case "R":
					     Statement st=con.createStatement();
					 	ResultSet rs=  st.executeQuery("select * from ChemicalD");
					 	while(rs.next())
					 	{
					 		System.out.println(rs.getFloat(1));
					 		System.out.println(rs.getString(2));
					 		System.out.println(rs.getString(3));
					 	}
					break;
					case "U":
						Float f1 =s.nextFloat();
						String str1=s.next();
						String strr1=s.next();
						PreparedStatement p=con.prepareStatement("update Element set AtomicWeight=?,ChemicalName=? where ChemicalSymbol=?");
						p.setFloat(1, f1);
						p.setString(2, str1);
						p.setString(3, strr1);
						p.executeUpdate();
						System.out.println("Updated Successfully ");
					break;
					case "D":
						String strr2=s.next();
						PreparedStatement ps1=con.prepareStatement("delete from ChemicalD where ChemicalSymbol=?");
		
						  ps1.setString(1, strr2);
						  ps1.executeUpdate();
						  System.out.println(" Deleted Successfully ");
					break;	  
					}
				}
				catch(Exception e)
				{
					
				}
		
		}

	}




