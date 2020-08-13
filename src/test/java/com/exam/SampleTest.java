package com.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SampleTest {
	
	 @DisplayName("Test Sample")
	    @Test
	    void testGet() {
	        assertEquals("Hello JUnit 5", "Hello JUnit 5");
	    }

	

}
