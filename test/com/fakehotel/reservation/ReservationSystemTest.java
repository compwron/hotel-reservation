package com.fakehotel.reservation;

import com.fakehotel.reservation.hotels.Hotel;
import com.fakehotel.reservation.hotels.Hotels;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReservationSystemTest {
    @Test
    public void shouldReserveCheapestRoom(){
        String hotelName = "hotelname";
        Hotels hotels = new Hotels(new Hotel(hotelName, 1, 2));
        ReservationSystem reservationSystem = new ReservationSystem(newArrayList("Regular: 20Mar2009(fri)"), hotels);
        assertThat(reservationSystem.reservationResults(), is(hotelName));
    }
}
