package com.dziem.fitnesstrackerweb.web.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.ParseException;
import java.util.Locale;
@Component
public class TimeFormatter implements Formatter<Time> {
    @Override
    public Time parse(String text, Locale locale) throws ParseException {
        text = text.substring(0, text.length()-1);
        int seconds = Integer.parseInt(text); //90s
        int minutes = seconds/60;
        seconds -= minutes*60;
        int hours = minutes/60;
        minutes -= hours*60;
        return new Time(hours, minutes, seconds);
    }

    @Override
    public String print(Time object, Locale locale) {
        return String.format("%dh, %dm, %ds", object.getHours(), object.getMinutes(), object.getSeconds());
    }
}
