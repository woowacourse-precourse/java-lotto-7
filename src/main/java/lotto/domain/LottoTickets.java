package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.util.LottoConstants;
import lotto.util.Ranking;

public class LottoTickets {
    private static final int WINNING_COUNT_INCREMENT = 1;
    private static final int DEFAULT_WINNING_COUNT = 0;

    private List<Lotto> lottos;

    public LottoTickets(int purchaseAmount) {
        lottos = new ArrayList<>();
        generateLottoTickets(purchaseAmount);
    }

    public String getLottoTicket() {
        StringBuilder lottoTicket = new StringBuilder();

        for (Lotto lotto : lottos) {
            lottoTicket.append(lotto.getNumbers().toString())
                    .append("\n");
        }
        return lottoTicket.toString().trim();
    }

    public Map<Ranking, Integer> calculateWinningStatistics(List<Integer> winningNumbers, int bonusNumber) {
        Map<Ranking, Integer> winningStatistics = new EnumMap<>(Ranking.class);

        for (Lotto lotto : lottos) {
            Ranking rank = lotto.calculateRank(winningNumbers, bonusNumber);
            winningStatistics.put(rank, winningStatistics.getOrDefault(rank, DEFAULT_WINNING_COUNT) + WINNING_COUNT_INCREMENT);
        }

        return winningStatistics;
    }

    public double calculateProfitRate(Map<Ranking, Integer> winningStatistics, int purchaseAmount) {
        int profit = getProfit(winningStatistics);

        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) (profit - purchaseAmount) / purchaseAmount * 100;
    }

    private void generateLottoTickets(int purchasAmount) {
        int ticketCount = purchasAmount / LottoConstants.LOTTO_PRICE;

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int getProfit(Map<Ranking, Integer> winningStatistics) {
        int profit = 0;

        for (Ranking ranking : winningStatistics.keySet()) {
            int count = winningStatistics.get(ranking);
            profit += ranking.getPrize() * count;
        }

        return profit;
    }
}
