package me.aycish.designpattern._03_abstract_factory.before;

import me.aycish.designpattern._02_factorymethod.after.DefaultShipFactory;
import me.aycish.designpattern._02_factorymethod.after.Ship;
import me.aycish.designpattern._02_factorymethod.after.WhiteShip;

public class WhiteShipFactory extends DefaultShipFactory {
    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(new WhiteAnchor());
        ship.setWheel(new WhiteWheel());
        return ship;
    }
}
