package me.aycish.designpattern._01_creational_patterns._02_factorymethod.before;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteship = ShipFactory.orderShip("Whiteship", "jounhee@mail.com");
        System.out.println(whiteship);

        Ship blackship = ShipFactory.orderShip("Blackship", "jounhee@mail.com");
        System.out.println(blackship);
    }
}