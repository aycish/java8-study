package me.aycish.designpattern._01_creational_patterns._02_factorymethod.after;

import lombok.Getter;
import lombok.Setter;
import me.aycish.designpattern._01_creational_patterns._03_abstract_factory.after.Anchor;
import me.aycish.designpattern._01_creational_patterns._03_abstract_factory.after.Wheel;

@Getter
@Setter
public class Ship {
    String name;
    String logo;
    String color;

    Wheel wheel;
    Anchor anchor;
}