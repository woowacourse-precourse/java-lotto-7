package lotto.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.configuration.LottoConfiguration;
import lotto.configuration.Prize;
import lotto.exception.ExceptionUtils;
import lotto.exception.ProfitReportExceptionMessage;

public class ProfitReport {
    private final List<Lotto> purchasedLottos;
    private final WinningNumbers winningNumbers;

    // constructor

    public ProfitReport(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        validate(purchasedLottos, winningNumbers);

        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
    }

    // public method

    public double calculateProfitRate() {
        long profit = calculateProfit();
        long paymentAmount = getPaymentAmount();

        return (double) profit / paymentAmount * 100;
    }

    public long calculateProfit() {
        return purchasedLottos.stream()
                .mapToLong(this::calculatePrizeMoney)
                .sum();
    }

    public Map<Prize, Integer> calculateWinningCountsByPrize() {
        return purchasedLottos.stream()
                .map(this::calculatePrize)
                .collect(Collectors.toMap(
                        prize -> prize,
                        prize -> 1,
                        Integer::sum,
                        HashMap::new
                ));
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getPaymentAmount() {
        return purchasedLottos.size() * LottoConfiguration.LOTTO_PRICE.getValue();
    }

    // private method

    private long calculatePrizeMoney(Lotto lotto) {
        Prize prize = calculatePrize(lotto);
        return prize.getPrizeMoney();
    }

    private Prize calculatePrize(Lotto lotto) {
        int matchCount = (int) winningNumbers.getMainNumbers().stream()
                .filter(lotto::contains).count();
        boolean matchBonus = lotto.contains(winningNumbers.getBonusNumber());

        return Prize.findPrize(matchCount, matchBonus);
    }

    private void validate(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        if (purchasedLottos == null || purchasedLottos.isEmpty()) {
            throw ExceptionUtils.IllegalArgument(ProfitReportExceptionMessage.NULL_OR_EMPTY_LOTTOS);
        }
        if (winningNumbers == null) {
            throw ExceptionUtils.IllegalArgument(ProfitReportExceptionMessage.NULL_WINNING_NUMBERS);
        }
    }
}
