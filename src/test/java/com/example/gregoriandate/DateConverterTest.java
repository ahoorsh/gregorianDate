package com.example.gregoriandate;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateConverterTest {

    @Test
    void testGetGregorianDatesForCurrentJalaliKhordad() {
        Calendar[] gregorianDates = GetGregorianDatesForCurrentJalaliMonth.getGregorianDatesForCurrentJalaliMonth(new JalaliCalendar(1403, JalaliCalendar.KHORDAD, 20));

        String expectedStartDate = "Tue May 21 2024";
        String expectedEndDate = "Thu Jun 20 2024";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

        String startOfMonth = dateFormat.format(gregorianDates[0].getTime());
        String endOfMonth = dateFormat.format(gregorianDates[1].getTime());

        assertEquals(expectedStartDate, startOfMonth);
        assertEquals(expectedEndDate, endOfMonth);
    }

    @Test
    void testGetGregorianDatesForCurrentJalaliShahrivar() {
        Calendar[] gregorianDates = GetGregorianDatesForCurrentJalaliMonth.getGregorianDatesForCurrentJalaliMonth(new JalaliCalendar(1403, JalaliCalendar.SHAHRIVAR, 20));

        String expectedStartDate = "Thu Aug 22 2024";
        String expectedEndDate = "Sat Sep 21 2024";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

        String startOfMonth = dateFormat.format(gregorianDates[0].getTime());
        String endOfMonth = dateFormat.format(gregorianDates[1].getTime());

        assertEquals(expectedStartDate, startOfMonth);
        assertEquals(expectedEndDate, endOfMonth);
    }

    @Test
    void testGetGregorianDatesForCurrentJalaliMehr() {
        Calendar[] gregorianDates = GetGregorianDatesForCurrentJalaliMonth.getGregorianDatesForCurrentJalaliMonth(new JalaliCalendar(1403, JalaliCalendar.MEHR, 20));

        String expectedStartDate = "Sun Sep 22 2024";
        String expectedEndDate = "Mon Oct 21 2024";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

        String startOfMonth = dateFormat.format(gregorianDates[0].getTime());
        String endOfMonth = dateFormat.format(gregorianDates[1].getTime());

        assertEquals(expectedStartDate, startOfMonth);
        assertEquals(expectedEndDate, endOfMonth);
    }

    @Test
    void testGetGregorianDatesForCurrentJalaliAban() {
        Calendar[] gregorianDates = GetGregorianDatesForCurrentJalaliMonth.getGregorianDatesForCurrentJalaliMonth(new JalaliCalendar(1403, JalaliCalendar.ABAN, 20));

        String expectedStartDate = "Tue Oct 22 2024";
        String expectedEndDate = "Wed Nov 20 2024";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

        String startOfMonth = dateFormat.format(gregorianDates[0].getTime());
        String endOfMonth = dateFormat.format(gregorianDates[1].getTime());

        assertEquals(expectedStartDate, startOfMonth);
        assertEquals(expectedEndDate, endOfMonth);
    }

    @Test
    void testGetGregorianDatesForCurrentJalaliTir() {
        Calendar[] gregorianDates = GetGregorianDatesForCurrentJalaliMonth.getGregorianDatesForCurrentJalaliMonth(new JalaliCalendar(1403, JalaliCalendar.TIR, 20));

        String expectedStartDate = "Fri Jun 21 2024";
        String expectedEndDate = "Sun Jul 21 2024";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

        String startOfMonth = dateFormat.format(gregorianDates[0].getTime());
        String endOfMonth = dateFormat.format(gregorianDates[1].getTime());

        assertEquals(expectedStartDate, startOfMonth);
        assertEquals(expectedEndDate, endOfMonth);
    }
}