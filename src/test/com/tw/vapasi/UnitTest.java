package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void shouldConvertKmToBase() {
        double actual = Unit.KM.convertToCms(2);
        assertEquals(200000, actual);
    }

    @Test
    void shouldConvertMToBase() {
        double actual = Unit.M.convertToCms(2);
        assertEquals(200, actual);
    }

    @Test
    void shouldConvertCMToBase() {
        double actual = Unit.CM.convertToCms(5);
        assertEquals(5, actual);
    }
}