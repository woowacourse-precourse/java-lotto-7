package lotto.controller;

import lotto.model.UserLottoList;

public class LottoController {

    private final InputController inputController;

    public LottoController(final InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        int money = inputController.getMoney();

        UserLottoList userLottoList = new UserLottoList(money);
    }
}
