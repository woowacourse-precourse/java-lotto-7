package lotto.view;

import lotto.service.LottoService;

public class issueLottoOutputHandler {
    private LottoService lottoService;

    public issueLottoOutputHandler(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void displayNumberOfLottos(int purchaseAmount) {
        int numberOfLottos = lottoService.calculateLottoQuantities(purchaseAmount);
        System.out.printf("%d개를 구매했습니다.\n", numberOfLottos);
    }
}
