package service;

import static content.LottoConstants.RATE_OF_RETURN;
import static content.LottoConstants.RATE_OF_RETURN_decimal_percent;
import static content.LottoPrize.FIFTH;
import static content.LottoPrize.FIRST;
import static content.LottoPrize.FOURTH;
import static content.LottoPrize.SECONDS;
import static content.LottoPrize.THIRD;
import static content.LottoPrize.WINNING_RESULT_TITLE;
import static content.OutputMessage.BUY_COUNT_MESSAGE;
import static content.OutputMessage.COUNT_MESSAGE;
import static content.OutputMessage.RESULT_MESSAGE;
import static content.Separator.RESULT_SEPARATOR;

import content.LottoConstants;
import content.LottoPrize;
import model.Lotto;
import model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private int totalPrize = 0;

    public void purchaseLottos(int amount) {
        int lottoCount = amount / LottoConstants.LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            purchasedLottos.add(new Lotto());
        }
        displayPurchasedLottos();
    }

    private void displayPurchasedLottos() {
        System.out.println(purchasedLottos.size() + BUY_COUNT_MESSAGE.getMessage());
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto);
        }
    }

    public void checkWinnings(WinningNumbers winningNumbers) {
        int[] winningStats = new int[LottoPrize.values().length];
        for (Lotto lotto : purchasedLottos) {
            LottoPrize prize = lotto.getPrize(winningNumbers);
            if (prize != null) {
                winningStats[prize.ordinal()]++;
                totalPrize += prize.getAmount();
            }
        }
        printWinningStats(winningStats);
        printReturnRate(purchasedLottos.size() * LottoConstants.LOTTO_PRICE);
    }

    private void printWinningStats(int[] winningStats) {
        System.out.println(WINNING_RESULT_TITLE.getDescription());
        System.out.println(RESULT_SEPARATOR.getMessage());
        System.out.println(FIFTH.getDescription() + winningStats[FIFTH.ordinal()] + COUNT_MESSAGE.getMessage());
        System.out.println(FOURTH.getDescription() + winningStats[FOURTH.ordinal()] + COUNT_MESSAGE.getMessage());
        System.out.println(THIRD.getDescription() + winningStats[THIRD.ordinal()] + COUNT_MESSAGE.getMessage());
        System.out.println(SECONDS.getDescription() + winningStats[SECONDS.ordinal()] + COUNT_MESSAGE.getMessage());
        System.out.println(FIRST.getDescription() + winningStats[FIRST.ordinal()] + COUNT_MESSAGE.getMessage());
    }

    private void printReturnRate(int totalSpent) {
        double returnRate = (double) totalPrize / totalSpent * RATE_OF_RETURN;
        returnRate = Math.round(returnRate * RATE_OF_RETURN_decimal_percent) / RATE_OF_RETURN_decimal_percent;
        System.out.printf(RESULT_MESSAGE.getMessage(), returnRate);
    }
}
