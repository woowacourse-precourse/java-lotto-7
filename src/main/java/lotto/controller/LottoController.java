package lotto.controller;

import java.util.List;
import lotto.model.lotto.LottoStore;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView view;
    private final Long purchaseAmount;
    private final List<Integer> winningLottos;
    private final Integer bonusNumber;
    private final LottoStore lottoStore;

    public LottoController(LottoView view) {
        this.view = view;
        this.purchaseAmount = InputValidator.validatePurchaseAmount(view.inputPurchaseAmount());
        this.winningLottos = InputValidator.validateWinningLottos(view.inputLottos());
        this.bonusNumber = InputValidator.validateBonusNumber(view.inputBonus());
        this.lottoStore = new LottoStore(purchaseAmount);
    }

    public void run() {

    }
}
