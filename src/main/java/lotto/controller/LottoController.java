package lotto.controller;

import lotto.model.UserLottoList;
import lotto.util.MoneyToLottoCountUtil;
import lotto.view.InputPrizeNumberView;
import lotto.view.UserLottoListView;

public class LottoController {

    private final InputMoneyController inputMoneyController;
    private final UserLottoListView userLottoListView;
    private final InputPrizeNumberView inputPrizeNumberView;

    public LottoController(final InputMoneyController inputMoneyController, UserLottoListView userLottoListView,
                           InputPrizeNumberView inputPrizeNumberView) {
        this.inputMoneyController = inputMoneyController;
        this.userLottoListView = userLottoListView;
        this.inputPrizeNumberView = inputPrizeNumberView;
    }

    public void run() {
        UserLottoList userLottoList = getUserLotto();

    }

    private UserLottoList getUserLotto() {
        int money = inputMoneyController.getMoney();
        int lottoCount = MoneyToLottoCountUtil.moneyToLottoCount(money);

        UserLottoList userLottoList = new UserLottoList(lottoCount);
        userLottoListView.printUserLottoList(userLottoList.getNumberList());

        return userLottoList;
    }

}
