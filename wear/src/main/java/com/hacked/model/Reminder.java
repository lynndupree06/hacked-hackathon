package com.hacked.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.CalendarContract;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.hacked.utility.Config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "Reminder")
public class Reminder extends Model {
    private final Config config = new Config();
    private final Context context;

    @Column
    Date date;

    @Column
    String text;

    public Reminder(String text, String date, Context context) throws ParseException {
        this.text = text;
        this.context = context;

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String[] dateSplit = date.split(" ");

        Integer month = config.getMonth(dateSplit[0]);
        String day = dateSplit[1];

        this.date = format.parse(month + "/" + day + "/2016");

        setCalendarEvent();
    }

    private void setCalendarEvent() {
        long calID = 3;
        ContentResolver cr = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, getDate().toString());
        values.put(CalendarContract.Events.TITLE, "Hackathon Reminder");
        values.put(CalendarContract.Events.CALENDAR_ID, calID);
        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);

        // TODO: Add reminder
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
