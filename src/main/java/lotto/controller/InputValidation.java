package lotto.controller;

import lotto.view.View;

public class InputValidation {
    private static View view;

    public InputValidation() {
        view = new View();
    }



    public Long moneyCheck() {
        while (true) {
            try {
                return getValidatedMoney(); // 올바른 입력일 때 반환
            } catch (Exception e) {
                System.out.println(e.getMessage()); // 모든 예외를 한 번에 처리
            }
        }
    }

    private Long getValidatedMoney() {
        String moneyInput = view.getMoneyInput();
        checkInputNull(moneyInput);
        Long money = Long.parseLong(moneyInput);
        checkUnitOfMoney(money);
        return money;
    }


    private void checkInputNull(String input) {
        if (input.isEmpty()){
            throw new NullPointerException("[ERROR] 금액을 비워둘 수 없습니다");
        }
    }

    private void checkUnitOfMoney(Long input) {
        if (input == 0 || !(input%1000==0)){
            throw new IllegalArgumentException("[ERROR] 금액은 0원이 될 수 없고, 1000원 단위로만 입력 가능합니다.");
        }
    }



}
