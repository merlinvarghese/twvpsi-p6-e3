package com.tw.vapasi;

import java.util.Objects;

//Understands metrics of different units.
class Measurement {
    private final double value;
    private final Unit unit;
    private final MeasurementType measurementType;

    private double convertedValue = 0.0;
    private double finalValue = 0.0;

    enum MeasurementType {
        WEIGHT,
        LENGTH;
    }

     Measurement(double value, Unit unit, MeasurementType measurementType) {

        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    static Measurement cms(int magnitude) {
        return new Measurement(magnitude, Unit.CM, MeasurementType.LENGTH);
    }

    static Measurement km(int magnitude) {
        return new Measurement(magnitude, Unit.KM, MeasurementType.LENGTH);
    }

    static Measurement meter(int magnitude) {
        return new Measurement(magnitude, Unit.M, MeasurementType.LENGTH);
    }

    static Measurement kg(int magnitude) {
        return new Measurement(magnitude, Unit.KG, MeasurementType.WEIGHT);
    }

    static Measurement gram(int magnitude) {
        return new Measurement(magnitude, Unit.GM, MeasurementType.WEIGHT);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if ((otherObject == null) || (this.getClass() != otherObject.getClass())) {
            return false;
        }
        Measurement otherMeasurement = (Measurement) otherObject;
        if (isDifferentMeasurementType(otherMeasurement)) {
            return false;
        }

        return this.convertToBase() == otherMeasurement.convertToBase();
    }

    private boolean isDifferentMeasurementType(Measurement otherMeasurement) {
        return !this.measurementType.equals(otherMeasurement.measurementType);
    }

    Measurement addTo(Object otherObject) throws cannotAddException {
        Measurement otherMeasurement = (Measurement) otherObject;
        if (this.measurementType != otherMeasurement.measurementType) {
            throw new cannotAddException("can not add different ..");
        }
        convertedValue = convertToOther(this,otherMeasurement);
        return new Measurement(convertedValue + this.value, this.unit,this.measurementType);
    }

    private double convertToOther(Measurement measurement, Measurement otherMeasurement) {
        if(measurement.unit.getConversionFactor() > otherMeasurement.unit.getConversionFactor()) {
            return this.unit.convertToOtherUnit(otherMeasurement.value);
        }
        return otherMeasurement.unit.convertToBaseUnit(otherMeasurement.value);
    }

    private double convertToBase() {
        return this.unit.convertToBaseUnit(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.unit.hashCode() + this.value);
    }
}
