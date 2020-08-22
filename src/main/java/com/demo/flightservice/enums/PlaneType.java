package com.demo.flightservice.enums;

/**
 * Plane types according their passenger capacity.
 *
 * @param CANADAIR 6 passengers
 * @param AIRBUS 12 passengers
 * @param BOEING 24 passengers
 */
public enum PlaneType {
    CANADAIR(6),
    AIRBUS(12),
    BOEING(24);

    private final int value;
    private PlaneType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
