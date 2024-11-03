package lotto.controller;

import lotto.model.UserLottoList;
import lotto.util.MoneyToLottoCountUtil;

public class LottoController {

    private final InputController inputController;

    public LottoController(final InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        int money = inputController.getMoney();
        int lottoCount = MoneyToLottoCountUtil.moneyToLottoCount(money);

        UserLottoList userLottoList = new UserLottoList(lottoCount);
    }
}
