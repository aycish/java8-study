package me.aycish.designpattern.factorymethod.after;

public class BlackShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
