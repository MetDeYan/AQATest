package com.example.AQATest.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {

    private Calc calc = new Calc();

    @Test
    public void testSum() throws Exception {
        Assert.assertEquals(15, calc.sum(12,3));
    }
}