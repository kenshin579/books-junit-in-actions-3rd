package com.manning.junitbook.springboot;

import com.manning.junitbook.springboot.model.Passenger;
import com.manning.junitbook.springboot.registration.PassengerRegistrationEvent;
import com.manning.junitbook.springboot.registration.RegistrationManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.ImportResource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@EnableAutoConfiguration
@ImportResource("classpath:application-context.xml")
class RegistrationTest {

	@Autowired
	private Passenger passenger;

	@Autowired
	private RegistrationManager registrationManager;

	@Test
	void testPersonRegistration() {
		registrationManager.getApplicationContext().publishEvent(new PassengerRegistrationEvent(passenger));
		System.out.println("After registering:");
		System.out.println(passenger);
		assertTrue(passenger.isRegistered());
	}

}
