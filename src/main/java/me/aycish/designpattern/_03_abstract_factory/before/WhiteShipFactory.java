package me.aycish.designpattern._03_abstract_factory.before;

import me.aycish.designpattern._02_factorymethod.after.DefaultShipFactory;
import me.aycish.designpattern._02_factorymethod.after.Ship;
import me.aycish.designpattern._02_factorymethod.after.WhiteShip;
import me.aycish.designpattern._03_abstract_factory.after.ShipPartsFactory;

public class WhiteShipFactory extends DefaultShipFactory {
    private ShipPartsFactory shipPartsFactory;

    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }
    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
