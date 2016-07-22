package com.epicodus.gamestat.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Guest on 7/22/16.
 */
public class FormatDate {

    public static String formatDate(String date){
        String formattedDate = date;

            SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
            Date newdate = null;
            try {
                newdate = sdfSource.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                formattedDate = new SimpleDateFormat("MMMM d yyyy").format(newdate);
            }catch(NullPointerException e){
                e.printStackTrace();
            }




        return formattedDate;
    }
}
