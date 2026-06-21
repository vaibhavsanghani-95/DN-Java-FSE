package org.project.junittesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest2 {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up test...");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Cleaning up after test...");
    }

    @Test
    public void testAdd() {

        // Arrange
        int num1 = 2;
        int num2 = 3;

        // Act
        int result = calculator.add(num1, num2);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract(){
        int num1=10;
        int num2=5;

        int result=calculator.subtract(num1,num2);

        assertEquals(5,result);
    }
}
