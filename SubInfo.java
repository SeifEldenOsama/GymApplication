package GymApp;

public class SubInfo {

	private String Name,Job,SocialCase;
	private int Id,Age,Times,Price;
	
	
	public SubInfo(String Name,int Age,String Job,String SocialCase,int Times,int Price)
	{
		this.Name=Name;
		this.Age=Age;
		this.Job=Job;
		this.SocialCase=SocialCase;
		this.Times=Times;
		this.Price=Price;
		
	}
	
	public SubInfo(int Id,String Name,int Age,String Job,String SocialCase,int Times,int Price)
	{
		this.Id=Id;
		this.Name=Name;
		this.Age=Age;
		this.Job=Job;
		this.SocialCase=SocialCase;
		this.Times=Times;
		this.Price=Price;
		
	}
	public void setId(int Id)
	{
		this.Id=Id;
	}
	public int getId()
	{
		return Id;
	}
	
	public void setName(String Name)
	{
		this.Name=Name;
	}
	public String getName()
	{
		return this.Name;
	}
	public void setJob(String Job)
	{
		this.Job=Job;
	}
	public String getJob() 
	{
		return this.Job;
	}
	public void setSocialCase(String SocialCase)
	{
		this.SocialCase=SocialCase;
	}
	public String getSocialCase()
	{
		return this.SocialCase;
	}
	public void setAge(int Age)
	{
		this.Age=Age;
	}
	public int getAge()
	{
		return this.Age;
	}
	public void setTimes(int Times)
	{
		this.Times=Times;
	}
	public int getTimes()
	{
		return this.Times;
	}
	public void setPrice(int Price)
	{
		this.Price=Price;
	}
	public int getPrice()
	{
		return this.Price;
	}
}
