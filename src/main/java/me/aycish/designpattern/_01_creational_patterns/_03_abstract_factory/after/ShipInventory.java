package me.aycish.designpattern._01_creational_patterns._03_abstract_factory.after;


import me.aycish.designpattern._01_creational_patterns._03_abstract_factory.before.WhiteShipFactory;
import me.aycish.designpattern._01_creational_patterns._02_factorymethod.after.Ship;
import me.aycish.designpattern._01_creational_patterns._02_factorymethod.after.ShipFactory;

public class ShipInventory {
    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteShipFactory(new WhiteShipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());

        ShipFactory shipFactory2 = new WhiteShipFactory(new RedPartsFactory());
        Ship ship2 = shipFactory2.createShip();
        System.out.println(ship2.getAnchor().getClass());
        System.out.println(ship2.getWheel().getClass());
    }
}