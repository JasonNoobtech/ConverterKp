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
            return value * 0.382;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.382;
        }
    }, VENUS {
        @Override
        public double toEarth(double value) {
            return value * 0.949;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.949;
        }
    }, MARS {
        @Override
        public double toEarth(double value) {
            return value * 0.532;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.532;
        }
    }, JUPITER {
        @Override
        public double toEarth(double value) {
            return value * 11.21;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 11.21;
        }
    }, SATURN {
        @Override
        public double toEarth(double value) {
            return value * 9.45;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 9.45;
        }
    }, URANUS {
        @Override
        public double toEarth(double value) {
            return value * 4.01;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 4.01;
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
            return value * 0.113;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.113;
        }
    }, ERIS {
        @Override
        public double toEarth(double value) {
            return value * 0.183;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.183;
        }
    },
    // Stars
    SUN {
        @Override
        public double toEarth(double value) {
            return value * 109.1;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 109.1;
        }
    }, SIRIUS {
        @Override
        public double toEarth(double value) { return value * 1.71; }
        @Override
        public double fromEarth(double earth) { return earth / 1.71; }
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
    }, REGULUS {
        @Override
        public double toEarth(double value) { return value * 78.9; }
        @Override
        public double fromEarth(double earth) { return earth / 78.9; }
    }, SPICA {
        @Override
        public double toEarth(double value) { return value * 2.36; }
        @Override
        public double fromEarth(double earth) { return earth / 2.36; }
    }, CASTOR {
        @Override
        public double toEarth(double value) { return value * 1.08; }
        @Override
        public double fromEarth(double earth) { return earth / 1.08; }
    }, PROCYON {
        @Override
        public double toEarth(double value) { return value * 11.4; }
        @Override
        public double fromEarth(double earth) { return earth / 11.4; }
    }, STEPHENSON_2_18 {
        @Override
        public double toEarth(double value) { return value * 2150; }
        @Override
        public double fromEarth(double earth) { return earth / 2150; }
    },
    UY_SCUTI {
        @Override
        public double toEarth(double value) { return value * 1708; }
        @Override
        public double fromEarth(double earth) { return earth / 1708; }
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
            return value * 0.272;
        }
        @Override
        public double fromEarth(double earth) {
            return earth / 0.272;
        }
    }, IO {
        @Override
        public double toEarth(double value) { return value * 0.286; }
        @Override
        public double fromEarth(double earth) { return earth / 0.286; }
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
    },
    // Black Holes
    SAGITTARIUS_A_STAR {
        @Override
        public double toEarth(double value) { return value * 5.2e7; }
        @Override
        public double fromEarth(double earth) { return earth / 5.2e7; }
    }, M87_BLACK_HOLE {
        @Override
        public double toEarth(double value) { return value * 1.2e10; }
        @Override
        public double fromEarth(double earth) { return earth / 1.2e10; }
    }, CYGNUS_X1 {
        @Override
        public double toEarth(double value) { return value * 60; }
        @Override
        public double fromEarth(double earth) { return earth / 60; }
    }, TON_618 {
        @Override
        public double toEarth(double value) { return value * 1.3e11; }
        @Override
        public double fromEarth(double earth) { return earth / 1.3e11; }
    };

    public static CelestialType fromString(String celestialBody) {
        switch (celestialBody) {
            case "Earths": return EARTH;
            case "Mercuries": return MERCURY;
            case "Venuses": return VENUS;
            case "Marses": return MARS;
            case "Jupiters": return JUPITER;
            case "Saturns": return SATURN;
            case "Uranuses": return URANUS;
            case "Neptunes": return NEPTUNE;
            case "Plutos": return PLUTO;
            case "Cereses": return CERES;
            case "Haumeas": return HAUMEA;
            case "Makemakes": return MAKEMAKE;
            case "Erises": return ERIS;
            case "Suns": return SUN;
            case "Siriuses": return SIRIUS;
            case "Betelgeuses": return BETELGEUSE;
            case "Vegas": return VEGA;
            case "Arcturuses": return ARCTURUS;
            case "Rigels": return RIGEL;
            case "Polluxes": return POLLUX;
            case "Antareses": return ANTARES;
            case "Fomalhauts": return FOMALHAUT;
            case "Denebs": return DENEB;
            case "Death Stars": return DEATH_STAR;
            case "Apollo 11s": return APOLLO_11;
            case "Apollo 13s": return APOLLO_13;
            case "Apollo 17s": return APOLLO_17;
            case "Gemini 12s": return GEMINI_12;
            case "Soyuz 19s": return SOYUZ_19;
            case "Millennium Falcons": return MILLENNIUM_FALCON;
            case "Voyager 1s": return VOYAGER_1;
            case "Voyager 2s": return VOYAGER_2;
            case "Moons": return MOON;
            case "Ios": return IO;
            case "Europas": return EUROPA;
            case "Ganymedes": return GANYMEDE;
            case "Callistos": return CALLISTO;
            case "Titans": return TITAN;
            case "Tritons": return TRITON;
            case "Charons": return CHARON;
            case "Rheas": return RHEA;
            case "Oberons": return OBERON;
            case "Enceladus": return ENCELADUS;
            case "Iapetus": return IAPETUS;
            case "Diones": return DIONE;
            case "Phoebes": return PHOEBE;
            case "Sagittarius As": return SAGITTARIUS_A_STAR;
            case "M87 Black Holes": return M87_BLACK_HOLE;
            case "Cygnus X1s": return CYGNUS_X1;
            case "Ton 618s": return TON_618;
            case "International Space Stations (ISS)": return ISS;
            case "Procyons": return PROCYON;
            case "Reguluses": return REGULUS;
            case "Spicas": return SPICA;
            case "Castors": return CASTOR;
            case "Stephenson 2-18s": return STEPHENSON_2_18;
            case "Uy Scutis": return UY_SCUTI;
            default: throw new IllegalArgumentException("Unsupported type selected: " + celestialBody);
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
