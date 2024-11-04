package lotto.controller;

import lotto.service.IssueLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.PurchasedLottos;
import lotto.parser.BonusNumberParser;
import lotto.parser.PurchaseAmountParser;
import lotto.parser.WinningNumbersParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoController {
    private PurchasedLottos purchasedLottos;
    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public void run() {
        purchaseLotto();
        progressLottoGame();
        announceLottoResult();
    }

    private void purchaseLotto() {
        purchasedLottos = IssueLottos.issueLottos(getLottoPurchaseAmount());
        OutputView.showPurchasedLottos(purchasedLottos.getPurchasedLottos().stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n")));
    }

    private int getLottoPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmountParser.parse(InputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void progressLottoGame() {
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();

    }

    private Set<Integer> getWinningNumbers() {
        while (true) {
            try {
                return WinningNumbersParser.parse(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return BonusNumberParser.parse(InputView.readBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void announceLottoResult() {
        int[] rankCounts = new int[6];
        for (Lotto lotto : purchasedLottos.getPurchasedLottos()) {
            rankCounts[checkWinningNumber(lotto, 0)]++;
        }
        announceStatistics(rankCounts);
    }

    private void announceStatistics(int[] rankCounts) {
        LottoRank[] ranks = {LottoRank.NONE, LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};
        StringBuilder winningStatistics = new StringBuilder();
        long totalPrize = 0;

        for (int i = 1; i < rankCounts.length; i++) {
            LottoRank rank = ranks[i];
            totalPrize += ranks[i].getPrize() * rankCounts[i];
            winningStatistics.append(rank.getMessage() + rankCounts[i] + "개" + "\n");
        }
        OutputView.announceWinningStatistics(winningStatistics.toString(), getReturnRate(totalPrize));
    }

    private int checkWinningNumber(Lotto lotto, int count) {
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        if (count < 5 && !lotto.getNumbers().contains(bonusNumber)) {
            count--;
        }
        if (count >= 2) {
            return count - 1;
        }
        return 0;
    }

    private double getReturnRate(long totalPrize) {
        return (double) totalPrize / purchasedLottos.getPurchaseAmount() * 100;
    }
}
