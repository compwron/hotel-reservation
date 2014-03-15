package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;

import java.util.List;

public class Hotel {
    public Hotel(String hotelname, Integer weekdayRate, Integer weekendRate, Integer rating) {
    }

    public Hotel(int rating, List<Rate> rates) {

    }

    public Integer priceFor(RateType weekday, CustomerType regular) {
        return 110;
    }
}
