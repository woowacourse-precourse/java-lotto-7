package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinningNumberValidator;
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
        int validPurchasePrice = getValidPurchasePrice(validatePurchasePrice());
        List<Lotto> lotties = lottoService.makeLottos(validPurchasePrice);
        printLottoNumbers(lotties);
        List<Integer> validWinningNumbers = validWinningNumbers(validateWinningNumbers());
    }

    private int getValidPurchasePrice(String rawPurchasePrice) {
        return Integer.parseInt(rawPurchasePrice);
    }

    private String validateWinningNumbers() {
        boolean pass = false;
        String rawWinningNumber = "";
        while (!pass) {
            rawWinningNumber = inputView.getRequestWinningNumber();
            pass = WinningNumberValidator.validate(rawWinningNumber);
        }
        return rawWinningNumber;
    }

    private List<Integer> validWinningNumbers(String rawWinningNumber) {
        return Arrays.stream(rawWinningNumber.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private String validatePurchasePrice() {
        boolean pass = false;
        String rawPurchasePrice = "";
        while (!pass) {
            rawPurchasePrice = inputView.getRequestPurchasePrice();
            pass = PurchasePriceValidator.validate(rawPurchasePrice);
        }
        return rawPurchasePrice;
    }

    private void printLottoNumbers(List<Lotto> lotties) {
        outputView.newLine();
        outputView.println(lotties.size() + "개를 구매했습니다.");
        lotties.stream()
                .map(Lotto::getNumbers)
                .forEach(outputView::printList);
        outputView.newLine();
    }
}
