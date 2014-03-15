package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Hotel {

    private final Integer rating;
    private final List<Rate> rates;

    public Integer priceFor(RateType weekday, CustomerType regular) {

        return 110;
    }
}
