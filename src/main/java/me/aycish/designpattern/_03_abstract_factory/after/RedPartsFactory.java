package me.aycish.designpattern._03_abstract_factory.after;

public class RedPartsFactory implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        return new RedAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new RedWheel();
    }
}
