package com.fakehotel.reservation;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public enum RateType {
    Weekend,
    Weekday;

    private final List<Integer> daysOfWeek;

    private RateType(Integer... daysOfWeek) {
        this.daysOfWeek = newArrayList(daysOfWeek);
    }

    private static boolean isWeekend(DateTime dateTime) {
        return dateTime.getDayOfWeek() == DateTimeConstants.SATURDAY || dateTime.getDayOfWeek() == DateTimeConstants.SUNDAY;
    }

    public static RateType from(String rawRequest) {
        DateTime dateTime = DateTimeFormat.forPattern("dMMMy").parseDateTime(rawRequest.split(" ")[1].split("\\(")[0]);
        if (isWeekend(dateTime)) {
            return Weekend;
        }
        return Weekday;
    }


}
