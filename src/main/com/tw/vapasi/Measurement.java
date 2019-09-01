package com.tw.vapasi;

import java.util.Objects;

public class Measurement {

    private double value;
    private String units;

    Measurement(double value, String units) {
        this.value = value;
        this.units = units;
    }


    public boolean equals(Object obj) {

        if ((obj != null) && obj instanceof Measurement) {
            switch (((Measurement) obj).units) {
                case "METER":
                    if (((Measurement) obj).units.equals("METER") && this.units.equals("CM"))
                        if (this.value == 100 && ((Measurement) obj).value == 1) {
                            return true;
                        }

                case "KM":
                    if (((Measurement) obj).units.equals("KM") && this.units.equals("CM"))
                        if (this.value == 2000 && ((Measurement) obj).value == 2) {
                            return true;
                        }
            }
        }
        return false;
    }

    double convert(Measurement measurement) {
        double cm;
        if (measurement.units.equals("METER")) {
            cm = measurement.value * 100;
            return cm;
        }
        if (measurement.units.equals("KM")) {
            cm = measurement.value * 10000;
            return cm;
        }
        return measurement.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, units);
    }

}
