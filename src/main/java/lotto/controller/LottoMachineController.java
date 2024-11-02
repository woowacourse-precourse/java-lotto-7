package lotto.controller;

import java.util.List;
import lotto.enums.WinningType;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.TotalPrice;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {
  private Lottos lottos;
  private Money money;
  private TotalPrice totalPrice;
  private WinningNumbers winningNumbers;
  private WinningStatistic winningStatistic;
  private final InputView inputView;
  private final OutputView outputView;

  public LottoMachineController() {
    this.inputView = new InputView();
    this.outputView = new OutputView();
  }

  public void runLottoMachine() {
    tryReadMoney();
    int buyedLottosQuantity = getLottosQuantity();
    printQuantityOfLottos(buyedLottosQuantity);
    tryMakeLotto(buyedLottosQuantity);
    printAllLottos(lottos.allLottosToString());
    tryReadBonusAndWinningNumbers();
    List<WinningType> winningResults = getWinningStatistic(winningNumbers, lottos);
    printStatistic(winningResults);
    double returnRate = getReturnRate(winningResults);
    printReturnRate(returnRate, winningResults);
  }

  private void tryReadMoney() {
    try {
      String inputMoney = inputView.readMoney();
      this.money = new Money(inputMoney);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      tryReadMoney();
    }
  }

  private int getLottosQuantity() {
    return money.buyedLottosQuantity();
  }

  private void printQuantityOfLottos(int buyedLottosQuantity) {
    outputView.printQuantityOfLottos(buyedLottosQuantity);
  }

  private void tryMakeLotto(int buyedLottosQuantity) {
    try {
      lottos = Lottos.createLottos(buyedLottosQuantity);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      tryMakeLotto(buyedLottosQuantity);
    }
  }

  private void printAllLottos(String allLottos) {
    outputView.printAllLottos(allLottos);
  }

  private void tryReadBonusAndWinningNumbers() {
    try {
      String inputWinningNumbers = inputView.readWinningNumbers();
      String inputBonusNumber = inputView.readBonusNumber();
      this.winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      tryReadBonusAndWinningNumbers();
    }
  }

  private List<WinningType> getWinningStatistic(WinningNumbers winningNumbers, Lottos lottos) {
    winningStatistic = WinningStatistic.createWinningStatistic(winningNumbers, lottos);

    return winningStatistic.getWinningStatistic();
  }

  private double getReturnRate(List<WinningType> winningResults) {
    totalPrice = TotalPrice.sumAllPrice(winningResults);

    return totalPrice.calculateReturnRate(money);
  }

  private void printStatistic(List<WinningType> winningResults) {
    outputView.printStatistic(winningResults);
  }

  private void printReturnRate(double returnRate, List<WinningType> winningResults) {
    outputView.printReturnRate(returnRate, winningResults);
  }
}
