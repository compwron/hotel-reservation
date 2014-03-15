package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import com.fakehotel.reservation.ReservationRequest;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelsTest {
    @Test
    public void shouldFindBestRateForRegularWeekday(){
        Hotels hotels = new Hotels(new Hotel("hotel name", 5, newArrayList(new Rate(RateType.Weekday, CustomerType.Regular, 100))));
        assertThat(hotels.hotelWithBestRateFor(new ReservationRequest("Regular: 20Mar2009(fri)")), is("hotel name"));
    }
}
