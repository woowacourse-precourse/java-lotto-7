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

    this.money = new Money(inputView.readMoney());

    int buyedLottosQuantity = money.buyedLottosQuantity();

    outputView.printQuantityOfLottos(buyedLottosQuantity);

    lottos = Lottos.createLottos(buyedLottosQuantity);

    String allLottos = lottos.allLottosToString();
    outputView.printAllLottos(allLottos);

    String inputWinningNumbers = inputView.readWinningNumbers();
    String inputBonusNumber = inputView.readBonusNumber();

    this.winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
    
    winningStatistic = WinningStatistic.createWinningStatistic(winningNumbers, lottos);

    List<WinningType> winningStatistic1 = winningStatistic.getWinningStatistic();

    totalPrice = TotalPrice.sumAllPrice(winningStatistic1);

    double returnRate = totalPrice.calculateReturnRate(money);

    outputView.printStatistic(winningStatistic1);
    outputView.printReturnRate(returnRate);
  }
}
