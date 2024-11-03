package lotto.controller;

import lotto.controller.dto.BonusNumberSaveRequest;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.PrizeResultResponse;
import lotto.controller.dto.WinningNumberSaveResponse;
import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.utils.LottoUtils;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoPurchaseResponse saveLottoAmountInput(String request) {
        LottoException.throwIllegalArgumentException(
            ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(request)
        );

        lottoService.saveLottoPurchase(request);
        return lottoService.createLottoNumbers();
    }

    public WinningNumberSaveResponse saveLottoWinningNumberInput(String request) {
        LottoException.throwIllegalArgumentException(
            ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(request)
        );

        return lottoService.saveWinningNumber(request);
    }

    public void saveBonusNumber(BonusNumberSaveRequest request) {
        LottoException.throwIllegalArgumentException(
            ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(request.bonusNumber())
        );

        lottoService.saveBonusNumber(request);
    }

    public PrizeResultResponse getPrizeResult(int index) {
        return lottoService.calculatePrizeResult(index);
    }
}
