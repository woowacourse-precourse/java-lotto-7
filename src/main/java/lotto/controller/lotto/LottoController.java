package lotto.controller.lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDto;
import lotto.domain.lotto.WinningStatisticsResponseDto;
import lotto.io.lotto.LottoInputView;
import lotto.io.lotto.LottoOutputView;
import lotto.service.lotto.LottoService;
import lotto.validator.lotto.LottoValidator;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoService lottoService;
    private final LottoValidator lottoValidator;


    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView, LottoService lottoService,
                           LottoValidator lottoValidator) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoService = lottoService;
        this.lottoValidator = lottoValidator;
    }

    public void startProgram() {
        LottoDto lottoDto = new LottoDto();

        String purchaseAmount = "";
        purchaseAmount = inputPurchaseAmount();
        //구매 개수 제한을 둘 필요있다.

        List<Lotto> lottoes = lottoService.createLottoes(Integer.parseInt(purchaseAmount));
        lottoOutputView.printPurchaseResult(lottoes);

        String winningNumbers = "";
        winningNumbers = inputWinningNumbers();
        lottoDto.updateWinningNumbers(winningNumbers);

        String bonusNumber = "";
        bonusNumber = inputBonusNumber();
        lottoDto.updateBonusNumber(bonusNumber);

        WinningStatisticsResponseDto winningStatisticsDto = lottoService.getWinningStatistics(lottoes, lottoDto);
        lottoOutputView.printWinningStatisticsResult(winningStatisticsDto);
    }

    private String inputPurchaseAmount() {
        String purchaseAmount = "";
        try {
            purchaseAmount = lottoInputView.inputPurchaseAmount();
            lottoValidator.validatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException error) {
            lottoOutputView.printErrorMessage(error.getMessage());
            inputPurchaseAmount();
        }
        return purchaseAmount;
    }

    private String inputWinningNumbers() {
        String winningNumbers = "";
        try {
            winningNumbers = lottoInputView.inputWinningNumbers();
            lottoValidator.validateWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException error) {
            lottoOutputView.printEnterAndMessage(error.getMessage());
            inputWinningNumbers();
        }
        return winningNumbers;
    }

    private String inputBonusNumber() {
        String bonusNumber = "";
        try {
            bonusNumber = lottoInputView.inputBonusNumber();
        } catch (IllegalArgumentException error) {
            lottoOutputView.printEnterAndMessage(error.getMessage());
            inputBonusNumber();
        }
        return bonusNumber;
    }
}