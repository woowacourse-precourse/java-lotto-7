package lotto;

import lotto.controller.InputMoneyController;
import lotto.controller.InputPrizeNumberController;
import lotto.controller.LottoController;
import lotto.view.InputPrizeNumberView;
import lotto.view.PurchaseView;
import lotto.view.UserLottoListView;
import lotto.view.WinningDetailView;

public class Application {
    public static void main(String[] args) {

        PurchaseView purchaseView = new PurchaseView();
        InputMoneyController inputMoneyController = new InputMoneyController(purchaseView);

        UserLottoListView userLottoListView = new UserLottoListView();

        InputPrizeNumberView inputPrizeNumberView = new InputPrizeNumberView();
        InputPrizeNumberController inputPrizeNumberController = new InputPrizeNumberController(inputPrizeNumberView);
        WinningDetailView winningDetailView = new WinningDetailView();

        LottoController lottoController = new LottoController(inputMoneyController, userLottoListView,
                inputPrizeNumberController, winningDetailView);

        lottoController.run();
    }
}
