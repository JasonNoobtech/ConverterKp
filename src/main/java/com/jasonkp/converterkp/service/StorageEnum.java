package com.jasonkp.converterkp.service;

public enum StorageEnum {
    BIT {
        @Override
        public double toBit(double value) { return value; }
        @Override
        public double fromBit(double bit) { return bit; }
    },
    KILOBIT {
        @Override
        public double toBit(double value) { return value * 1000; }
        @Override
        public double fromBit(double bit) { return bit / 1000; }
    },
    MEGABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000; }
    },
    GIGABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000_000L; }
    },
    TERABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000_000_000L; }
    },
    PETABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000_000_000_000L; }
    },
    BYTE {
        @Override
        public double toBit(double value) { return value * 8; }
        @Override
        public double fromBit(double bit) { return bit / 8; }
    },
    KILOBYTE {
        @Override
        public double toBit(double value) { return value * 8000; }
        @Override
        public double fromBit(double bit) { return bit / 8000; }
    },
    MEGABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000; }
    },
    GIGABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000_000L; }
    },
    TERABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000_000_000L; }
    },
    PETABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000_000_000_000L; }
    },
;

    public abstract double toBit(double value);
    public abstract double fromBit(double bit);

    public static StorageEnum fromString(String storage) {
        switch (storage) {
            case "Bits": return BIT;
            case "Kilobits": return KILOBIT;
            case "Megabits": return MEGABIT;
            case "Gigabits": return GIGABIT;
            case "Terabits": return TERABIT;
            case "Petabits": return PETABIT;
            case "Bytes": return BYTE;
            case "Kilobytes": return KILOBYTE;
            case "Megabytes": return MEGABYTE;
            case "Gigabytes": return GIGABYTE;
            case "Terabytes": return TERABYTE;
            case "Petabytes": return PETABYTE;
            default: throw new IllegalArgumentException("Unsupported storage unit selected: " + storage);
        }
    }

    public double convertTo(double value, StorageEnum toUnit) {
        if (this == toUnit) return value;
        if (value < 0) throw new IllegalArgumentException("Storage cannot be negative");
        
        double bit = this.toBit(value);
        return toUnit.fromBit(bit);
    }
}