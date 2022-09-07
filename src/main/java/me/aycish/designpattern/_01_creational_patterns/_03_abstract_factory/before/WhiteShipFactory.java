package me.aycish.designpattern._01_creational_patterns._03_abstract_factory.before;

import me.aycish.designpattern._01_creational_patterns._02_factorymethod.after.DefaultShipFactory;
import me.aycish.designpattern._01_creational_patterns._02_factorymethod.after.Ship;
import me.aycish.designpattern._01_creational_patterns._02_factorymethod.after.WhiteShip;
import me.aycish.designpattern._01_creational_patterns._03_abstract_factory.after.ShipPartsFactory;

public class WhiteShipFactory extends DefaultShipFactory {
    private ShipPartsFactory shipPartsFactory;

    // 주입하는 PartFactory에 따라 기능 변경이 유연하게 되도록할 수 있음
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
