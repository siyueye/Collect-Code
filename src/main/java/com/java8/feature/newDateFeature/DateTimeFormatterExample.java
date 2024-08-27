package com.java8.feature.newDateFeature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime = LocalDateTime.now();
        String strDate1 = localDateTime.format(dateTimeFormatter1);
        System.out.println(strDate1);
        // 运行结果：2024-08-26
        // Date -> String
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate2 = dateTimeFormatter2.format(localDateTime);
        System.out.println(strDate2);
        // 运行结果：2024-08-26 16:33:03
        // String -> Date
        LocalDateTime localDateTime1 = localDateTime.parse(strDate2,dateTimeFormatter2);
        System.out.println(localDateTime1);
    }
}
