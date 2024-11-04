package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            LottoTicket lottoTicket = purchaseLottoTickets(purchaseAmount);
            OutputView.printPurchasedLottos(lottoTicket.getLottoTickets());

            WinningLotto winningLotto = getWinningLotto();
            Map<Rank, Integer> results = initializeResultMap();
            int totalPrize = calculateTotalPrizeAndResults(lottoTicket, winningLotto, results);

            double profitRate = calculateProfitRate(totalPrize, purchaseAmount);
            OutputView.printStatistics(results, profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private LottoTicket purchaseLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1000;
        return new LottoTicket(numberOfTickets);
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> initializeResultMap() {
        Map<Rank, Integer> results = new HashMap<>();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                results.put(rank, 0);
            }
        }
        return results;
    }

    private int calculateTotalPrizeAndResults(LottoTicket lottoTicket, WinningLotto winningLotto,
                                              Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Lotto lotto : lottoTicket.getLottoTickets()) {
            Rank rank = winningLotto.determineRank(lotto);
            if (rank != Rank.NONE) {
                results.put(rank, results.get(rank) + 1);
                totalPrize += rank.getPrize();
            }
        }
        return totalPrize;
    }

    private double calculateProfitRate(int totalPrize, int purchaseAmount) {
        return (totalPrize / (double) purchaseAmount) * 100;
    }
}