package me.aycish.designpattern.factorymethod.after;

public class Client {
    
    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteship = new WhiteShipFactory().orderShip("Whiteship", "jounhee@mail.com");
        System.out.println(whiteship);

        Ship blackship = new BlackShipFactory().orderShip("Blackship", "jounhee@mail.com");
        System.out.println(blackship);
    }
}
