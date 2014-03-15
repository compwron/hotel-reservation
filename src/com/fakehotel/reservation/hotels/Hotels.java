package com.fakehotel.reservation.hotels;

import com.fakehotel.reservation.ReservationRequest;

public class Hotels {
    private Hotel[] hotels;

    public Hotels(Hotel... hotels) {
        this.hotels = hotels;
    }

    public String hotelWithBestRateFor(ReservationRequest request) {
        Hotel hotelWithBestRate = hotels[0];
        for (Hotel hotel : hotels) {
            if (hotel.priceFor(request) < hotelWithBestRate.priceFor(request)) {
                hotelWithBestRate = hotel;
            }
        }
        return hotelWithBestRate.getHotelName();
    }
}
