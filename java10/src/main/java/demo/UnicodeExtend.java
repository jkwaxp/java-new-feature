package demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UnicodeExtend {

    public static void main(String[] args) {
        Locale locale = new Locale.Builder()
                .setLanguage("zh")
                .setRegion("CN")
                .setExtension('x', "custom")
                .build();
        System.out.println(locale);

        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME.localizedBy(locale);
        System.out.println(dtf.format(LocalDateTime.now()));
    }
}
