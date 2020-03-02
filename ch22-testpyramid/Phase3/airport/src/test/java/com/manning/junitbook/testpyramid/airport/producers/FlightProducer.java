package com.manning.junitbook.testpyramid.airport.producers;

import com.manning.junitbook.testpyramid.airport.FlightBuilderUtil;
import com.manning.junitbook.testpyramid.airport.Flight;
import com.manning.junitbook.testpyramid.airport.annotations.FlightNumber;

import javax.enterprise.inject.Produces;
import java.io.IOException;

public class FlightProducer {

    @Produces
    @FlightNumber(number= "AA1234")
    public Flight createFlight() throws IOException {
        return FlightBuilderUtil.buildFlightFromCsv("AA1234", 50,"src/test/resources/flights_information.csv");
    }
}
