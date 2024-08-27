package com.java8.feature.newDateFeature;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
// 2024-08-26T16:29:02.176744400
        // 获取这个第一天的日期
        System.out.println(localDateTime1.with(TemporalAdjusters.firstDayOfMonth()));
// 2024-08-01T16:29:02.176744400
        // 获取下个周末的日期
        System.out.println(localDateTime1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY))
        );
// 2024-09-01T16:29:02.176744400
        // 自定义：下一个工作日
        LocalDateTime localDateTime2 = localDateTime1.with(l -> {
            LocalDateTime localDateTime = (LocalDateTime) l;
            DayOfWeek dayOfWeek =  localDateTime.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return localDateTime.plusDays(2);
            } else {
                return localDateTime.plusDays(1);
            }
        });
        System.out.println(localDateTime2);
    }
}
