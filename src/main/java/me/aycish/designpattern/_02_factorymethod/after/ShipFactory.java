package me.aycish.designpattern._02_factorymethod.after;

public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();
    /* interface내의 private 메서드는 자바 9부터 지원하므로 따로 default factory를 구현해준다. */
    void validate(String name, String email);
    void prepareFor(String name);
    void sendEmailTo(String email, Ship ship);
}
