package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = getValidatedPurchaseAmount();
        lottoService.purchaseLottos(purchaseAmount);
        lottoService.printLottos();
    }
    private int getValidatedPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return lottoService.validatePurchaseAmount(input);
    }

}
