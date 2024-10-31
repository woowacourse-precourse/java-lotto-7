package lotto.controller;

import static lotto.view.OutputView.printLottoExceptionMessage;
import static lotto.view.OutputView.printLottoGroup;
import static lotto.view.OutputView.printPurchaseMessage;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.service.BuyerService;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoGameController {
    private final BuyerService buyerService;
    private final LottoService lottoService;

    public LottoGameController(BuyerService buyerService, LottoService lottoService) {
        this.buyerService = buyerService;
        this.lottoService = lottoService;
    }

    public void run() {
        final int lottoQuantity = getLottoQuantity();
        final Lottos lottos = getLottos(lottoQuantity);
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

    private Lottos getLottos(int lottoQuantity) {
        Lottos lottos = lottoService.createLottos(lottoQuantity);
        List<Lotto> lottoGroup = lottos.getLottoGroup();

        printLottoGroup(lottoGroup);

        return lottos;
    }

    private static void getWinningNumbers() {
        String input = InputView.inputWinningNumbers();
    }
}
