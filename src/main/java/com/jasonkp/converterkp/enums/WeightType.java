package com.jasonkp.converterkp.enums;

public enum WeightType {
    GRAM {
        @Override
        public double toGram(double value) { return value; }
        @Override
        public double fromGram(double gram) { return gram; }
    },
    KILOGRAM {
        @Override
        public double toGram(double value) { return value * 1000; }
        @Override
        public double fromGram(double gram) { return gram / 1000; }
    },
    TONNE {
        @Override
        public double toGram(double value) { return value * 1_000_000; }
        @Override
        public double fromGram(double gram) { return gram / 1_000_000; }
    },
    POUND {
        @Override
        public double toGram(double value) { return value * 453.592; }
        @Override
        public double fromGram(double gram) { return gram / 453.592; }
    },
    OUNCE {
        @Override
        public double toGram(double value) { return value * 28.3495; }
        @Override
        public double fromGram(double gram) { return gram / 28.3495; }
    },
    BANANA {
        @Override
        public double toGram(double value) { return value * 118; }
        @Override
        public double fromGram(double gram) { return gram / 118; }
    },
    PAPERCLIP {
        @Override
        public double toGram(double value) { return value * 1; }
        @Override
        public double fromGram(double gram) { return gram / 1; }
    },
    ELEPHANT {
        @Override
        public double toGram(double value) { return value * 6_000_000; }
        @Override
        public double fromGram(double gram) { return gram / 6_000_000; }
    },
    BLUE_WHALE {
        @Override
        public double toGram(double value) { return value * 150_000_000; }
        @Override
        public double fromGram(double gram) { return gram / 150_000_000; }
    },
    FEATHER {
        @Override
        public double toGram(double value) { return value * 0.0062; }
        @Override
        public double fromGram(double gram) { return gram / 0.0062; }
    },
    BOWLING_BALL {
        @Override
        public double toGram(double value) { return value * 7257; }
        @Override
        public double fromGram(double gram) { return gram / 7257; }
    },
    HAMSTER {
        @Override
        public double toGram(double value) { return value * 120; }
        @Override
        public double fromGram(double gram) { return gram / 120; }
    },
    SMARTPHONE {
        @Override
        public double toGram(double value) { return value * 174; }
        @Override
        public double fromGram(double gram) { return gram / 174; }
    },
    DCHEESEBURGER {
        @Override
        public double toGram(double value) { return value * 165; }
        @Override
        public double fromGram(double gram) { return gram / 165; }
    },
    ARNOLD {
        @Override
        public double toGram(double value) { return value * 107000; }
        @Override
        public double fromGram(double gram) { return gram / 107000; }
    },
    SNYMAN {
        @Override
        public double toGram(double value) { return value * 130000; }
        @Override
        public double fromGram(double gram) { return gram / 130000; }
    },
    SLICE_OF_PIZZA {
        @Override
        public double toGram(double value) { return value * 107; }
        @Override
        public double fromGram(double gram) { return gram / 107; }
    };

    public abstract double toGram(double value);
    public abstract double fromGram(double gram);

    public static WeightType fromString(String weight) {
        switch (weight) {
            case "Grams": return GRAM;
            case "Kilograms": return KILOGRAM;
            case "Tonnes": return TONNE;
            case "Pounds": return POUND;
            case "Ounces": return OUNCE;
            case "Bananas": return BANANA;
            case "Paperclips": return PAPERCLIP;
            case "Elephants": return ELEPHANT;
            case "Blue Whales": return BLUE_WHALE;
            case "Feathers": return FEATHER;
            case "Double Cheeseburgers": return DCHEESEBURGER;
            case "Bowling Balls": return BOWLING_BALL;
            case "Hamsters": return HAMSTER;
            case "Smartphones": return SMARTPHONE;
            case "Arnold Schwarzeneggers": return ARNOLD;
            case "RG Snymans": return SNYMAN;
            case "Slices of Pizza": return SLICE_OF_PIZZA;
            default: throw new IllegalArgumentException("Unsupported weight unit selected: " + weight);
        }
    }

    public double convertTo(double value, WeightType toUnit) {
        if (this == toUnit) return value;
        if (value < 0) throw new IllegalArgumentException("Weight cannot be negative");
        
        double gram = this.toGram(value);
        return toUnit.fromGram(gram);
    }
}