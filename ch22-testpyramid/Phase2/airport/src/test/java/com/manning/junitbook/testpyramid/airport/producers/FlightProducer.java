package com.manning.junitbook.testpyramid.airport.producers;


import com.manning.junitbook.testpyramid.airport.Flight;
import com.manning.junitbook.testpyramid.airport.FlightBuilderUtil;

import javax.enterprise.inject.Produces;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlightProducer {

    @Produces
    public Flight createFlight() throws IOException {
        return FlightBuilderUtil.buildFlightFromCsv();
    }
}
