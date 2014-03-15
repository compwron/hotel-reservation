package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelTest {
    private Hotel hotel;

    @Before
    public void setUp() {
        Rate weekdayRegular = new Rate(RateType.Weekday, CustomerType.Regular, 100);
        Rate weekendRegular = new Rate(RateType.Weekend, CustomerType.Regular, 150);
        Rate weekdayRewards = new Rate(RateType.Weekday, CustomerType.Rewards, 80);
        Rate weekendRewards = new Rate(RateType.Weekend, CustomerType.Rewards, 125);

        hotel = new Hotel("hotel name", 3, newArrayList(weekdayRegular, weekendRegular, weekdayRewards, weekendRewards));
    }

    @Test
    public void shouldHaveRatingForRegularCustomerOnWeekday() {
        assertThat(hotel.priceFor(RateType.Weekday, CustomerType.Regular), is(100));
    }

    @Test
    public void shouldHaveRatingForRegularCustomerOnWeekend() {
        assertThat(hotel.priceFor(RateType.Weekend, CustomerType.Regular), is(150));
    }

    @Test
    public void shouldHaveRatingForRewardsCustomerOnWeekday() {
        assertThat(hotel.priceFor(RateType.Weekday, CustomerType.Rewards), is(80));
    }

    @Test
    public void shouldHaveRatingForRewardsCustomerOnWeekend() {
        assertThat(hotel.priceFor(RateType.Weekend, CustomerType.Rewards), is(125));
    }
}
