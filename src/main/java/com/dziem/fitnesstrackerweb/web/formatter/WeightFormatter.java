package com.dziem.fitnesstrackerweb.web.formatter;

import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

public class WeightFormatter implements Formatter<BigDecimal> {
    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        return new BigDecimal(text.substring(0,text.length()-2));
    }

    @Override
    public String print(BigDecimal object, Locale locale) {
        String text = object.toString();
        text = text.concat("kg");
        return text;
    }
}
