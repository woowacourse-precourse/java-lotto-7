package lotto.controller;

import lotto.model.UserLottoList;
import lotto.util.MoneyToLottoCountUtil;
import lotto.view.UserLottoListView;

public class LottoController {

    private final InputController inputController;
    private final UserLottoListView userLottoListView;

    public LottoController(final InputController inputController, UserLottoListView userLottoListView) {
        this.inputController = inputController;
        this.userLottoListView = userLottoListView;
    }

    public void run() {
        UserLottoList userLottoList = getUserLotto();

    }

    private UserLottoList getUserLotto() {
        int money = inputController.getMoney();
        int lottoCount = MoneyToLottoCountUtil.moneyToLottoCount(money);

        UserLottoList userLottoList = new UserLottoList(lottoCount);
        userLottoListView.printUserLottoList(userLottoList.getNumberList());

        return userLottoList;
    }

}
