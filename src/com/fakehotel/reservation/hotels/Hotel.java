package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Hotel {
    private final String hotelName;
    private final Integer rating;
    private final List<Rate> rates;

    public Integer priceFor(RateType rateType, CustomerType customerType) {
        for (Rate rate : rates) {
            if (rate.isFor(rateType, customerType)) {
                return rate.getCost();
            }
        }
        return null; // TODO: default price if there are any rates
    }
}
