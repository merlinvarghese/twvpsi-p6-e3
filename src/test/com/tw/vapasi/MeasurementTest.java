package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MeasurementTest {
    @Test
    void expect1_MeterFor_100CM() {
        Measurement measurementCM = new Measurement(100, "CM");
        Measurement measurementMeter = new Measurement(1, "METER");
        Assertions.assertEquals(true, measurementCM.equals(measurementMeter));
    }

    @Test
    void expect1_KiloMeterFor_1000M() {
        Measurement measurementCM = new Measurement(2000, "CM");
        Measurement measurementMeter = new Measurement(2, "KM");
        Assertions.assertEquals(true, measurementCM.equals(measurementMeter));
    }

    @Test
    void expectConvertMeter() {
        Measurement measurementMeter = new Measurement(2, "METER");
        Assertions.assertEquals(200, measurementMeter.convert(measurementMeter));
    }

    @Test
    void expectConvertKm() {
        Measurement measurementMeter = new Measurement(2, "KM");
        Assertions.assertEquals(20000, measurementMeter.convert(measurementMeter));
    }

}
