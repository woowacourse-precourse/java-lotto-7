package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import lotto.service.LottoCalculator;
import lotto.service.LottoEvaluator;
import lotto.service.LottoMachine;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import lotto.view.InputHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
  private final InputView inputView;
  private final OutputView outputView;
  private final LottoMachine lottoMachine;
  private final LottoCalculator lottoCalculator;
  private final LottoEvaluator lottoEvaluator;
  private final InputHandler inputHandler;

  public LottoManager() {
    this.inputView = new InputView();
    this.outputView = new OutputView();
    this.lottoMachine = new LottoMachine();
    this.lottoCalculator = new LottoCalculator();
    this.lottoEvaluator = new LottoEvaluator();
    this.inputHandler = new InputHandler(inputView);
  }

  public void run() {
    BigDecimal purchaseAmount = inputHandler.getPurchaseAmount();
    int ticketCount = lottoCalculator.calculateNumberOfTickets(purchaseAmount);
    List<Lotto> lottos = lottoMachine.generateLottoTickets(ticketCount);

    outputView.printLottoTickets(lottos);

    WinningNumber winningNumber = inputHandler.getWinningNumber();
    BonusNumber bonusNumber = inputHandler.getBonusNumber(winningNumber);

    Result result = lottoEvaluator.evaluateLottoTickets(lottos, winningNumber, bonusNumber);
    BigDecimal profitRate = lottoCalculator.calculateProfitRate(result.calculateTotalPrize(), purchaseAmount);

    outputView.printResult(result, profitRate);
  }
}
