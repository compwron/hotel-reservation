package com.fakehotel.reservation;

import lombok.Getter;

public class ReservationRequest {
    @Getter
    private RateType rateType;

    @Getter
    private CustomerType customerType;

    public ReservationRequest(String rawRequest) {
        this.rateType = RateType.Weekday;
        this.customerType = CustomerType.Regular;
    }
}
