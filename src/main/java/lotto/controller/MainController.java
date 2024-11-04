package lotto.controller;


import java.util.List;
import lotto.view.InputView;

public class MainController {
  final private LottoTransactionController lottoTransactionController;
  final private InputView inputView;

  public MainController() {

    this.lottoTransactionController = new LottoTransactionController();
    this.inputView = new InputView();
  }

  public void startLottoBusiness() {
    int amount = inputView.requestPurchaseAmount();
    lottoTransactionController.sellAutoLotto(amount);

    List<Integer> numbers = inputView.requestWinningNumbers();
    int bonus = inputView.requestBonusNumber();

    lottoTransactionController.compareWinningNumbers(numbers, bonus);

    lottoTransactionController.showLottoStatistics();
  }

}
