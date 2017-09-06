package com.me.pattern.di.tightly;

/**
 *
 * @author tunm2
 */
public class Traveler {
    
    private Car car = new Car();
    
    public void startJourney() {
        car.move();
    }
}