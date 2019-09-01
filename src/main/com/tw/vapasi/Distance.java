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

    enum Unit {
        KM,
        CM,
        M
    }

    Distance(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToCms() {
        switch (this.unit) {
            case M:
                return this.value * M_IN_CMS;
            case KM:
                return this.value * KMS_IN_CMS;
            default:
                return this.value;
        }
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
        return this.convertToCms() == otherDistance.convertToCms();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.unit.hashCode() + this.value);
    }
}
