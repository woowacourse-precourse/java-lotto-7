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
        String inputPurchaseAmount = lottoInputView.inputPurchaseAmount();
        lottoValidator.validatePurchaseAmount(inputPurchaseAmount);
        //dto에 세팅
        //구맥 개수 제한이 필요하다.

        List<Lotto> lottoes = lottoService.createLottoes(Integer.parseInt(inputPurchaseAmount));
        lottoOutputView.printPurchaseResult(lottoes);

        String inputWinningNumbers = lottoInputView.inputWinningNumbers();
        lottoValidator.validateWinningNumbers(inputWinningNumbers);
        lottoDto.updateWinningNumbers(inputWinningNumbers);
        //dto에 세팅

        String inputBonusNumber = lottoInputView.inputBonusNumber();
        lottoValidator.validateBonusNumber(lottoDto.getWinningNumbers(), inputBonusNumber);
        lottoDto.updateBonusNumber(inputBonusNumber);
        //dto에 세팅

        WinningStatisticsResponseDto winningStatisticsDto = lottoService.getWinningStatistics(lottoes, lottoDto);
        lottoOutputView.printWinningStatisticsResult(winningStatisticsDto);
    }
}