package com.jasonkp.converterkp.enums;

public enum DistanceType {
    MILLIMETRE {
        @Override
        public double toMetre(double value) {
            return value * 0.001;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 0.001;
        }
    },
    CENTIMETRE {
        @Override
        public double toMetre(double value) {
            return value * 0.01;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 0.01;
        }
    },
    METRE {
        @Override
        public double toMetre(double value) {
            return value;
        }
        @Override
        public double fromMetre(double metre) {
            return metre;
        }
    },
    KILOMETRE {
        @Override
        public double toMetre(double value) {
            return value * 1000;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 1000;
        }
    },
    INCH {
        @Override
        public double toMetre(double value) {
            return value * 0.0254;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 0.0254;
        }
    },
    FOOT {
        @Override
        public double toMetre(double value) {
            return value * 0.3048;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 0.3048;
        }
    },
    YARD {
        @Override
        public double toMetre(double value) {
            return value * 0.9144;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 0.9144;
        }
    },
    MILE {
        @Override
        public double toMetre(double value) {
            return value * 1609.34;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 1609.34;
        }
    },
    PARSEC {
        @Override
        public double toMetre(double value) {
            return value * 3.086e+16;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 3.086e+16;
        }
    },
    FURLONG {
        @Override
        public double toMetre(double value) {
            return value * 201.168;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 201.168;
        }
    },
    LIGHT_YEAR {
        @Override
        public double toMetre(double value) {
            return value * 9.461e+15;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 9.461e+15;
        }
    },
    ANGSTROM {
        @Override
        public double toMetre(double value) {
            return value * 1e-10;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 1e-10;
        }
    },
    NANOMETRE {
        @Override
        public double toMetre(double value) {
            return value * 1e-9;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 1e-9;
        }
    },
    ASTRONOMICAL_UNIT {
        @Override
        public double toMetre(double value) {
            return value * 1.496e+11;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 1.496e+11;
        }
    },
    BANANA {
        @Override
        public double toMetre(double value) {
            return value * 0.18;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 0.18;
        }
    },
    FOOTBALL_FIELD {
        @Override
        public double toMetre(double value) {
            return value * 91.4;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 91.4;
        }
    },
    RUGBY_FIELD {
        @Override
        public double toMetre(double value) {
            return value * 100;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 100;
        }
    },
    EMPIRE_STATE_BUILDING {
        @Override
        public double toMetre(double value) {
            return value * 443;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 443;
        }
    },
    GIRAFFE {
        @Override
        public double toMetre(double value) {
            return value * 5.5;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 5.5;
        }
    },
    DOUBLE_DECKER_BUS {
        @Override
        public double toMetre(double value) {
            return value * 11;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 11;
        }
    },
    PAPERCLIP {
        @Override
        public double toMetre(double value) {
            return value * 0.05;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 0.05;
        }
    },
    EIFFEL_TOWER {
        @Override
        public double toMetre(double value) {
            return value * 330;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 330;
        }
    },
    BURJ_KHALIFA {
        @Override
        public double toMetre(double value) {
            return value * 830;
        }
        @Override
        public double fromMetre(double metre) {
            return metre / 830;
        }
    };

    public abstract double toMetre(double value);
    public abstract double fromMetre(double metre);

     public double convertTo ( double value, DistanceType toUnit){
        if (this == toUnit) {
            return value;
        }
        // Convert the input value to the reference unit (metre) first
        double metre = this.toMetre(value);
        if (metre < 0) {
            throw new IllegalArgumentException("You cannot have a negative value for Distance");
        }
        // Convert from the reference unit to the target unit
        return toUnit.fromMetre(metre);
    }

    public static DistanceType fromString(String distance) {
        switch (distance) {
            case "Millimetres": return MILLIMETRE;
            case "Centimetres": return CENTIMETRE;
            case "Metres": return METRE;
            case "Kilometres": return KILOMETRE;
            case "Inches": return INCH;
            case "Feet": return FOOT;
            case "Yards": return YARD;
            case "Miles": return MILE;
            case "Parsecs": return PARSEC;
            case "Furlongs": return FURLONG;
            case "Light Years": return LIGHT_YEAR;
            case "Angstroms": return ANGSTROM;
            case "Nanometres": return NANOMETRE;
            case "Astronomical Units": return ASTRONOMICAL_UNIT;
            case "Bananas": return BANANA;
            case "Football Fields": return FOOTBALL_FIELD;
            case "Rugby Fields": return RUGBY_FIELD;
            case "Empire State Buildings": return EMPIRE_STATE_BUILDING;
            case "Giraffes": return GIRAFFE;
            case "Double Decker Busses": return DOUBLE_DECKER_BUS;
            case "Paperclips": return PAPERCLIP;
            case "Eiffel Towers": return EIFFEL_TOWER;
            case "Burj Khalifas": return BURJ_KHALIFA;
            default: throw new IllegalArgumentException("Unsupported distance unit: " + distance);
        }
    }
}
