package me.aycish.designpattern._03_abstract_factory.after;

public interface ShipPartsFactory {

    Anchor createAnchor();
    Wheel createWheel();
}
