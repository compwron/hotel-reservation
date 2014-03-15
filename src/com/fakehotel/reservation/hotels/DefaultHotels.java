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
        Rate weekdayRewards = new Rate(RateType.Weekday, CustomerType.Rewards, 80);
        Rate weekendRewards = new Rate(RateType.Weekend, CustomerType.Rewards, 80);
        return new Hotel(3, newArrayList(weekdayRegular, weekendRegular, weekdayRewards, weekendRewards));
    }

    private Hotel bridgewood() {
        Rate weekdayRegular = new Rate(RateType.Weekday, CustomerType.Regular, 160);
        Rate weekendRegular = new Rate(RateType.Weekend, CustomerType.Regular, 60);
        Rate weekdayRewards = new Rate(RateType.Weekday, CustomerType.Rewards, 110);
        Rate weekendRewards = new Rate(RateType.Weekend, CustomerType.Rewards, 50);
        return new Hotel(4, newArrayList(weekdayRegular, weekendRegular, weekdayRewards, weekendRewards));
    }

    private Hotel ridgewood() {
        Rate weekdayRegular = new Rate(RateType.Weekday, CustomerType.Regular, 220);
        Rate weekendRegular = new Rate(RateType.Weekend, CustomerType.Regular, 150);
        Rate weekdayRewards = new Rate(RateType.Weekday, CustomerType.Rewards, 100);
        Rate weekendRewards = new Rate(RateType.Weekend, CustomerType.Rewards, 40);
        return new Hotel(5, newArrayList(weekdayRegular, weekendRegular, weekdayRewards, weekendRewards));
    }
}
