package lotto.application.service;

import static lotto.common.LottoConstant.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import lotto.application.CalculateProfitUseCase;
import lotto.domain.LottoRank;
import lotto.domain.WinResult;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.WinResultHistory;

public class CalculateProfitService implements CalculateProfitUseCase {

    private static final int PROFIT_RATE_SCALE = 1;
    private static final int PERCENTAGE_MAKER = 100;

    private final LottoRepository lottoRepository;
    private final WinResultHistory winResultHistory;

    public CalculateProfitService(LottoRepository lottoRepository, WinResultHistory winResultHistory) {
        this.lottoRepository = lottoRepository;
        this.winResultHistory = winResultHistory;
    }

    @Override
    public float calculateRate() {
        BigDecimal investment = calculateInvestment();
        BigDecimal profit = calculateProfit();
        return profit.multiply(BigDecimal.valueOf(PERCENTAGE_MAKER))
                .divide(investment, PROFIT_RATE_SCALE, RoundingMode.HALF_UP)
                .floatValue();
    }

    private BigDecimal calculateInvestment() {
        return new BigDecimal(lottoRepository.getAll().size() * UNIT_OF_MONEY);
    }

    private BigDecimal calculateProfit() {
        WinResult winResult = winResultHistory.getRecent();
        return Arrays.stream(LottoRank.values())
                .map(rank -> calculateRankProfit(rank, winResult))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateRankProfit(LottoRank rank, WinResult winResult) {
        return rank.getPrize()
                .multiply(BigDecimal.valueOf(winResult.getMatchCount(rank.name())));
    }
}
