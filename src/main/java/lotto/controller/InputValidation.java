package lotto.controller;

import lotto.view.View;

public class InputValidation {
    private static View view;

    public InputValidation() {
        view = new View();
    }

    public Long getValidatedMoney() {
        while (true) {
            try {
                return moneyCheck(); // 올바른 입력일 때 반환
            } catch (Exception e) {
                System.out.println(e.getMessage()); // 모든 예외를 한 번에 처리
            }
        }
    }

    public Long moneyCheck() {
        String moneyInput = view.getMoneyInput();
        checkInputNull(moneyInput);
        checkMoneyForm(moneyInput);
        Long money = Long.parseLong(moneyInput);
        checkUnitOfMoney(money);
        return money;
    }

    public void checkInputNull(String input) {
        if (input.isEmpty()){
            throw new NullPointerException("[ERROR] 금액을 비워둘 수 없습니다");
        }
    }

    public void checkUnitOfMoney(Long input) {
        if (input == 0 || !(input%1000==0)){
            throw new IllegalArgumentException("[ERROR] 금액은 0원이 될 수 없고, 1000원 단위로만 입력 가능합니다.");
        }
    }

    public void checkMoneyForm(String input) {
        if (!input.matches("\\d+")) { // 숫자로만 이루어졌는지 확인
            throw new IllegalArgumentException("[ERROR] 금액은 숫자(양수)만 입력 가능합니다.");
        }
    }


}
