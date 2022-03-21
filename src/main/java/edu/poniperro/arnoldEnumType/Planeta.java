package edu.poniperro.arnoldEnumType;

import java.util.EnumSet;

public enum Planeta {

    MERCURY(3.303e+23, 2.4397e+6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    public static final double G = 6.67400e-11;
    private double masa = 0f;
    private double radio = 0f;

    private Planeta (double masa, double radio){
    this.masa = masa;
    this.radio = radio;
    }
    public double getMasa() {
        return masa;
    }
    public double getRadio() {
        return radio;
    }
    public double pesoSuperficie(double peso) {
        return masaHumano(peso) * gravedad();
    }
    public double masaHumano(double peso) {
        return peso/gravedad(EARTH);
    }
    public double gravedad() {
        return (G*masa)/Math.pow(radio, 2);
    }
    public double gravedad(Planeta planeta) {
        return G* planeta.getMasa() / Math.pow(planeta.getRadio(), 2);
    }
    public static EnumSet<Planeta> getPlanetasTerrestres() {
        return EnumSet.range(MERCURY, MARS);
    }
    public static EnumSet<Planeta> getPlanetasGaseosos() {
        return EnumSet.complementOf(getPlanetasTerrestres());
    }
}

