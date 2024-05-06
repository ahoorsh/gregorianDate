package com.example.gregoriandate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetGregorianDatesForCurrentJalaliMonth {
    private static final Logger logger = LoggerFactory.getLogger(GetGregorianDatesForCurrentJalaliMonth.class);

    public static Calendar[] getGregorianDatesForCurrentJalaliMonth(JalaliCalendar jalaliCalendar) {
        Calendar[] gregorianDates = new Calendar[2];
        logger.info("Current Jalali Date: {}", JalaliCalendar.getJalaliDate(new Date()));

        int jalaliYear = jalaliCalendar.get(Calendar.YEAR);
        int jalaliMonth = jalaliCalendar.get(Calendar.MONTH);

        int gregorianStartMonth;
        int gregorianEndMonth;

        if (jalaliMonth < 10) {
            gregorianStartMonth = 2 + jalaliMonth;
            gregorianEndMonth = 3 + jalaliMonth;
        } else {
            gregorianStartMonth = jalaliMonth - 9;
            gregorianEndMonth = jalaliMonth - 8;
        }

        JalaliCalendar.YearMonthDate jalaliCalendar1 = getDay(jalaliCalendar);

        String[] arr = JalaliCalendar.getJalaliDate(jalaliCalendar.getTime()).split("/");
        JalaliCalendar.YearMonthDate endOfGregorianDate = new JalaliCalendar.YearMonthDate(Integer.parseInt(arr[0]),
                Integer.parseInt(arr[1]) - 1, getDaysInJalaliMonth(Integer.parseInt(arr[1]), Integer.parseInt(arr[0])));
        JalaliCalendar.YearMonthDate gregorianEndDate = JalaliCalendar.jalaliToGregorian(endOfGregorianDate);

        Calendar startOfMonth = Calendar.getInstance();
        startOfMonth.set(Calendar.YEAR, jalaliYear + 621);
        startOfMonth.set(Calendar.MONTH, gregorianStartMonth);
        startOfMonth.set(Calendar.DAY_OF_MONTH, jalaliCalendar1.getDate());
        gregorianDates[0] = startOfMonth;

        Calendar endOfMonth = Calendar.getInstance();
        endOfMonth.set(Calendar.YEAR, jalaliYear + 621);
        endOfMonth.set(Calendar.MONTH, gregorianEndMonth);
        endOfMonth.set(Calendar.DAY_OF_MONTH, gregorianEndDate.getDate());
        gregorianDates[1] = endOfMonth;

        return gregorianDates;
    }

    private static JalaliCalendar.YearMonthDate getDay(JalaliCalendar jalaliCalendar) {
        String[] arr = JalaliCalendar.getJalaliDate(jalaliCalendar.getTime()).split("/");
        JalaliCalendar.YearMonthDate jalali = new JalaliCalendar.YearMonthDate(Integer.parseInt(arr[0]),
                Integer.parseInt(arr[1]) - 1, 1);
        return JalaliCalendar.jalaliToGregorian(jalali);
    }

    public static int getDaysInJalaliMonth(int month, int year) {
        switch (month) {
            case 1: // Farvardin
            case 2: // Ordibehesht
            case 3: // Khordad
            case 4: // Tir
            case 5: // Mordad
            case 6: // Shahrivar
                return 31;
            case 7: // Mehr
            case 8: // Aban
            case 9: // Azar
            case 10: // Dey
            case 11: // Bahman
                return 30;
            case 12: // Esfand
                return isJalaliLeapYear(year) ? 30 : 29; // Check for leap year
            default:
                throw new IllegalArgumentException("Invalid Jalali month");
        }
    }

    public static boolean isJalaliLeapYear(int year) {
        int yearInCycle = (year + 2346) % 128;
        return (yearInCycle >= 5 && yearInCycle <= 105) && ((yearInCycle - 1) % 33 % 4 == 0);
    }

    public static void main(String[] args) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar();

        Calendar[] gregorianDates = GetGregorianDatesForCurrentJalaliMonth.getGregorianDatesForCurrentJalaliMonth(jalaliCalendar);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
        String startDateString = dateFormat.format(gregorianDates[0].getTime());
        String endDateString = dateFormat.format(gregorianDates[1].getTime());

        System.out.println("Start of current Jalali month: " + startDateString);
        System.out.println("End of current Jalali month: " + endDateString);
    }
}