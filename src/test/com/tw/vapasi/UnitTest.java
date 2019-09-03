package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void shouldConvertKmToBase() {
        double actual = Unit.KM.convertToBaseUnit(2);
        assertEquals(200000, actual);
    }

    @Test
    void shouldConvertMToBase() {
        double actual = Unit.M.convertToBaseUnit(2);
        assertEquals(200, actual);
    }

    @Test
    void shouldConvertCMToCM() {
        double actual = Unit.CM.convertToBaseUnit(5);
        assertEquals(5, actual);
    }

    @Test
    void shouldConvertKGToBase() {
        double actual = Unit.KG.convertToBaseUnit(2);
        assertEquals(2000, actual);
    }

    @Test
    void shouldConvertGMToGM() {
        double actual = Unit.GM.convertToBaseUnit(1);
        assertEquals(1, actual);
    }

}