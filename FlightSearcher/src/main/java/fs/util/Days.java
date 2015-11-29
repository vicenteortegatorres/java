package fs.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * Util class with functions related with days
 */
public class Days {
	/*
	 * Calculates the number of days between two dates
	 * 
	 * @param startDate beginning of period
	 * @param endDate end of period
	 * @returns days between both dates
	 */
	public static int between(Date startDate, Date endDate) {
        return (int) ((startDate.getTime() - endDate.getTime()) / (24 * 60 * 60 * 1000));
	} 
	
	
	/*
	 * Returns the date the number of days before today
	 * 
	 * @param days number of days
	 * @returns date the number of days before
	 */
	public static Date ago(int days){
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -days);
		return cal.getTime();
		
	}
}
