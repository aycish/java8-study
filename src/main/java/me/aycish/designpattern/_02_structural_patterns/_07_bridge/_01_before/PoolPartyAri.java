package me.aycish.designpattern._02_structural_patterns._07_bridge._01_before;

public class PoolPartyAri implements Champion {
    @Override
    public void move() {
        System.out.println("Pool Party skill move");
    }

    @Override
    public void skillQ() {
        System.out.println("Pool Party skill Q");
    }

    @Override
    public void skillW() {
        System.out.println("Pool Party skill W");
    }

    @Override
    public void skillE() {
        System.out.println("Pool Party skill E");
    }

    @Override
    public void skillR() {
        System.out.println("Pool Party skill R");
    }

    @Override
    public String getName() {
        return "Pool Party Ari";
    }
}
