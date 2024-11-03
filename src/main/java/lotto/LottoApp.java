package lotto;

import lotto.app.dto.LottoPurchaseResponseDto;
import lotto.ui.LottoController;

public class LottoApp {

    private final LottoController lottoController;

    public LottoApp(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void run() {
        LottoPurchaseResponseDto purchaseDto = purchaseLotto();
        lottoController.getResult(purchaseDto.lottoList());
    }

    private LottoPurchaseResponseDto purchaseLotto() {
        return lottoController.purchaseAll();
    }
}
