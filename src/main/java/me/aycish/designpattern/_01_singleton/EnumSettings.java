package me.aycish.designpattern._01_singleton;

import lombok.Getter;

@Getter
public enum EnumSettings {
    INSTANCE;

    private Integer number;

    public void setNumber(Integer number) {
        this.number = number;
    }
}
