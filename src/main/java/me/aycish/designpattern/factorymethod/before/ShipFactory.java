package me.aycish.designpattern.factorymethod.before;

public class ShipFactory  {
    public static Ship orderShip(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 입력해주세요.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }

        prepareFor(name);

        Ship ship = new Ship();
        ship.setName(name);

        // Customizing for each ships
        if (name.equalsIgnoreCase("whiteship")) {
            ship.setLogo("ship");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setLogo("anchor");
        }

        //coloring
        if (name.equalsIgnoreCase("whiteship")) {
            ship.setColor("WHITE");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setColor("BLACK");
        }

        //notify
        sendEmailTo(email, ship);

        return ship;
    }

    private static void prepareFor(String name) {
        System.out.println(name + " 제작 준비 중");
    }

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 제작 완료..");
        System.out.println("->" + email + " 제작 완료 알림 발송");
    }
}
