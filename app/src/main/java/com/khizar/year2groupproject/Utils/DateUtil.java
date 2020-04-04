package com.khizar.year2groupproject.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date AddDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date GetDate (String dateString, Date defaultDate)
    {
        try
        {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            return date;
        }
        catch(ParseException ex)
        {
            //ignore assessments with invalid dates
            return defaultDate;
        }
    }

    public static boolean IsDateInRange(Date date, Date start, Date end)
    {
        if (date == null)
            return false;
        if (start == null)
            return false;
        if (end == null)
            return false;
        return date.compareTo(start) >= 0 && date.compareTo(end) <= 0;
    }
}