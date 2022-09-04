package me.aycish.designpattern._02_factorymethod.after;

public class WhiteShipFactory extends DefaultShipFactory {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
