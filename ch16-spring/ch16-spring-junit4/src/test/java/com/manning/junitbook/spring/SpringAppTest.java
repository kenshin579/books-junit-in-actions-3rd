package com.manning.junitbook.spring;
import static com.manning.junitbook.spring.PassengerUtil.getExpectedPassenger;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SpringAppTest {
	
	@Autowired
	private Passenger passenger;
	private Passenger expectedPassenger;
	

	@Before
	public void setUp() {
		expectedPassenger = getExpectedPassenger();
	}

	@Test
	public void testInitPassenger() {
		assertEquals(expectedPassenger, passenger);
		System.out.println(passenger);
	}

}
