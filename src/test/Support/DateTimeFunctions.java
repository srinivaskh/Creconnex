package test.Support;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Himanth
 * Date: 8/26/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateTimeFunctions extends FluentWebDriverPage {
    public DateTimeFunctions(WebDriverProvider driverProvider) {
        super(driverProvider);
    }
    public static String converDateFormat(String pStrInputDate,String strInputFormat, String strOutputFormat)
            throws Exception {

        DateFormat fromFormat = new SimpleDateFormat(strInputFormat);
        fromFormat.setLenient(false);
        DateFormat toFormat = new SimpleDateFormat(strOutputFormat);
        toFormat.setLenient(false);
        String dateStr = pStrInputDate;
        Date date = fromFormat.parse(dateStr);

        return toFormat.format(date);
    }

    public static String getPastDate(int intyear) {
        String DATE_FORMAT = "MM d yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = 365 * intyear;
        c1.add(Calendar.DATE, -yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }

    /* Fetch the current time
     *
     */
    public static String timeNow(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());

    }

    public static String getPastDay(int intDate, String strDateFormat) {
        String DATE_FORMAT = strDateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = intDate;
        c1.add(Calendar.DATE, -yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }
    public static String getFutureDate(int intDate, String strDateFormat) {
        String DATE_FORMAT = strDateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = intDate;
        c1.add(Calendar.DATE, +yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }

    public static String getPastMonth(int intDate,String strDateFormat) {
        String DATE_FORMAT = strDateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = intDate;
        c1.add(Calendar.MONTH, -yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }

    public static String getFutureMonth(int intDate,String strDateFormat) {
        String DATE_FORMAT = strDateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = intDate;
        c1.add(Calendar.MONTH, yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }

    /**
     * This function return the next date
     */
    public static String getCurrentDate(String Dateformat) {
        String DATE_FORMAT = Dateformat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        String strCurrentDate = sdf.format(c1.getTime());
        return strCurrentDate;
    }

    public static String getPastDay(int intDate) {
        String DATE_FORMAT = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = intDate;
        c1.add(Calendar.DATE, -yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }

    public static String getFutureDay(int intDate) {
        String DATE_FORMAT = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = intDate;
        c1.add(Calendar.DATE, +yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }

    /**
     * This function return the date of birth of a 25 yr old
     * @throws java.text.ParseException
     */

    public static String AddDaytoExistingDate(String strExistDate,int intAdd) throws ParseException, ParseException{

        String dt = strExistDate; // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, intAdd);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date
        System.out.println(dt);

        return dt;
    }

    /**
     * This function returns the name of the month
     */
    public static String getMonth(String strMonth) {
        String[] monthName = { "January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November",
                "December" };

        String month = monthName[Integer.parseInt(strMonth) - 1];

        return month;
    }

    public static String FutureDate(int intAdd, String DateFormat) {
        String DATE_FORMAT = DateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        // c1.set(2012, 0 , 26);
        // System.out.println("Date is : " + sdf.format(c1.getTime()));
        c1.add(Calendar.DATE, intAdd);
        String strNextDate = sdf.format(c1.getTime());
        return strNextDate;
    }

    public static String PastDate(int intAdd, String DateFormat) {
        String DATE_FORMAT = DateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        // c1.set(2012, 0 , 26);
        // System.out.println("Date is : " + sdf.format(c1.getTime()));
        c1.add(Calendar.DATE, -intAdd);
        String strNextDate = sdf.format(c1.getTime());
        return strNextDate;
    }

    public static String compareTwoDates(Calendar c1,Calendar c2){
        String strRes="";

        if (c1.before(c2)) {
            strRes="before";
        }
        if (c1.after(c2)) {
            strRes="after";
        }
        if (c1.equals(c2)) {
            strRes="same";
        }

        return strRes;
    }

    public static String getPastYear(int intYear, String strDateFormat) {
        String DATE_FORMAT = strDateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(
                DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int yearval = intYear;
        c1.add(Calendar.YEAR, -yearval);
        String strDOB = sdf.format(c1.getTime());
        return strDOB;
    }

    public static String getAge(String dateOfBirth, String currentDate)
            throws ParseException, ParseException {
        String age = "";
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        int intAge = 0;
        int factor = 0;
        Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);
        Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(currentDate);
        c1.setTime(date1);
        c2.setTime(date2);
        if (c2.get(Calendar.DAY_OF_YEAR) < c1.get(Calendar.DAY_OF_YEAR)) {
            factor = -1;
        }
        intAge = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR) + factor;
        age = Integer.toString(intAge);
        return age;
    }

    public static double TimeTaken(Date dtStartDate) {
        Date dtEndDate = new Date();
        double dtTimeTaken = dtEndDate.getTime() - dtStartDate.getTime();
        dtTimeTaken = dtTimeTaken / 1000;
        return dtTimeTaken;

    }

    public static String SubtractDayToExistingDate(String strExistDate,String pStrFormat,int intAdd) throws ParseException, ParseException{

        String dt = strExistDate; // Start date
        SimpleDateFormat sdf = new SimpleDateFormat(pStrFormat);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, -intAdd);  // number of days to subtract
        dt = sdf.format(c.getTime());  // dt is now the new date
        System.out.println(dt);

        return dt;
    }

    public static int getTimeDiff1(String Time1,String Time2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

        // Convert the user input into a date object
        Date time1 = sdf.parse(Time1);
        Date time2 = sdf.parse(Time2);

        // Get time values of the date objects
        long l1 = time1.getTime();
        long l2 = time2.getTime();

        long diffSeconds = (l1 - l2) / 1000 % 60;
        long diffMinutes = (l1 - l2) / (60 * 1000) % 60;
        long diffHours = (l1 - l2) / (60 * 60 * 1000) % 24;


        double difference = (l1 - l2)/1000; // Calculate the difference in time (divide by 1000 as in milliseconds)
        difference = (difference <= 0 ? 1 : difference); // If difference is negative, make positive

        int Timedifference=(int) difference;
        System.out.println(Timedifference);
        return Timedifference;
    }
}
