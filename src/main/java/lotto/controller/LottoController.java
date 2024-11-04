package lotto.controller;

import java.util.List;
import lotto.common.LottoRank;
import lotto.service.LottoService;
import lotto.view.ConsoleLottoView;
import lotto.view.LottoView;

public class LottoController {
    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, ConsoleLottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void run() {
        purchaseLotto();
        lottoView.displayLottoNumbers(lottoService.getPurchaseDto());

        assignWinningNumbers();
        assignBonusNumber();

        List<LottoRank> lottoRanks = lottoService.calculateLottoRank();
        lottoView.displayLottoResult(lottoRanks, lottoService.calculateProfitRate(lottoRanks));
    }

    private void purchaseLotto() {
        try {
            String amount = lottoView.readPurchaseAmount();
            lottoService.buyLotto(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto();
        }
    }

    private void assignWinningNumbers() {
        try {
            String numbers = lottoView.readWinningNumbers();
            lottoService.assignWinningLotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assignWinningNumbers();
        }
    }

    private void assignBonusNumber() {
        try {
            String number = lottoView.readBonusNumber();
            lottoService.assignBonus(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assignBonusNumber();
        }
    }
}
