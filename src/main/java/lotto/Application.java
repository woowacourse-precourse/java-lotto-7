package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoConstants;
import lotto.enums.Rank;
import lotto.service.WinningResultCalculator;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final int purchaseAmount = InputView.getPurchaseAmount();
        final int lottoCount = calculateLottoCount(purchaseAmount);
        OutputView.printPurchaseMessage(lottoCount);

        final List<Lotto> lottoTickets = purchaseLottos(lottoCount);
        OutputView.printLottoTickets(lottoTickets);

        final List<Integer> winningNumbers = InputView.getWinningNumbers();

        final int bonusNumber = InputView.getBonusNumber(winningNumbers);

        final Map<Rank, Integer> statistics = calculateStatistics(lottoTickets, winningNumbers, bonusNumber);
        OutputView.printStatistics(statistics);
        final double yield = calculateYield(statistics, purchaseAmount);
        OutputView.printYield(yield);
    }

    private static int calculateLottoCount(final int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE.getValue();
    }

    private static List<Lotto> purchaseLottos(final int lottoCount) {
        final List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            final Lotto lotto = Lotto.generateLottoNumber();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    static Map<Rank, Integer> calculateStatistics(final List<Lotto> lottoTickets, final List<Integer> winningNumbers,
                                                  final int bonusNumber) {
        final Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

        for (final Lotto lotto : lottoTickets) {
            final Rank rank = WinningResultCalculator.calculateResult(lotto, winningNumbers, bonusNumber);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }

        return statistics;
    }

    static double calculateYield(final Map<Rank, Integer> statistics, final int purchaseAmount) {
        int totalPrize = 0;
        for (final Map.Entry<Rank, Integer> entry : statistics.entrySet()) {
            final Rank rank = entry.getKey();
            final int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        final double yield = (double) totalPrize / purchaseAmount * 100;

        return Math.round(yield * 10) / 10.0;
    }

}
