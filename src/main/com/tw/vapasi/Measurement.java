package com.tw.vapasi;

import java.util.Objects;

//Understands metrics of different units.
class UnitMeasurement {
    private final double value;
    private final Unit unit;
    private final MeasurementType measurementType;

    enum MeasurementType {
        WEIGHT,
        LENGTH;
    }

    static UnitMeasurement cms(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.CM, MeasurementType.LENGTH);
    }

    static UnitMeasurement km(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.KM,MeasurementType.LENGTH);
    }

    static UnitMeasurement meter(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.M,MeasurementType.LENGTH);
    }

    static UnitMeasurement kg(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.KG, MeasurementType.WEIGHT);
    }

    static UnitMeasurement gram(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.GM, MeasurementType.WEIGHT);
    }
    private UnitMeasurement(double value, Unit unit,MeasurementType measurementType) {

        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if ((otherObject == null) || (this.getClass() != otherObject.getClass())) {
            return false;
        }
        UnitMeasurement otherMeasurement = (UnitMeasurement) otherObject;
        if (isDifferentMeasurementType(otherMeasurement)) {
            return false;
        }

        return this.convertToBase() == otherMeasurement.convertToBase();
    }

    private double convertToBase() {
        return this.unit.convertToBaseUnit(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.unit.hashCode() + this.value);
    }
}
