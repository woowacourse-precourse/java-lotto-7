package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.LottoPurchaseResponse;
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

    public void saveLottoWinningNumberInput(String request) {
        LottoException.throwIllegalArgumentException(
            ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(request)
        );

        lottoService.saveWinningNumber(request);
    }
}
