package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static LottoController instance;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    private LottoController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        lottoService = LottoService.getInstance();
    }

    public static LottoController getInstance() {
        if (instance == null) {
            instance = new LottoController();
        }

        return instance;
    }

    public void run() {
        int price = inputView.readPurchasePrice();
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(price);
        outputView.printPurchasedLottoTickets(lottoTickets);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        Map<Rank, Integer> winCount = lottoService.checkWinning(lottoTickets, winningNumbers, bonusNumber);
        outputView.printWinningResults(price, winCount);
    }
}
