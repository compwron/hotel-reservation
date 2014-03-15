package com.fakehotel.reservation;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String... args) throws IOException {
        String fileLocation = "input/sampleInput.txt";
        List<String> lines = Files.readLines(new File(fileLocation), Charsets.UTF_8);

        ReservationSystem reservationSystem = new ReservationSystem(lines);
        System.out.println(reservationSystem.reservationResults());
    }
}
