package GymApp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
public class ManageDataBase {

	private static Alert A1=new Alert(Alert.AlertType.INFORMATION);
	private static Alert A2=new Alert(Alert.AlertType.ERROR);
	private static ArrayList<Object> List=new ArrayList<>();
    static ObservableList<String> results=FXCollections.observableArrayList();
	public static boolean IsTrue(String User,String Pass)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM sign WHERE username=? and pass=?"))
		{
			P.setString(1, User);
			P.setString(2, Pass);
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			if(R1.getString("username").equals(User)&&R1.getString("pass").equals(Pass))
			    return true;
			else 
				return false;
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return false;
		}
		
		
	}
	
	public static int getRowId()
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT MAX(id) + 1 AS next_id FROM subscriber"))
		{
			ResultSet R1=P.executeQuery();
			if(R1.next())
			{
				return R1.getInt("next_id");
			}
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}		
		return 1;
	}
	
	public static void NewSub(String Name,int Age,String Job,String SocialCase,int Times,int Price)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("INSERT INTO subscriber VALUES(?,?,?,?,?,?,?)"))
		{
			P.setInt(1,getRowId());
			P.setString(2, Name);
			P.setInt(3, Age);
			P.setString(4, Job);
			P.setString(5, SocialCase);
			P.setInt(6, Times);
			P.setInt(7, Price);
			P.execute();
			A1.setTitle("مشترك جديد");
			A1.setContentText("تم الاشتراك بنجاح, المعرف الخاص بالمشترك: "+String.valueOf(getRowId()-1));
			A1.getDialogPane().setStyle("-fx-font-size: 16px");
			A1.show();
			
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
			
	}
	
	public static int getTimes(int Id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT times FROM subscriber WHERE id=?"))
		{
			P.setInt(1, Id);
			P.execute();	
			ResultSet R1=P.executeQuery();
			R1.next();
			return R1.getInt("times");
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return 0;
		}		
	}
	
	public static void UpdateTimes(int Id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE subscriber SET times=? WHERE id=?"))
		{
			P.setInt(1, getTimes(Id)-1);
			P.setInt(2, Id);
			P.execute();			
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}				
	}
	
	public static SubInfo SignIn(int Id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM subscriber WHERE id =?"))
		{
			UpdateTimes(Id);
			P.setInt(1,Id);
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			SubInfo Info=new SubInfo(R1.getString("name"),R1.getInt("age"),R1.getString("Job"),R1.getString("socialcase"),R1.getInt("times"),R1.getInt("price"));
			return Info;
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return null;
		}
					
	}
	public static boolean IsFound(int Id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM subscriber WHERE id=?"))
		{
			P.setInt(1, Id);
			P.execute();
			ResultSet R1=P.executeQuery();
			if(R1.next())
			{
				return true;
			}
			else 
				return false;			
		}
		catch(Exception E)
		{
		   System.out.println(E.getMessage());	
		   return false;
		}
		
	}
	
	public static void RenewTimes(int Id,int times,int price)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE subscriber SET times=?,price=? WHERE id=?"))
		{
			P.setInt(1, times);
			P.setInt(2, price);
			P.setInt(3, Id);
			P.execute();
			A1.setTitle("تجديد");
			A1.setContentText("تم التجديد بنجاح");
			A1.getDialogPane().setStyle("-fx-font-size: 20px");
			A1.show();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
		
		
	}
	
	public static void DeleteSub(int Id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("DELETE FROM subscriber WHERE id=?"))
		{
			P.setInt(1, Id);
			P.execute();
			A1.setTitle("الغاء اشتراك");
			A1.setContentText("تم الغاء الاشتراك بنجاح");
			A1.getDialogPane().setStyle("-fx-font-size: 20px");
			A1.show();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
		
		
	}
	
	public static ArrayList<SubInfo> GetAll()
	{
		ArrayList<SubInfo> List=new ArrayList<>();
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM subscriber"))
		{
			P.execute();
			ResultSet R1=P.executeQuery();
			while(R1.next())
			{
				List.add(new SubInfo(R1.getInt("id"),R1.getString("name"),R1.getInt("age"),R1.getString("job"),R1.getString("socialcase"),R1.getInt("times"),R1.getInt("price")));
			}
			return List;
			
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return null;
		}		
	}
	
	public static void SearchList(String query)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT name FROM subscriber WHERE name LIKE ?"))
		{
			P.setString(1, "%" + query + "%");
			P.execute();
			ResultSet R1 = P.executeQuery();

            results.clear();
            while (R1.next()) {
                // Assuming you want to display the value of the 'name' column
                results.add(R1.getString("name"));
            }
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
		
	}
	
	public static int getIdByName(String Name)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT id FROM subscriber WHERE name = ?"))
		{
			P.setString(1, Name);
			P.execute();
			ResultSet R1 = P.executeQuery();
            R1.next();
            return R1.getInt("id");
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			A2.setTitle("خطا");
			A2.setContentText("حدث خطا في الادخال");
			A2.getDialogPane().setStyle("-fx-font-size: 15px");
			A2.show();
			return 0;
		}
		
	}
	
	public static int getPriceByDays(int Days)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT the_price FROM price WHERE the_days=?"))
		{
			P.setInt(1, Days);
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			return R1.getInt("the_price");
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return 0;
		}
		
		
	}
	public static void UpdatePrice(int price,int days)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE price set the_price=? WHERE the_days=?"))
		{
			P.setInt(1, price);
			P.setInt(2, days);
			P.execute();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}		
		
	}
	
}
