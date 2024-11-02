package lotto.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.configuration.LottoConfiguration;
import lotto.configuration.Prize;
import lotto.exception.ExceptionUtils;
import lotto.exception.ProfitReportExceptionMessage;

public class ProfitReport {
    private final List<Lotto> purchasedLottos;
    private final WinningNumbers winningNumbers;

    public ProfitReport(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        if (purchasedLottos == null || purchasedLottos.isEmpty()) {
            throw ExceptionUtils.IllegalArgument(ProfitReportExceptionMessage.NULL_OR_EMPTY_LOTTOS);
        }
        if (winningNumbers == null) {
            throw ExceptionUtils.IllegalArgument(ProfitReportExceptionMessage.NULL_WINNING_NUMBERS);
        }

        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
    }

    public long calculateProfit() {
        List<Prize> collect = purchasedLottos.stream()
                .map(lotto -> {
                    int matchCount = (int) winningNumbers.getWinningNumbers().stream()
                            .filter(lotto::contains).count();
                    boolean matchBonus = lotto.contains(winningNumbers.getBonusNumber());
                    return Prize.findPrize(matchCount, matchBonus);
                }).toList();

        long profit = collect.stream()
                .map(prize -> (long) prize.getPrizeMoney())
                .reduce(Long::sum)
                .orElse(0L);

        return profit;
    }

    public double calculateProfitRate() {
        long profit = calculateProfit();
        long paymentAmount = getPaymentAmount();

        return (double) profit / paymentAmount * 100;
    }

    public Map<Prize, Integer> calculateWinningCountsByRank() {
        List<Prize> prizes = purchasedLottos.stream()
                .map(lotto -> {
                    int matchCount = (int) winningNumbers.getWinningNumbers().stream()
                            .filter(lotto::contains).count();
                    boolean matchBonus = lotto.contains(winningNumbers.getBonusNumber());
                    return Prize.findPrize(matchCount, matchBonus);
                }).toList();

        Map<Prize, Integer> counter = new HashMap<>();
        for (Prize prize : prizes) {
            counter.put(prize, counter.getOrDefault(prize, 0) + 1);
        }
        return counter;
    }

    public int getPaymentAmount() {
        return purchasedLottos.size() * LottoConfiguration.LOTTO_PRICE.getValue();
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
