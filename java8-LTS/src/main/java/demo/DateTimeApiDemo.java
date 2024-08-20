package demo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeApiDemo {

    public static void main(String[] args) {
        date();
        time();
        dateTime();
    }

    private static void date() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
    }

    private static void time() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.toString());
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private static void dateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

        Timestamp ts = Timestamp.valueOf(localDateTime);
        System.out.println(ts.getTime());
    }
}
