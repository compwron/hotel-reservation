package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import com.fakehotel.reservation.ReservationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Hotel {
    @Getter
    private final String hotelName;
    private final Integer rating;
    private final List<Rate> rates;

    public Integer priceFor(List<RateType> rateTypes, CustomerType customerType) {
        for (Rate rate : rates) {
            if (rate.isFor(rateType, customerType)) {
                return rate.getCost();
            }
        }
        return null; // TODO: default price if there are any rates
    }

    public Integer priceFor(ReservationRequest request) {
        return priceFor(request.getRateType(), request.getCustomerType());
    }
}
