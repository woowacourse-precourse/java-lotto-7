package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.validator.PurchasePriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    private LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public static LottoController getInstance() {
        return LottoControllerHolder.LOTTO_CONTROLLER;
    }

    public static class LottoControllerHolder {
        private static final LottoController LOTTO_CONTROLLER = new LottoController();
    }

    public void run() {
        int validPurchasePrice = validatePurchasePrice();
        List<Lotto> lottos = lottoService.makeLottos(validPurchasePrice);
        printLottoNumbers(lottos);
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        outputView.println("");
        outputView.println(lottos.size()+"개를 구매했습니다.");
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(outputView::printList);
    }

    private int validatePurchasePrice() {
        boolean pass = false;
        String rawPurchasePrice = "";
        while (!pass) {
            rawPurchasePrice = inputView.getRequestPurchasePrice();
            pass = PurchasePriceValidator.validate(rawPurchasePrice);
        }
        return Integer.parseInt(rawPurchasePrice);
    }
}
