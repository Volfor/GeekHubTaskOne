package com.vtrifonov.geekhub;

import junit.framework.TestCase;

public class MyTest extends TestCase {

    public void testFibonacci() throws Exception {
        assertEquals(1, TaskTwoActivity.fibonacci(1));
        assertEquals(1, TaskTwoActivity.fibonacci(2));
        assertEquals(8, TaskTwoActivity.fibonacci(6));
        assertEquals(55, TaskTwoActivity.fibonacci(10));
        assertEquals(6765, TaskTwoActivity.fibonacci(20));
        assertEquals(75025, TaskTwoActivity.fibonacci(25));
    }

    public void testFactorial() throws Exception {
        assertEquals(1, TaskTwoActivity.factorial(0));
        assertEquals(1, TaskTwoActivity.factorial(1));
        assertEquals(2, TaskTwoActivity.factorial(2));
        assertEquals(120, TaskTwoActivity.factorial(5));
        assertEquals(40320, TaskTwoActivity.factorial(8));
        assertEquals(6227020800L, TaskTwoActivity.factorial(13));
    }
}
