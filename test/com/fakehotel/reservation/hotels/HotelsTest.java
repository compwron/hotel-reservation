package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import com.fakehotel.reservation.ReservationRequest;
import org.junit.Ignore;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelsTest {
    @Test
    public void shouldFindBestRateForRegularWeekday() {
        Hotels hotels = new Hotels(new Hotel("hotel name", 5, newArrayList(new Rate(RateType.Weekday, CustomerType.Regular, 100))));
        assertThat(hotels.hotelWithBestRateFor(new ReservationRequest("Regular: 20Mar2009(fri)")), is("hotel name"));
    }

    @Test
    public void shouldFindBestRateForRegularWeekdayWithTwoChoices() {
        Hotel hotel1 = new Hotel("hotel name 1", 5, newArrayList(new Rate(RateType.Weekday, CustomerType.Regular, 100)));
        Hotel hotel2 = new Hotel("hotel name 2", 5, newArrayList(new Rate(RateType.Weekday, CustomerType.Regular, 90)));
        Hotels hotels = new Hotels(hotel1, hotel2);
        assertThat(hotels.hotelWithBestRateFor(new ReservationRequest("Regular: 20Mar2009(fri)")), is("hotel name 2"));
    }

    @Ignore("save this for later")
    @Test
    public void shouldFindBestRateForRegularWeekdayWithTwoChoicesEqualExceptForRating() {
        Hotel hotel1 = new Hotel("hotel name 1", 4, newArrayList(new Rate(RateType.Weekday, CustomerType.Regular, 100)));
        Hotel hotel2 = new Hotel("hotel name 2", 5, newArrayList(new Rate(RateType.Weekday, CustomerType.Regular, 100)));
        Hotels hotels = new Hotels(hotel1, hotel2);
        assertThat(hotels.hotelWithBestRateFor(new ReservationRequest("Regular: 20Mar2009(fri)")), is("hotel name 2"));
    }

    @Test
    public void shouldFindBestRateForOneWeekendAndOneWeekdayForRegularCustomer() {
        Rate rate1 = new Rate(RateType.Weekday, CustomerType.Regular, 100);
        Rate rate2 = new Rate(RateType.Weekend, CustomerType.Regular, 100);
//        total 200

        Rate rate3 = new Rate(RateType.Weekday, CustomerType.Regular, 70);
        Rate rate4 = new Rate(RateType.Weekend, CustomerType.Regular, 120);
//        total 190

        Hotel hotel1 = new Hotel("hotel name 1", 5, newArrayList(rate1, rate2));
        Hotel hotel2 = new Hotel("hotel name 2", 5, newArrayList(rate3, rate4));

        Hotels hotels = new Hotels(hotel1, hotel2);

        assertThat(hotels.hotelWithBestRateFor(new ReservationRequest("Regular: 20Mar2009(fri) 21Mar2009(sat)")), is("hotel name 1"));
    }
}
