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
import lotto.view.OutputView;

public class LottoManager {

  private final OutputView outputView;
  private final LottoMachine lottoMachine;
  private final LottoCalculator lottoCalculator;
  private final LottoEvaluator lottoEvaluator;
  private final InputHandler inputHandler;


  public LottoManager(OutputView outputView, LottoMachine lottoMachine,
      LottoCalculator lottoCalculator, LottoEvaluator lottoEvaluator, InputHandler inputHandler) {
    this.outputView = outputView;
    this.lottoMachine = lottoMachine;
    this.lottoCalculator = lottoCalculator;
    this.lottoEvaluator = lottoEvaluator;
    this.inputHandler = inputHandler;
  }

  public void run() {
    BigDecimal purchaseAmount = inputHandler.getPurchaseAmount();
    int ticketCount = lottoCalculator.calculateNumberOfTickets(purchaseAmount);
    List<Lotto> lottos = lottoMachine.generateLottoTickets(ticketCount);

    outputView.printLottos(lottos);

    WinningNumber winningNumber = inputHandler.getWinningNumber();
    BonusNumber bonusNumber = inputHandler.getBonusNumber(winningNumber);

    Result result = lottoEvaluator.evaluateLottoTickets(lottos, winningNumber, bonusNumber);
    BigDecimal profitRate = lottoCalculator.calculateProfitRate(result.calculateTotalPrize(),
        purchaseAmount);

    outputView.printResult(result, profitRate);
  }
}
