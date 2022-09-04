package me.aycish.designpattern._02_factorymethod.after;

public class BlackShipFactory extends DefaultShipFactory{
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
