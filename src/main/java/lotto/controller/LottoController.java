package lotto.controller;

import lotto.model.PrizeLotto;
import lotto.model.UserLottoList;
import lotto.util.MoneyToLottoCountUtil;
import lotto.view.UserLottoListView;

public class LottoController {

    private final InputMoneyController inputMoneyController;
    private final UserLottoListView userLottoListView;
    private final InputPrizeNumberController inputPrizeNumberController;

    public LottoController(final InputMoneyController inputMoneyController, UserLottoListView userLottoListView,
                           InputPrizeNumberController inputPrizeNumberController) {
        this.inputMoneyController = inputMoneyController;
        this.userLottoListView = userLottoListView;
        this.inputPrizeNumberController = inputPrizeNumberController;
    }

    public void run() {
        UserLottoList userLottoList = getUserLotto();

        PrizeLotto prizeLotto = inputPrizeNumberController.getPrizeNumbers();

    }

    private UserLottoList getUserLotto() {
        int money = inputMoneyController.getMoney();
        int lottoCount = MoneyToLottoCountUtil.moneyToLottoCount(money);

        UserLottoList userLottoList = new UserLottoList(lottoCount);
        userLottoListView.printUserLottoList(userLottoList.getNumberList());

        return userLottoList;
    }

}
