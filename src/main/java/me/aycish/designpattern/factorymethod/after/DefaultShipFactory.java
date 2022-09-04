package me.aycish.designpattern.factorymethod.after;

public abstract class DefaultShipFactory implements ShipFactory {

    @Override
    public void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 입력해주세요.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }
    }

    @Override
    public void prepareFor(String name) {
        System.out.println(name + " 제작 준비 중");
    }

    @Override
   public void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 제작 완료..");
        System.out.println("->" + email + " 제작 완료 알림 발송");
    }
}
