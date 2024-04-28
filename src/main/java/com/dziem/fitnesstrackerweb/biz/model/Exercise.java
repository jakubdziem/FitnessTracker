package com.dziem.fitnesstrackerweb.biz.model;

import com.dziem.fitnesstrackerweb.web.formatter.TimeFormatter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty(message = "Name of the exercise must be defined.")
    private String name;
    @NotNull(message = "Number of sets must be defined.")
    @Min(value = 1, message = "Number of sets must be greater than 0.")
    private Integer sets;
    @NotNull(message = "Number of repetitions must be defined.")
    @Min(value = 1, message = "Number of repetitions must be greater than 0.")
    private Integer repetitions;
    @NotNull(message = "Duration must be specified.")
    private Time duration;
    @NotNull(message = "Weight must be specified.")
    private BigDecimal weight;

    public static Exercise parse(String csvLine) {
        String[] fields = csvLine.split(",\\s*");
        if (fields.length < 5) {
            throw new IllegalArgumentException("CSV line does not have enough fields: " + csvLine);
        }
        TimeFormatter timeFormatter = new TimeFormatter();
        Time time = null;
        try {
            time = timeFormatter.parse(fields[3], Locale.ENGLISH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Exercise(null, fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), time, new BigDecimal(fields[4]));
    }
}
