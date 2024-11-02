package lotto.controller;

import lotto.dto.LottoRequestDto;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.LottoConverter;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String purchaseAmount = inputView.getPurchaseAmount();
        PurchaseAmountValidator.validate(purchaseAmount);
        int userAmount = Integer.parseInt(purchaseAmount) / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < userAmount; i++) {
            lottos.add(LottoService.createLotto());
        }
        OutputView.printUserLottos(lottos, userAmount);

        String lottoNumbers = inputView.getLottoNumbers();
        String bonusNumber = inputView.getBonusNumber();
        LottoNumbersValidator.validate(lottoNumbers);
        BonusNumberValidator.validate(bonusNumber, lottoNumbers.split(","));

        LottoRequestDto lottoRequestDto = new LottoRequestDto(purchaseAmount, lottoNumbers, bonusNumber);
        LottoService lottoService = new LottoService(
                LottoConverter.parseLottoNumbers(lottoRequestDto.getLottoNumbers()),
                LottoConverter.parseBonusNumber(lottoRequestDto.getBonusNumber()));
    }
}
