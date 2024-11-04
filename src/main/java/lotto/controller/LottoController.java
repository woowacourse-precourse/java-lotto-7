package lotto.controller;

import java.util.List;
import lotto.constants.LottoErrorMessages;
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

  public LottoController(InputViewInterface inputView, OutputViewInterface outputView,
      LottosServiceInterface lottoService, InputValidatorInterface inputValidator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.lottoService = lottoService;
    this.inputValidator = inputValidator;
  }

  public void run() {

    // 금액 받기 및 구매 개수 출력
    int purchaseAmount = getValidatedPurchaseAmount();
    int numOfLottos = lottoService.getNumOfLottos(purchaseAmount);

    outputView.printPurchaseCount(numOfLottos);

    // 로또 리스트 생성 및 출력
    List<Lotto> lottos = lottoService.generateLottosByAmount(numOfLottos);
    outputView.printGeneratedLottos(lottos);

    // 당첨 번호 입력 및 검증
    List<Integer> winningNumbers = getValidatedWinningNumbers();

    // 보너스 번호 입력 및 검증
    int bonusNumber = getValidatedBonusNumber(winningNumbers);

    // 당첨 개수 계산 및 출력
    List<Integer> winningCounts = lottoService.checkWinningNumbers(lottos, winningNumbers, bonusNumber);
    outputView.printWinningResults(winningCounts);

    // 수익률 계산 및 출력
    double yield = lottoService.calculateYield(winningCounts, purchaseAmount);
    outputView.printYield(yield);

  }

  private int getValidatedPurchaseAmount() {
    while (true) {
      try {
        String purchaseAmountInput = inputView.readPurchaseAmount();
        return inputValidator.validatePurchaseAmount(purchaseAmountInput);
      } catch (IllegalArgumentException e) {
        System.out.println(LottoErrorMessages.INVALID_PURCHASE_AMOUNT);
      }
    }
  }

  private List<Integer> getValidatedWinningNumbers() {
    while (true) {
      try {
        String winningNumbersInput = inputView.readWinningNumbers();
        return inputValidator.validateWinningNumbers(winningNumbersInput);
      } catch (IllegalArgumentException e) {
        System.out.println(LottoErrorMessages.INVALID_WINNING_NUMBER);
      }
    }
  }

  private int getValidatedBonusNumber(List<Integer> validatedWinningNumbers) {
    while (true) {
      try {
        String bonusNumberInput = inputView.readBonusNumber();
        return inputValidator.validateBonusNumber(bonusNumberInput, validatedWinningNumbers);
      } catch (IllegalArgumentException e) {
        System.out.println(LottoErrorMessages.INVALID_BONUS_NUMBER);
      }
    }
  }
}
