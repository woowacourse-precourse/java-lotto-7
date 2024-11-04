package lotto.controller;

import lotto.model.PrizeLotto;
import lotto.model.UserLottoList;
import lotto.model.WinningDetailComputer;
import lotto.model.WinningDetailList;
import lotto.model.WinningPriceStore;
import lotto.util.MoneyToLottoCountUtil;
import lotto.view.UserLottoListView;
import lotto.view.WinningDetailView;

public class LottoController {

    private final InputMoneyController inputMoneyController;
    private final UserLottoListView userLottoListView;
    private final InputPrizeNumberController inputPrizeNumberController;
    private final WinningDetailView winningDetailView;

    public LottoController(final InputMoneyController inputMoneyController, UserLottoListView userLottoListView,
                           InputPrizeNumberController inputPrizeNumberController, WinningDetailView winningDetailView) {
        this.inputMoneyController = inputMoneyController;
        this.userLottoListView = userLottoListView;
        this.inputPrizeNumberController = inputPrizeNumberController;
        this.winningDetailView = winningDetailView;
    }

    public void run() {
        UserLottoList userLottoList = getUserLotto();

        PrizeLotto prizeLotto = inputPrizeNumberController.getPrizeNumbers();

        WinningDetailComputer winningDetailComputer
                = new WinningDetailComputer(userLottoList.getLottoList(), prizeLotto, new WinningDetailList());
        winningDetailComputer.computeLottoList();
        long returnPercent = winningDetailComputer.getReturnPercent(userLottoList.getMoney());

        winningDetailView.addMessage();
        for (WinningPriceStore store : winningDetailComputer.getWinningDetailList()) {
            winningDetailView.addMatchDetail(store);
        }
        winningDetailView.addReturnPercent(returnPercent);
        winningDetailView.print();

    }

    private UserLottoList getUserLotto() {
        int money = inputMoneyController.getMoney();
        int lottoCount = MoneyToLottoCountUtil.moneyToLottoCount(money);

        UserLottoList userLottoList = new UserLottoList(lottoCount);
        userLottoListView.printUserLottoList(userLottoList.getNumberList());

        return userLottoList;
    }

}
