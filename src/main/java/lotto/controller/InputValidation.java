package lotto.controller;

import lotto.view.View;

public class InputValidation {
    private static View view;

    public InputValidation() {
        view = new View();
    }

    public Long moneyCheck() {
        String moneyInput = view.getMoneyInput();
        checkInputNull(moneyInput);

        Long money = Long.parseLong(moneyInput);
        return money;

    }

    private void checkInputNull(String input) {
        if (input.isEmpty()){
            throw new NullPointerException("[ERROR] 금액을 비워둘 수 없습니다");
        }
    }

    

}
