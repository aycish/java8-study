package me.aycish.designpattern._01_creational_patterns._02_factorymethod.after;

public class WhiteShipFactory extends DefaultShipFactory {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
