package lotto.controller;

import lotto.controller.dto.*;
import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.utils.LottoUtils;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public int saveLottoAmountInput(int request) {
        return lottoService.saveLottoPurchase(request);
    }

    public LottoPurchaseResponse getLottoNumber() {
        return lottoService.createLottoNumbers();
    }

    public WinningNumberSaveResponse saveLottoWinningNumberInput(String request) {
        while (true) {
            try {
                LottoException.throwIllegalArgumentException(ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(request));
                return lottoService.saveWinningNumber(request);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveBonusNumber(BonusNumberSaveRequest request) {
        lottoService.saveBonusNumber(request);

    }

    public PrizeResultResponse getPrizeResult(int winningNumberIndex, int purchaseIndex) {
        List<PrizeResultDto> statistics = lottoService.calculatePrizeResult(winningNumberIndex);
        double rate = lottoService.calculateRate(statistics, purchaseIndex);

        return new PrizeResultResponse(statistics, rate);
    }
}
