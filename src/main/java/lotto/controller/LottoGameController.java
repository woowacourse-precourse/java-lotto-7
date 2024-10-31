package lotto.controller;

import static lotto.view.OutputView.printLottoExceptionMessage;
import static lotto.view.OutputView.printLottoGroup;
import static lotto.view.OutputView.printPurchaseMessage;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.service.BuyerService;
import lotto.view.InputView;

public class LottoGameController {
    private final BuyerService buyerService;

    public LottoGameController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    public void run() {
        final int lottoQuantity = getLottoQuantity();
        final List<Integer> winningNumbers;
    }

    private int getLottoQuantity() {
        String input = InputView.inputPurchaseAmount();

        try {
            int lottoQuantity = buyerService.calculateLottoQuantity(input);
            printPurchaseMessage(lottoQuantity);

            return lottoQuantity;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);
            return getLottoQuantity();
        }
    }

    private static void getWinningNumbers() {
        String input = InputView.inputWinningNumbers();
    }
}
