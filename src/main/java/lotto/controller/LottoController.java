package lotto.controller;

import lotto.command.view.output.LottoProfitCommand;
import lotto.command.view.output.PurchasedLottoCommand;
import lotto.command.view.validate.ValidateCommand;
import lotto.dto.BonusUserInput;
import lotto.dto.MatchResults;
import lotto.dto.PurchaseAmountUserInput;
import lotto.dto.UserInput;
import lotto.dto.WinningLottoUserInput;
import lotto.model.amount.ProfitAmount;
import lotto.model.amount.ProfitRate;
import lotto.model.amount.PurchaseAmount;
import lotto.model.lotto.PurchasedLottos;
import lotto.model.lotto.WinningLotto;
import lotto.service.amount.AmountService;
import lotto.service.lotto.LottoService;
import lotto.view.View;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 2.
 */
public class LottoController {
  private final View view;
  private final LottoService lottoService;
  private final AmountService amountService;

  public LottoController(View view, LottoService lottoService, AmountService amountService) {
    this.view = view;
    this.lottoService = lottoService;
    this.amountService = amountService;
  }

  public void purchaseLotto () {
    PurchaseAmount purchaseAmount = getPurchaseAmount();
    PurchasedLottos purchasedLottos = getPurchasedLottos(purchaseAmount);

    displayPurchaseHistory(purchasedLottos);
    
    WinningLotto winningLotto = getWinningLotto();

    addBonusNumber(winningLotto);
    
    MatchResults matchResults = checkMatch(winningLotto, purchasedLottos);
    ProfitRate profitRate = retrieveProfitRate(purchaseAmount, matchResults);

    displayMatchResult(matchResults, profitRate);
  }

  private void displayPurchaseHistory(PurchasedLottos purchasedLottos) {
    view.displayOutput(PurchasedLottoCommand.from(purchasedLottos));
  }

  private void displayMatchResult(MatchResults matchResults, ProfitRate profitRate) {
    view.displayOutput(LottoProfitCommand.from(matchResults, profitRate));
  }


  private UserInput getUserInput (ValidateCommand command) {
    return (UserInput) view.promptInput(command);
  }

  private PurchaseAmount getPurchaseAmount () {
    PurchaseAmountUserInput userInput = (PurchaseAmountUserInput) getUserInput(amountService.getValidateCommand());
    return amountService.createPurchaseAmount(userInput);
  }
  
  private PurchasedLottos getPurchasedLottos (PurchaseAmount purchaseAmount) {
    int price = lottoService.getPrice();
    long count = amountService.getPurchasableCount(purchaseAmount, price);
    return lottoService.publishPurchaseLottos(count);
  }

  private WinningLotto getWinningLotto() {
    WinningLottoUserInput winningLottoUserInput = (WinningLottoUserInput) getUserInput(lottoService.getLottoCommand());
    return lottoService.createWinningLotto(winningLottoUserInput);
  }

  private WinningLotto addBonusNumber(WinningLotto winningLotto) {
    BonusUserInput bonusUserInput = (BonusUserInput) getUserInput(lottoService.getBonusCommand(winningLotto));
    return lottoService.addBonusNumber(winningLotto, bonusUserInput);
  }

  private MatchResults checkMatch(WinningLotto winningLotto, PurchasedLottos purchasedLottos) {
    return lottoService.matchWinningLotto(winningLotto, purchasedLottos);
  }

  private ProfitRate retrieveProfitRate(PurchaseAmount purchaseAmount, MatchResults matchResults) {
    ProfitAmount profitAmount = amountService.calculateProfitAmount(matchResults);
    return amountService.calculateProfitRate(purchaseAmount, profitAmount);
  }
}
