package com.tw.vapasi;

import java.util.Objects;

//Understands metrics of different units.
class UnitMeasurement {
    private final double value;
    private final Unit unit;

    static UnitMeasurement cms(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.CM);
    }

    static UnitMeasurement km(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.KM);
    }

    static UnitMeasurement meter(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.M);
    }

    static UnitMeasurement kg(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.KG);
    }

    static UnitMeasurement gram(int magnitude) {
        return new UnitMeasurement(magnitude, Unit.GM);
    }
    private UnitMeasurement(double value, Unit unit) {

        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if ((otherObject == null) || (this.getClass() != otherObject.getClass())) {
            return false;
        }
        UnitMeasurement otherUnitMeasurement = (UnitMeasurement) otherObject;
        return this.convertToBase() == otherUnitMeasurement.convertToBase();
    }

    private double convertToBase() {
        return this.unit.convertToBaseUnit(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.unit.hashCode() + this.value);
    }
}
