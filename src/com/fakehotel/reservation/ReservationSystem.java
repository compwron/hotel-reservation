package com.fakehotel.reservation;

import com.fakehotel.reservation.hotels.Hotels;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ReservationSystem {
    private List<ReservationRequest> reservationRequests = newArrayList();
    private Hotels hotels;

    public ReservationSystem(List<String> lines, Hotels hotels) {
        this.hotels = hotels;
        this.reservationRequests = reservationRequestsFrom(lines);
    }

    private List<ReservationRequest> reservationRequestsFrom(List<String> lines) {
        return newArrayList(Collections2.transform(lines, reservationRequestFromLine()));
    }

    private Function<? super String, ReservationRequest> reservationRequestFromLine() {
        return new Function<String, ReservationRequest>() {
            @Override
            public ReservationRequest apply(String line) {
                return new ReservationRequest(line);
            }
        };
    }

    public String reservationResults() {
        Joiner joiner = Joiner.on("\n");
        return joiner.join(Collections2.transform(reservationRequests, toHotelsWithBestRateForRequest()));
    }

    private Function<? super ReservationRequest, String> toHotelsWithBestRateForRequest() {
        return new Function<ReservationRequest, String>() {
            @Override
            public String apply(ReservationRequest reservationRequest) {
                return hotels.hotelWithBestRateFor(reservationRequest);
            }
        };
    }

}
