package me.aycish.designpattern._02_structural_patterns._07_bridge._02_after;

import me.aycish.designpattern._02_structural_patterns._07_bridge._01_before.Champion;

public abstract class App implements Champion {

    public static void main(String[] args) {
        Champion kdaAri = new Ari(new KDA());
        kdaAri.skillQ();
        kdaAri.skillW();

        Champion poolParty아리 = new Ari(new PoolParty());
        poolParty아리.skillR();
        poolParty아리.skillW();
    }
}
