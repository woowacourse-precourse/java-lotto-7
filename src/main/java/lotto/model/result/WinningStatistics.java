package lotto.model.result;

import static lotto.util.Constants.LOTTO_PRICE;
import static lotto.util.ResultFormatter.formatResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.draw.LottoDraw;
import lotto.model.lotto.LottoTickets;
import lotto.model.draw.LottoNumbersGenerator;
import lotto.util.ResultFormatter;

public class WinningStatistics {

    private final LottoDraw lottoDraw;
    private final LottoTickets lottoTickets;
    private Map<WinningRank, Integer> winningStatistics = new EnumMap<>(WinningRank.class);
    private BigDecimal rewardRate = BigDecimal.ZERO;

    private WinningStatistics(LottoDraw lottoDraw, LottoTickets lottoTickets) {
        this.lottoDraw = lottoDraw;
        this.lottoTickets = lottoTickets;
        setWinningStatistics();
        setRewardRate();
    }

    public static WinningStatistics from(LottoDraw lottoDraw, LottoTickets lottoTickets) {
        return new WinningStatistics(lottoDraw, lottoTickets);
    }

    private void setWinningStatistics() {
        for (LottoNumbersGenerator lottoNumberGenerator : lottoTickets.getLottoTickets()) {
            WinningRank winningRank = WinningRank.from(calculateMatch(lottoNumberGenerator), hasBonus(lottoNumberGenerator));
            updateWinningStatistics(winningRank);
        }
    }

    private void setRewardRate() {
        BigDecimal ticketBudget = BigDecimal.ZERO;
        BigDecimal totalCashPrize = BigDecimal.ZERO;
        for (LottoNumbersGenerator lottoNumberGenerator : lottoTickets.getLottoTickets()) {
            WinningRank winningRank = WinningRank.from(calculateMatch(lottoNumberGenerator), hasBonus(lottoNumberGenerator));
            ticketBudget = ticketBudget.add(new BigDecimal(String.valueOf(LOTTO_PRICE)));
            totalCashPrize = totalCashPrize.add(new BigDecimal(String.valueOf(winningRank.getCashPrize())));
        }
        rewardRate = calculateRewardRate(totalCashPrize, ticketBudget);
    }

    private static BigDecimal calculateRewardRate(BigDecimal totalCashPrize, BigDecimal ticketBudget) {
        if (ticketBudget.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return totalCashPrize.multiply(new BigDecimal("100")).divide(ticketBudget, 1, RoundingMode.HALF_EVEN);
    }

    private void updateWinningStatistics(WinningRank winningRank) {
        winningStatistics.put(winningRank, winningStatistics.getOrDefault(winningRank, 0) + 1);
    }

    public int getWinningStatistics(WinningRank winningRank) {
        return winningStatistics.getOrDefault(winningRank, 0);
    }

    private boolean hasBonus(LottoNumbersGenerator lottoNumberGenerator) {
        return lottoNumberGenerator.getLottoNumbers().contains(lottoDraw.getBonusNumber());
    }

    private int calculateMatch(LottoNumbersGenerator lottoNumberGenerator) {
        List<Integer> intersection = new ArrayList<>(lottoNumberGenerator.getLottoNumbers());
        intersection.retainAll(lottoDraw.getWinningNumbers());
        return intersection.size();
    }

    public String getRewardRate() {
        return ResultFormatter.formatRewardRate(rewardRate);
    }

    @Override
    public String toString() {
        return formatResult(this);
    }
}