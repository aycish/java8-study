package me.aycish.designpattern._02_structural_patterns._07_bridge._01_before;

public class App {

    public static void main(String[] args) {
        Champion poolPartyAri = new PoolPartyAri();
        poolPartyAri.move();
        poolPartyAri.skillQ();
    }
}
