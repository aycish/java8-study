package me.aycish.designpattern._02_factorymethod.after;

import lombok.Getter;
import lombok.Setter;
import me.aycish.designpattern._03_abstract_factory.before.WhiteAnchor;
import me.aycish.designpattern._03_abstract_factory.before.WhiteWheel;

@Getter
@Setter
public class Ship {
    String name;
    String logo;
    String color;

    WhiteWheel whiteWheel;
    WhiteAnchor whiteAnchor;
}
