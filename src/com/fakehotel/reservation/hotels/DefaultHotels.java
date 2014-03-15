package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;

import static com.google.common.collect.Lists.newArrayList;

public class DefaultHotels {
    public Hotels hotels() {
        return new Hotels(lakewood(), bridgewood(), ridgewood());
    }

    private Hotel lakewood() {
        Rate weekdayRegular = new Rate(RateType.Weekday, CustomerType.Regular, 110);
        Rate weekendRegular = new Rate(RateType.Weekend, CustomerType.Regular, 90);
//        200 for 1+1

        Rate weekdayRewards = new Rate(RateType.Weekday, CustomerType.Rewards, 80);
        Rate weekendRewards = new Rate(RateType.Weekend, CustomerType.Rewards, 80);
//      160 for 1+1

        return new Hotel("Lakewood", 3, newArrayList(weekdayRegular, weekendRegular, weekdayRewards, weekendRewards));
    }

    private Hotel bridgewood() {
        Rate weekdayRegular = new Rate(RateType.Weekday, CustomerType.Regular, 160);
        Rate weekendRegular = new Rate(RateType.Weekend, CustomerType.Regular, 60);
//        220 for 1+1

        Rate weekdayRewards = new Rate(RateType.Weekday, CustomerType.Rewards, 110);
        Rate weekendRewards = new Rate(RateType.Weekend, CustomerType.Rewards, 50);
//        160 for 1+1

        return new Hotel("Bridgewood", 4, newArrayList(weekdayRegular, weekendRegular, weekdayRewards, weekendRewards));
    }

    private Hotel ridgewood() {
        Rate weekdayRegular = new Rate(RateType.Weekday, CustomerType.Regular, 220);
        Rate weekendRegular = new Rate(RateType.Weekend, CustomerType.Regular, 150);
//        370 for 1+1

        Rate weekdayRewards = new Rate(RateType.Weekday, CustomerType.Rewards, 100);
        Rate weekendRewards = new Rate(RateType.Weekend, CustomerType.Rewards, 40);
//        140 for 1+1

        return new Hotel("Ridgeewood", 5, newArrayList(weekdayRegular, weekendRegular, weekdayRewards, weekendRewards));
    }
}
