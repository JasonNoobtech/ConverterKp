package com.jasonkp.converterkp.enums;

public enum CelestialType {
    //Planets
    EARTH {
        @Override
        public double toEarth(double value) {
            return value;
        }
        @Override
        public double fromEarth(double earth) {
            return earth;
        }
    }, MERCURY {
        @Override
        public double toEarth(double value) {
            return value * 0.240846;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.240846;
        }
    }, VENUS {
        @Override
        public double toEarth(double value) {
            return value * 0.615197;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.615197;
        }
    }, MARS {
        @Override
        public double toEarth(double value) {
            return value * 1.880815;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 1.880815;
        }
    }, JUPITER {
        @Override
        public double toEarth(double value) {
            return value * 11.862615;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 11.862615;
        }
    }, SATURN {
        @Override
        public double toEarth(double value) {
            return value * 29.447498;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 29.447498;
        }
    }, URANUS {
        @Override
        public double toEarth(double value) {
            return value * 84.016846;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 84.016846;
        }
    }, NEPTUNE {
        @Override
        public double toEarth(double value) {
            return value * 3.88;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 3.88;
        }
    },
    // Dwarf Planets
    PLUTO {
        @Override
        public double toEarth(double value) {
            return value * 0.186;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.186;
        }
    }, CERES {
        @Override
        public double toEarth(double value) {
            return value * 0.074;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.074;
        }
    }, HAUMEA {
        @Override
        public double toEarth(double value) {
            return value * 0.163;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.163;
        }
    }, MAKEMAKE {
        @Override
        public double toEarth(double value) {
            return value * 0.95;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.95;
        }
    }, ERIS {
        @Override
        public double toEarth(double value) {
            return value * 1.08;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 1.08;
        }
    },
    // Stars
    SUN {
        @Override
        public double toEarth(double value) {
            return value * 109;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 109;
        }
    }, SIRIUS {
        @Override
        public double toEarth(double value) { return value * 2.64; }
        @Override
        public double fromEarth(double earth) { return earth / 2.64; }
    }, BETELGEUSE {
        @Override
        public double toEarth(double value) { return value * 764; }
        @Override
        public double fromEarth(double earth) { return earth / 764; }
    }, VEGA {
        @Override
        public double toEarth(double value) { return value * 2.36; }
        @Override
        public double fromEarth(double earth) { return earth / 2.36; }
    }, ARCTURUS {
        @Override
        public double toEarth(double value) { return value * 25.4; }
        @Override
        public double fromEarth(double earth) { return earth / 25.4; }
    }, RIGEL {
        @Override
        public double toEarth(double value) { return value * 78.9; }
        @Override
        public double fromEarth(double earth) { return earth / 78.9; }
    }, POLLUX {
        @Override
        public double toEarth(double value) { return value * 8.8; }
        @Override
        public double fromEarth(double earth) { return earth / 8.8; }
    }, ANTARES {
        @Override
        public double toEarth(double value) { return value * 700; }
        @Override
        public double fromEarth(double earth) { return earth / 700; }
    },
    FOMALHAUT {
        @Override
        public double toEarth(double value) { return value * 1.84; }
        @Override
        public double fromEarth(double earth) { return earth / 1.84; }
    }, DENEB {
        @Override
        public double toEarth(double value) { return value * 203; }
        @Override
        public double fromEarth(double earth) { return earth / 203; }
    },
    // Space-Crafts
    DEATH_STAR {
        @Override
        public double toEarth(double value) {
            return value * 63.7;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 63.7;
        }
    }, ISS {
        @Override
        public double toEarth(double value) {
            return value *  0.0000085;
        }
        @Override
        public double fromEarth(double earth) {
            return earth /  0.0000085;
        }
    }, APOLLO_11 {
        @Override
        public double toEarth(double value) { return value * 0.125; }
        @Override
        public double fromEarth(double earth) { return earth / 0.125; }
    }, MILLENNIUM_FALCON {
        @Override
        public double toEarth(double value) { return value * 0.5; }
        @Override
        public double fromEarth(double earth) { return earth / 0.5; }
    }, APOLLO_13 {
        @Override
        public double toEarth(double value) { return value * 0.000003; }
        @Override
        public double fromEarth(double earth) { return earth / 0.000003; }
    }, APOLLO_17 {
        @Override
        public double toEarth(double value) { return value * 0.000003; }
        @Override
        public double fromEarth(double earth) { return earth / 0.000003; }
    },
    GEMINI_12 {
        @Override
        public double toEarth(double value) { return value * 0.000002; }
        @Override
        public double fromEarth(double earth) { return earth / 0.000002; }
    }, SOYUZ_19 {
        @Override
        public double toEarth(double value) { return value * 0.000002; }
        @Override
        public double fromEarth(double earth) { return earth / 0.000002; }
    }, VOYAGER_1 {
        @Override
        public double toEarth(double value) { return value * 0.000003; }
        @Override
        public double fromEarth(double earth) { return earth / 0.000003; }
    }, VOYAGER_2 {
        @Override
        public double toEarth(double value) { return value * 0.000003; }
        @Override
        public double fromEarth(double earth) { return earth / 0.000003; }
    },
    // Moons
    MOON {
        @Override
        public double toEarth(double value) {
            return value * 0.273;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.273;
        }
    }, IO {
        @Override
        public double toEarth(double value) { return value * 1.77; }
        @Override
        public double fromEarth(double earth) { return earth / 1.77; }
    }, PHOEBE {
        @Override
        public double toEarth(double value) { return value * 0.55; }
        @Override
        public double fromEarth(double earth) { return earth / 0.55; }
    }, EUROPA {
        @Override
        public double toEarth(double value) { return value * 3.55; }
        @Override
        public double fromEarth(double earth) { return earth / 3.55; }
    }, GANYMEDE {
        @Override
        public double toEarth(double value) { return value * 7.15; }
        @Override
        public double fromEarth(double earth) { return earth / 7.15; }
    }, CALLISTO {
        @Override
        public double toEarth(double value) { return value * 16.69; }
        @Override
        public double fromEarth(double earth) { return earth / 16.69; }
    }, TITAN {
        @Override
        public double toEarth(double value) { return value * 15.55; }
        @Override
        public double fromEarth(double earth) { return earth / 15.55; }
    }, RHEA {
        @Override
        public double toEarth(double value) { return value * 4.27; }
        @Override
        public double fromEarth(double earth) { return earth / 4.27; }
    },
    ENCELADUS {
        @Override
        public double toEarth(double value) { return value * 1.37; }
        @Override
        public double fromEarth(double earth) { return earth / 1.37; }
    }, TRITON {
        @Override
        public double toEarth(double value) { return value * 5.88; }
        @Override
        public double fromEarth(double earth) { return earth / 5.88; }
    }, CHARON {
        @Override
        public double toEarth(double value) { return value * 6.38; }
        @Override
        public double fromEarth(double earth) { return earth / 6.38; }
    }, IAPETUS {
        @Override
        public double toEarth(double value) { return value * 8.22; }
        @Override
        public double fromEarth(double earth) { return earth / 8.22; }
    }, DIONE {
        @Override
        public double toEarth(double value) { return value * 2.78; }
        @Override
        public double fromEarth(double earth) { return earth / 2.78; }
    }, OBERON {
        @Override
        public double toEarth(double value) { return value * 13.46; }
        @Override
        public double fromEarth(double earth) { return earth / 13.46; }
    }
    ;

    public static CelestialType fromString(String planet) {
        switch (planet) {
            case "Earth": return EARTH;
            case "Mercury": return MERCURY;
            case "Venus": return VENUS;
            case "Mars": return MARS;
            case "Jupiter": return JUPITER;
            case "Saturn": return SATURN;
            case "Uranus": return URANUS;
            case "Neptune": return NEPTUNE;
            case "Pluto": return PLUTO;
            case "Death Star": return DEATH_STAR;
            case "ISS": return ISS;
            case "Ceres": return CERES;
            case "Haumea": return HAUMEA;
            case "Makemake": return MAKEMAKE;
            case "Eris": return ERIS;
            case "Sun": return SUN;
            case "Moon": return MOON;
            case "Sirius": return SIRIUS;
            case "Apollo 11": return APOLLO_11;
            case "Millennium Falcon": return MILLENNIUM_FALCON;
            case "Io": return IO;
            case "Europa": return EUROPA;
            case "Ganymede": return GANYMEDE;
            case "Callisto": return CALLISTO;
            case "Titan": return TITAN;
            case "Enceladus": return ENCELADUS;
            case "Triton": return TRITON;
            case "Charon": return CHARON;
            case "Rhea": return RHEA;
            case "Iapetus": return IAPETUS;
            case "Dione": return DIONE;
            case "Phoebe": return PHOEBE;
            case "Oberon": return OBERON;
            case "Betelgeuse": return BETELGEUSE;
            case "Vega": return VEGA;
            case "Arcturus": return ARCTURUS;
            case "Rigel": return RIGEL;
            case "Pollux": return POLLUX;
            case "Antares": return ANTARES;
            case "Fomalhaut": return FOMALHAUT;
            case "Deneb": return DENEB;
            case "Apollo 13": return APOLLO_13;
            case "Apollo 17": return APOLLO_17;
            case "Gemini 12": return GEMINI_12;
            case "Soyuz 19": return SOYUZ_19;
            case "International Space Station (ISS)": return ISS;
            case "Voyager 1": return VOYAGER_1;
            case "Voyager 2": return VOYAGER_2;
            default: throw new IllegalArgumentException("Unsupported planet selected: " + planet);
        }
    }

    public abstract double toEarth(double value);
    public abstract double fromEarth(double earth);

    public double convertTo(double value, CelestialType toUnit) {
        if (this == toUnit) return value;
        if (value < 0) throw new IllegalArgumentException("Celestial values cannot be negative");

        double earth = this.toEarth(value);
        return toUnit.fromEarth(earth);
    }
}
