package me.aycish.designpattern._03_abstract_factory.after;

import me.aycish.designpattern._03_abstract_factory.before.WhiteAnchor;
import me.aycish.designpattern._03_abstract_factory.before.WhiteWheel;

public class WhiteShipPratsFactory implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
