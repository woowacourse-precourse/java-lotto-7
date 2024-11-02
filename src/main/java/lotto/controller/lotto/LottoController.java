package lotto.controller.lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
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
        String inputPurchaseAmount = lottoInputView.inputPurchaseAmount();
        lottoValidator.validatePurchaseAmount(inputPurchaseAmount);

        List<Lotto> lottoes = lottoService.createLottoes(Integer.parseInt(inputPurchaseAmount));
        lottoOutputView.printPurchaseResult(lottoes);
    }
}