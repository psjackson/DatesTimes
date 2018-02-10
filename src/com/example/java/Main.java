package com.example.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //format the date to display in m/d/yyyy format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");

        //create a variable for today's date
        LocalDate today = LocalDate.now();

        //test date to change today's date
        //LocalDate today = LocalDate.of(2018, 12, 30);

        //assign the last full moon date as a variable called last
        LocalDate last = LocalDate.of(2018, 12, 22);

        //displays today's date
        System.out.println("\n--------------------------------------------");
        System.out.println("Today's date is: " + dtf.format(today));

        //create a list of dates of the 2018 Full Moons
        LocalDate[] fullMoonDates = {LocalDate.of(2018, 1, 1),
                LocalDate.of(2018, 1, 31),
                LocalDate.of(2018, 2, 15),
                LocalDate.of(2018, 3, 1),
                LocalDate.of(2018, 3, 31),
                LocalDate.of(2018, 4, 29),
                LocalDate.of(2018, 5, 29),
                LocalDate.of(2018, 6, 27),
                LocalDate.of(2018, 7, 27),
                LocalDate.of(2018, 8, 26),
                LocalDate.of(2018, 9, 24),
                LocalDate.of(2018, 10, 24),
                LocalDate.of(2018, 11, 22),
                LocalDate.of(2018, 12, 22)};

        //reverse the order of the dates
        Collections.reverse(Arrays.asList(fullMoonDates));
        //for days in the list of full moon dates
        for (LocalDate day : fullMoonDates) {
            //if the full moon date is before today
            if (day.isBefore(today)){
                //display to the user that the previous full moon was on teh full moon date
                System.out.println("--------------------------------------------");
                System.out.println("The previous full moon was on: " + dtf.format(day));
                //break out of the loop
                break;
            }
        }

        //reverse the order of the dates back
        Collections.reverse(Arrays.asList(fullMoonDates));
        //for loop to iterate through the list of dates of full moons
        for (LocalDate day : fullMoonDates) {
            //if today is equal or less than the full moon date
            if (today.isEqual(day) || today.isBefore(day)){
                //if today is equal to the full moon date display the next full moon is tonight
                if (today.isEqual(day)){
                    System.out.println("--------------------------------------------");
                    System.out.println("The next full moon is tonight.");
                    System.out.println("--------------------------------------------");
                    //break out of the loop
                    break;
                }
                else{
                    //calculate the difference between today and the next full moon in days
                    long daysToNextFullMoon = today.until(day, ChronoUnit.DAYS);
                    //display the full moon date and the difference between today and the full moon date
                    System.out.println("--------------------------------------------");
                    System.out.println("The next full moon is: " + dtf.format(day));
                    System.out.println("There are " + daysToNextFullMoon + " days to go.");
                    System.out.println("--------------------------------------------");
                    //break out of the loop
                    break;
                }
            }
        }
        //if today is after last
        if (today.isAfter(last)){
            //display there are no more full moons this year
            System.out.println("--------------------------------------------");
            System.out.println("There are no more full moons in 2018.");
            System.out.println("--------------------------------------------");
        }
    }
}