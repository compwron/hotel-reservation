package com.fakehotel.reservation;

import lombok.Getter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;

public class ReservationRequest {
    @Getter
    private RateType rateType;

    @Getter
    private CustomerType customerType;

    @Getter
    private List<LocalDate> dates = newArrayList();

    public ReservationRequest(String rawRequest) {
        this.rateType = RateType.from(rawRequest);
        this.customerType = CustomerType.from(rawRequest);
        this.dates = datesFrom(rawRequest);
    }

    private List<LocalDate> datesFrom(String rawRequest) {
        List<LocalDate> datesInRequest = newArrayList();

        String regex = ".*(\\d+\\s{3}\\d{4}).*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rawRequest);
        boolean matches = matcher.matches();

        if (matches) {
            for (int i = 0; i < matcher.groupCount(); i++){
                datesInRequest.add(dateFrom(matcher.group(i)));
            }
        }



        return datesInRequest;
    }

    private LocalDate dateFrom(String group) {
        return new LocalDate(DateTimeFormat.forPattern("dMMMy").parseDateTime(group));
    }
}
