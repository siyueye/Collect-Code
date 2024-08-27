package com.java8.feature.newDateFeature;

import java.time.LocalDateTime;

public class LocalDateExample {
    public static void main(String[] args) {
        // 获取当前系统时间
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
        // 运行结果：2024-08-26T16:02:02.391979
// 指定日期时间
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 10, 27, 13, 45,10);
        System.out.println(localDateTime2);
        // 运行结果：2024-10-27T13:45:10
        LocalDateTime localDateTime3 = localDateTime1
                // 加三年
                .plusYears(3)
                // 减三个月
                .minusMonths(3);
        System.out.println(localDateTime3);
        // 运行结果：2027-05-26T16:02:43.919851600
        System.out.println(localDateTime1.getYear());
// 运行结果：2024
        System.out.println(localDateTime1.getMonthValue()); // 运行结果：8
        System.out.println(localDateTime1.getDayOfMonth()); // 运行结果：26
        System.out.println(localDateTime1.getHour());
// 运行结果：16
        System.out.println(localDateTime1.getMinute());
        System.out.println(localDateTime1.getSecond());
        LocalDateTime localDateTime4 = LocalDateTime.now();
        System.out.println(localDateTime4);
// 运行结果：2
        // 运行结果：43
        // 2024-08-26T16:02:43.919851600
        LocalDateTime localDateTime5 = localDateTime4.withDayOfMonth(10);
        System.out.println(localDateTime5);
// 2024-08-10T16:02:43.919851600
    }
}
