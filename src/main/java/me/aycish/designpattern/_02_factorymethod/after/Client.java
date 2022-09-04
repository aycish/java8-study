package me.aycish.designpattern._02_factorymethod.after;

public class Client {
    
    public static void main(String[] args) {
        Client client = new Client();


        /*
        Ship whiteship = new WhiteShipFactory().orderShip("Whiteship", "jounhee@mail.com");
        System.out.println(whiteship);

        Ship blackship = new BlackShipFactory().orderShip("Blackship", "jounhee@mail.com");
        System.out.println(blackship);
        */

        // 배의 종류가 추가될 때 마다 클라이언트 코드는 바뀔 수 있으므로 일종의 DI를 통해 해결해보자.
        client.print(new WhiteShipFactory(), "Whiteship", "jounhee@mail.com");
        client.print(new BlackShipFactory(), "Blackship", "jounhee@mail.com");
    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name,email));
    }
}
