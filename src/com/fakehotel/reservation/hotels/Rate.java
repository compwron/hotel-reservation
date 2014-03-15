package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.CustomerType;
import com.fakehotel.reservation.RateType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Rate {
    private final RateType rateType;
    private final CustomerType customerType;
    @Getter
    private final Integer cost;

    public boolean isFor(RateType rateType, CustomerType customerType) {
        return this.rateType.equals(rateType) && this.customerType.equals(customerType);
    }
}
