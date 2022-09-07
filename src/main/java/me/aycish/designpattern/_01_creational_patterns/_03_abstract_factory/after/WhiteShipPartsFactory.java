package me.aycish.designpattern._01_creational_patterns._03_abstract_factory.after;

import me.aycish.designpattern._01_creational_patterns._03_abstract_factory.before.WhiteAnchor;
import me.aycish.designpattern._01_creational_patterns._03_abstract_factory.before.WhiteWheel;

public class WhiteShipPartsFactory implements ShipPartsFactory {
    public WhiteShipPartsFactory() {
    }

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
