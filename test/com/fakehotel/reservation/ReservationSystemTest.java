package com.fakehotel.reservation;

import com.fakehotel.reservation.hotels.DefaultHotels;
import com.fakehotel.reservation.hotels.Hotels;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReservationSystemTest {
    @Test
    public void shouldReserveCheapestRoom(){
        Hotels hotels = new DefaultHotels().hotels();
        ReservationSystem reservationSystem = new ReservationSystem(newArrayList("Regular: 20Mar2009(fri)"), hotels);
        assertThat(reservationSystem.reservationResults(), is("Lakewood"));
    }
}
