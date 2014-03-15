package com.fakehotel.reservation;

import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReservationRequestTest {
    @Test
    public void shouldHaveDayTypeWeekday() {
        ReservationRequest request = new ReservationRequest("Regular: 20Mar2009(fri)");
        assertThat(request.getRateType(), is(RateType.Weekday));
    }

    @Test
    public void shouldHaveDayTypeWeekend() {
        ReservationRequest request = new ReservationRequest("Regular: 21Mar2009(sat)");
        assertThat(request.getRateType(), is(RateType.Weekend));
    }
    @Test
    public void shouldHaveCustomerTypeRegular() {
        ReservationRequest request = new ReservationRequest("Regular: 20Mar2009(fri)");
        assertThat(request.getCustomerType(), is(CustomerType.Regular));
    }

    @Test
    public void shouldHaveCustomerTypeRewards() {
        ReservationRequest request = new ReservationRequest("Rewards: 20Mar2009(fri)");
        assertThat(request.getCustomerType(), is(CustomerType.Rewards));
    }

    @Test
    public void shouldHaveMultipleRateTypesPerRequestWhenRequestHasWeekdaysAndWeekendDays(){
        ReservationRequest request = new ReservationRequest("Rewards: 20Mar2009(fri) 21Mar2009(sat)");
        List<LocalDate> dates = newArrayList(new LocalDate(2009, 3, 20), new LocalDate(2009, 3, 21));
        assertThat(request.getDates(), is(dates));
    }
}
