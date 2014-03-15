package com.fakehotel.reservation.hotels;

public class DefaultHotels {
    public Hotels hotels() {
//        ● Lakewood with a rating of 3 has weekday rates as 110$ for regular customer and 80$ for rewards customer.
// The weekend rates are 90$ for regular customer and 80$ for a rewards customer.
        Hotel lakewood = new Hotel("Lakewood", 3, new Rate(RateType.Weekday, 110, ));
//        Hotel bridgewood = new Hotel("Bridgewood");
//        Hotel ridgewood = new Hotel("Ridgewood");
        return new Hotels(lakewood);
    }
}
