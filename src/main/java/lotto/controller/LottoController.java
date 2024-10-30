package lotto.controller;

import static lotto.validator.AmountValidator.isNumber;

import lotto.view.View;

public class LottoController {
    View view;

    public LottoController(View view) {
        this.view = view;
    }


    public void run() {
        int amount = isNumber(view.getUserInput());
    }
}
