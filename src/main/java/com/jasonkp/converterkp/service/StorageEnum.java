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
    KIBIBIT {
        @Override
        public double toBit(double value) { return value * 1024; }
        @Override
        public double fromBit(double bit) { return bit / 1024; }
    },
    MEGABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000; }
    },
    MEBIBIT {
        @Override
        public double toBit(double value) { return value * 1_048_576; }
        @Override
        public double fromBit(double bit) { return bit / 1_048_576; }
    },
    GIGABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000_000L; }
    },
    GIBIBIT {
        @Override
        public double toBit(double value) { return value * 1_073_741_824L; }
        @Override
        public double fromBit(double bit) { return bit / 1_073_741_824L; }
    },
    TERABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000_000_000L; }
    },
    TEBIBIT {
        @Override
        public double toBit(double value) { return value * 1_099_511_627_776L; }
        @Override
        public double fromBit(double bit) { return bit / 1_099_511_627_776L; }
    },
    PETABIT {
        @Override
        public double toBit(double value) { return value * 1_000_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 1_000_000_000_000_000L; }
    },
    PEBIBIT {
        @Override
        public double toBit(double value) { return value * 1_125_899_906_842_624L; }
        @Override
        public double fromBit(double bit) { return bit / 1_125_899_906_842_624L; }
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
    KIBIBYTE {
        @Override
        public double toBit(double value) { return value * 8192; }
        @Override
        public double fromBit(double bit) { return bit / 8192; }
    },
    MEGABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000; }
    },
    MEBIBYTE {
        @Override
        public double toBit(double value) { return value * 8_388_608; }
        @Override
        public double fromBit(double bit) { return bit / 8_388_608; }
    },
    GIGABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000_000L; }
    },
    GIBIBYTE {
        @Override
        public double toBit(double value) { return value * 8_589_934_592L; }
        @Override
        public double fromBit(double bit) { return bit / 8_589_934_592L; }
    },
    TERABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000_000_000L; }
    },
    TEBIBYTE {
        @Override
        public double toBit(double value) { return value * 8_796_093_022_208L; }
        @Override
        public double fromBit(double bit) { return bit / 8_796_093_022_208L; }
    },
    PETABYTE {
        @Override
        public double toBit(double value) { return value * 8_000_000_000_000_000L; }
        @Override
        public double fromBit(double bit) { return bit / 8_000_000_000_000_000L; }
    },
    PEBIBYTE {
        @Override
        public double toBit(double value) { return value * 9_007_199_254_740_992L; }
        @Override
        public double fromBit(double bit) { return bit / 9_007_199_254_740_992L; }
    };

    public abstract double toBit(double value);
    public abstract double fromBit(double bit);

    public static StorageEnum fromString(String storage) {
        String normalized = storage.toUpperCase().replace(" ", "_");
        switch (normalized) {
            case "BITS": return BIT;
            case "KILOBITS": return KILOBIT;
            case "KIBIBITS": return KIBIBIT;
            case "MEGABITS": return MEGABIT;
            case "MEBIBITS": return MEBIBIT;
            case "GIGABITS": return GIGABIT;
            case "GIBIBITS": return GIBIBIT;
            case "TERABITS": return TERABIT;
            case "TEBIBITS": return TEBIBIT;
            case "PETABITS": return PETABIT;
            case "PEBIBITS": return PEBIBIT;
            case "BYTES": return BYTE;
            case "KILOBYTES": return KILOBYTE;
            case "KIBIBYTES": return KIBIBYTE;
            case "MEGABYTES": return MEGABYTE;
            case "MEBIBYTES": return MEBIBYTE;
            case "GIGABYTES": return GIGABYTE;
            case "GIBIBYTES": return GIBIBYTE;
            case "TERABYTES": return TERABYTE;
            case "TEBIBYTES": return TEBIBYTE;
            case "PETABYTES": return PETABYTE;
            case "PEBIBYTES": return PEBIBYTE;
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