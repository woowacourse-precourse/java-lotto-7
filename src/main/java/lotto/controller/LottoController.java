package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.service.LottosServiceInterface;
import lotto.validator.InputValidator;
import lotto.validator.InputValidatorInterface;
import lotto.view.InputView;
import lotto.view.InputViewInterface;
import lotto.view.OutputView;
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

    // 금액 받기
    String purchaseAmountInput = inputView.readPurchaseAmount();
    int validatedPurchaseAmount = inputValidator.validatePurchaseAmount(purchaseAmountInput);

    // 로또 리스트 생성
    lottos = lottoService.generateLottosByAmount(validatedPurchaseAmount);

    // 당첨 번호 입력 및 검증
    String winningNumbersInput = inputView.readWinningNumbers();
    List<Integer> validatedWinningNumbers = inputValidator.validateWinningNumbers(
        winningNumbersInput);

    // 보너스 번호 입력 및 검증
    String bonusNumberInput = inputView.readBonusNumber();
    int validatedBonusNumber = inputValidator.validateBonusNumber(bonusNumberInput,
        validatedWinningNumbers);

    // 당첨 개수 계산 및 수익률 계산
    List<Integer> winningCounts = lottoService.checkWinningNumbers(lottos, validatedWinningNumbers, validatedBonusNumber);
    double yield = lottoService.calculateYield(winningCounts, validatedPurchaseAmount);

  }

}
