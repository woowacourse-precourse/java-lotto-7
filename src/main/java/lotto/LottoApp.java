package lotto;

import java.util.List;
import lotto.app.dto.LottoPurchaseResponseDto;
import lotto.app.dto.LottoResultDto;
import lotto.ui.LottoController;

public class LottoApp {

    private final LottoController lottoController;

    public LottoApp(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void run() {
        LottoPurchaseResponseDto purchaseDto = purchaseLotto();
        List<LottoResultDto> lottoResultDto = lottoController.getResult(purchaseDto.lottoList());
        lottoController.getInvestment(purchaseDto.price(), lottoResultDto);
    }

    private LottoPurchaseResponseDto purchaseLotto() {
        return lottoController.purchaseAll();
    }
}
