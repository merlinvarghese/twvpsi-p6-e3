package com.tw.vapasi;

// Understands conversions from one unit to base unit
class Unit {

    static final Unit KM = new Unit(100000);
    static final Unit M = new Unit(100);
    static final Unit CM = new Unit(1);

    double getConversionFactor() {
        return conversionFactor;
    }

    private double conversionFactor;

    private Unit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    double convertToCms(double magnitude) {
        return magnitude * this.conversionFactor;
    }
}
