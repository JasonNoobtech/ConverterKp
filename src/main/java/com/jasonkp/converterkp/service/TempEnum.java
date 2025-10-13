package com.jasonkp.converterkp.service;

public enum TempEnum {

    CELSIUS {
        @Override
        public double toKelvin(double value) {
            return value + 273.15;
        }

        @Override
        public double fromKelvin(double kelvin) {
            return kelvin - 273.15;
        }
    },
    FAHRENHEIT {
        @Override
        public double toKelvin(double value) {
            return (value + 459.67) * 5 / 9;
        }

        @Override
        public double fromKelvin(double kelvin) {
            return (kelvin * 9 / 5) - 459.67;
        }
    },
    KELVIN {
        @Override
        public double toKelvin(double value) {
            return value;
        }

        @Override
        public double fromKelvin(double kelvin) {
            return kelvin;
        }
    };

    public abstract double toKelvin(double value);
    public abstract double fromKelvin(double kelvin);

    public double convertTo ( double value, TempEnum toUnit){
        if (this == toUnit) {
            return value;
        }
        // Convert the input value to the reference unit (Kelvin) first
        double kelvin = this.toKelvin(value);
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero");
        }
        // Convert from the reference unit to the target unit
        return toUnit.fromKelvin(kelvin);
    }
}
