package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottosServiceInterface;
import lotto.validator.InputValidatorInterface;
import lotto.view.InputViewInterface;
import lotto.view.OutputViewInterface;

public class LottoController {

  private final InputViewInterface inputView;
  private final OutputViewInterface outputView;
  private final LottosServiceInterface lottoService;
  private final InputValidatorInterface inputValidator;
  private List<Lotto> lottos;

  public LottoController(InputViewInterface inputView, OutputViewInterface outputView,
      LottosServiceInterface lottoService, InputValidatorInterface inputValidator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.lottoService = lottoService;
    this.inputValidator = inputValidator;
  }

  public void run() {

    // 금액 받기 및 구매 개수 출력
    String purchaseAmountInput = inputView.readPurchaseAmount();
    int validatedPurchaseAmount = inputValidator.validatePurchaseAmount(purchaseAmountInput);
    outputView.printPurchaseCount(validatedPurchaseAmount);

    // 로또 리스트 생성 및 출력
    lottos = lottoService.generateLottosByAmount(validatedPurchaseAmount);
    outputView.printGeneratedLottos(lottos);

    // 당첨 번호 입력 및 검증
    String winningNumbersInput = inputView.readWinningNumbers();
    List<Integer> validatedWinningNumbers = inputValidator.validateWinningNumbers(
        winningNumbersInput);

    // 보너스 번호 입력 및 검증
    String bonusNumberInput = inputView.readBonusNumber();
    int validatedBonusNumber = inputValidator.validateBonusNumber(bonusNumberInput,
        validatedWinningNumbers);

    // 당첨 개수 계산 및 출력
    List<Integer> winningCounts = lottoService.checkWinningNumbers(lottos, validatedWinningNumbers, validatedBonusNumber);
    outputView.printWinningResults(winningCounts);

    // 수익률 계산 및 출력
    double yield = lottoService.calculateYield(winningCounts, validatedPurchaseAmount);
    outputView.printYield(yield);

  }

}
