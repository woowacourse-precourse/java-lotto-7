package lotto.controller;

import lotto.dto.LottoRequestDto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;


public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        LottoRequestDto lottoRequestDto = inputView.getLottoRequest();
        PurchaseAmountValidator.validate(lottoRequestDto.getPurchaseAmount());
        LottoNumbersValidator.validate(lottoRequestDto.getLottoNumbers());
        BonusNumberValidator.validate(lottoRequestDto.getBonusNumber(),
                lottoRequestDto.getLottoNumbers().split(","));

    }
}
