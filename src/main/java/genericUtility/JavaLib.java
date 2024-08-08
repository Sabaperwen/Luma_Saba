package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaLib {

	public Date date()
	{
		Date date=new Date();
		date.toString();
		return date;		
	}
	
	public String dateFormat()
	{
		SimpleDateFormat date2=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date1=new Date();
		String format=date2.format(date1);
		return format;
	}
	
	public int getRandomNum()
	{
	 Random ran=new Random();
	 int random=ran.nextInt(500);
	 return random;
	}
}
