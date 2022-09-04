package me.aycish.designpattern.factorymethod.after;

public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();
    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 입력해주세요.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }
    }

    private static void prepareFor(String name) {
        System.out.println(name + " 제작 준비 중");
    }

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 제작 완료..");
        System.out.println("->" + email + " 제작 완료 알림 발송");
    }
}
