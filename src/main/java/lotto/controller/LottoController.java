package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.model.RankInfo;
import lotto.view.LottoInputView;
import lotto.domain.generator.LottoTicketGenerator;
import lotto.service.LottoService;

import static lotto.constants.LottoConstants.*;
import static lotto.view.LottoOutputView.*;

public class LottoController {
    private final LottoInputView inputView;
    private LottoService lottoService;

    public LottoController(LottoInputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int purchaseAmount = inputView.getInputPurchaseAmount();
        int lottoCount = calculateLottoCount(purchaseAmount);

        promptLottoCount(lottoCount);
        List<Lotto> lottoTickets = generateLottoTickets(lottoCount);
        printLottoTickets(lottoTickets);

        initializeLottoService(lottoTickets, purchaseAmount);
        displayResults();
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }

    private List<Lotto> generateLottoTickets(int count) {
        List<Lotto> tickets = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(LottoTicketGenerator.generateNumbers()));
        }
        return tickets;
    }

    private void initializeLottoService(List<Lotto> lottoTickets, int purchaseAmount) {
        Lotto winningNumbers = getWinningNumbers();
        Lotto bonusNumber = getBonusNumber();
        lottoService = new LottoService(lottoTickets, winningNumbers, bonusNumber, purchaseAmount);
    }

    private Lotto getWinningNumbers() {
        return new Lotto(inputView.getInputWinningNumbers());
    }

    private Lotto getBonusNumber() {
        return new Lotto(inputView.getInputBonusNumber());
    }

    private void displayResults() {
        processWinningAmount();
        processEarningRate();
    }

    private void processWinningAmount() {
        Map<RankInfo, Integer> winningResults = lottoService.getWinningResults();

        promptWinningResult();
        printWinningResult(winningResults);
    }

    private void processEarningRate() {
        String earningRate = lottoService.getEarningsRate();
        printEarningsRate(earningRate);
    }
}
