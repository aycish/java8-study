package me.aycish.designpattern.singleton;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum EnumSettings {
    INSTANCE;

    private Integer number;

    public void setNumber(Integer number) {
        this.number = number;
    }
}
