import java.util.Scanner;

/**
 * @modified by Liz Dancy
 * Used to show how to catch multiple Exceptions and then as a base class
 * for the testing exercise with JUnit
 * @modified FURTHER by Chanvir Nijjar
 * For in-class exercise 3 - week 3 - Test Driven Development
 */


import javax.swing.JOptionPane;

/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modified by Liz Dancy
 * Used  as a base class
 * for the testing exercise with JUnit
 *  Winter 2021
 *
 * @modified FURTHER by Chanvir Nijjar
 * For in-class exercise 3 - week 3 - Test Driven Development
 */
public class Time
{
	public static void main(String[] args) 
	{
		int totalSeconds = getTotalSeconds("Github 10:10:10");
		System.out.println("Total Seconds = "+totalSeconds);
	}


	public static int getTotalSeconds(String time)throws NumberFormatException, StringIndexOutOfBoundsException {
		if (time.length()>12 || time.length() < 12)
		{
			throw new NumberFormatException("your time was too long or short!");
		}
		int hours = getTotalHours(time);
		//we will eventually multiply the hours by 3600 + the minutes by 60 + the seconds
		int minutes = getTotalMinutes (time);
		int seconds = getSeconds(time);
		return hours * 3600 + minutes * 60 + seconds;
	}
	
	public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException 
	{
		if (time.length()>12 || time.length() < 12)
		{
			throw new NumberFormatException("your time was too long or short!");
		}
		return Integer.parseInt(time.substring(6,8));
	}

	public static int getMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if (time.length()>12 || time.length() < 12)
		{
			throw new NumberFormatException("your time was too long or short!");
		}
		return Integer.parseInt(time.substring(9,12));
	}

	public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if (time.length()>12 || time.length() < 12)
		{
			throw new NumberFormatException("your time was too long or short!");
		}
		return Integer.parseInt(time.substring(3,5));
	}

	public static int getTotalHours(String time)throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if (time.length()>12 || time.length() < 12)
		{
			throw new NumberFormatException("your time was too long or short!");
		}
		return Integer.parseInt(time.substring(0,2));
	}
	
}



