package com.fakehotel.reservation;

import org.junit.Test;

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
//
    }
}
