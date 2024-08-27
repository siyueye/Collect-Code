package com.java8.feature.newDateFeature;

import java.time.*;

public class InstantExample {
    public static void main(String[] args) {
        Instant instant1 = Instant.now();
        System.out.println(instant1);
        // 运行结果：2024-08-26T08:07:55.284336100Z
        // 默认获取UTC时区
// 偏移量运算
        OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        // 运行结果：2024-08-26T16:07:55.284336100+08:00
        // 获取时间戳
        System.out.println(instant1.toEpochMilli());
        // 运行结果：1724659675284
        // 以Unix元年为起点，进行偏移量运算
        Instant instant2 = Instant.ofEpochSecond(60);
        System.out.println(instant2);
        // 运行结果：1970-01-01T00:01:00Z

        Instant instant_1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant_2 = Instant.now();
        Duration duration = Duration.between(instant_1, instant_2);
        System.out.println(duration.toMillis());
        // 运行结果：1000
        LocalTime localTime_1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime_2 = LocalTime.now();
        System.out.println(Duration.between(localTime_1, localTime_2).toMillis());

        LocalDate localDate_1 = LocalDate.of(2018,9, 9);
        LocalDate localDate_2 = LocalDate.now();
        Period period = Period.between(localDate_1, localDate_2);
        System.out.println(period.getYears());
// 运行结果：1
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
// 运行结果：1
        // 运行结果：18
    }
}
