package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Measurement.*;
import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Test
    void expect100CmEquals100cm() {
        assertEquals(cms(100), cms(100));
    }

    @Test
    void expect100cmEquals1Meter() {
        assertEquals(cms(100), meter(1));
    }

    @Test
    void expect100000CmEquals1Kilometer() {
        assertEquals(cms(100000), km(1));
    }

    @Test
    void expect2mEquals200Centimeter() {
        assertEquals(meter(2), cms(200));
    }

    @Test
    void expect5MeterEquals5Meter() {
        assertEquals(meter(5), meter(5));
    }

    @Test
    void expect5000MeterEquals5Kilometer() {
        assertEquals(meter(5000), km(5));
    }

    @Test
    void expect4KiloMeterEquals400000Centimeters() {
        assertEquals(km(4), cms(400000));
    }

    @Test
    void expect4KiloMeterEquals4000Meters() {
        assertEquals(km(4), meter(4000));
    }

    @Test
    void expect7KiloMeterEquals7Kilometers() {
        assertEquals(km(7), km(7));
    }

    @Test
    void expectFalseWhenOneObjectIsNull() {
        assertFalse(cms(30).equals(null));
    }
    @Test
    void expectTrueWhen1KGIs1000G (){
        assertTrue(kg(1).equals(gram(1000)));
    }

    @Test
    void expectFalseWhen10KGIs1000G (){
        assertFalse(kg(10).equals(gram(1000)));
    }

    @Test
    void expectFalseWhen1KGIs1KM (){
        assertFalse(cms(1).equals(gram(1)));
    }

    @Test
    void expect5000MeterNotEquals5Km() {
        assertNotEquals(meter(7000), km(8));
    }

    @Test
    void expect1KgNotEquals1Km() {
        assertFalse(meter(10).equals(gram(1000)));
    }

    @Test
    void expect300CMForInput100CMPlus2M()throws Exception {
        Measurement measurement = new Measurement(100,Unit.CM,MeasurementType.LENGTH);
        Measurement othermeasurement = new Measurement(2,Unit.M,MeasurementType.LENGTH);
        assertEquals(300.0,measurement.addTo(othermeasurement));
    }

    @Test
    void expect2Point2ForInput2KGPlus200GM() throws Exception {
        Measurement measurement = new Measurement(2,Unit.KG,MeasurementType.LENGTH);
        Measurement othermeasurement = new Measurement(200,Unit.GM,MeasurementType.LENGTH);
        assertEquals(2.2,measurement.addTo(othermeasurement));
    }

    @Test
    void expectFalseWhenInputIs100CMPlus100GM() throws Exception {
        Measurement measurement = new Measurement(100,Unit.CM,MeasurementType.LENGTH);
        Measurement othermeasurement = new Measurement(100,Unit.GM,MeasurementType.WEIGHT);
        assertEquals(0.0,measurement.addTo(othermeasurement));
    }

    @Test
    void expectFalseWhenInputIs100CMPlus100KG()  {
        Measurement measurement = new Measurement(100,Unit.CM,MeasurementType.LENGTH);
        Measurement othermeasurement = new Measurement(100,Unit.KG,MeasurementType.WEIGHT);
        try {
            measurement.addTo(othermeasurement);
            Assertions.fail("Failed");
        }
        catch(Exception exception){

        }
    }
}
