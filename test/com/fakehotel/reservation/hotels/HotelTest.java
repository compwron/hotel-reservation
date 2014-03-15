package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelTest {
    @Test
    public void shouldHaveRatingForRegularCustomerOnWeekday(){
//        ● Lakewood with a rating of 3 has weekday rates as 110$ for regular customer and 80$ for rewards customer.
// The weekend rates are 90$ for regular customer and 80$ for a rewards customer.
        Hotel hotel = new Hotel();
        assertThat(hotel.priceFor(RateType.Weekday, CustomerType.Regular), is(110));
    }
}
