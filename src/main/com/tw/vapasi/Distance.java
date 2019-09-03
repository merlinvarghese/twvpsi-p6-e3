package com.tw.vapasi;

import java.util.Objects;

//Understands length in various units
class Distance {
    private static final double M_IN_CMS = 100;
    private static final double KMS_IN_CMS = 100000;
    private final double value;
    private final Unit unit;

    static Distance cms(int magnitude) {
        return new Distance(magnitude, Unit.CM);
    }

    static Distance km(int magnitude) {
        return new Distance(magnitude, Unit.KM);
    }

    static Distance meter(int magnitude) {
        return new Distance(magnitude, Unit.M);
    }

    Distance(double value, Unit unit) {

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
        Distance otherDistance = (Distance) otherObject;
        return this.convertToBase() == otherDistance.convertToBase();
    }

    private double convertToBase() {
        return this.unit.convertToCms(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.unit.hashCode() + this.value);
    }
}
