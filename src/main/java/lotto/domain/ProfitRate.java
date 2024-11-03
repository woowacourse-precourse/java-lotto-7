package lotto.domain;

import java.math.BigDecimal;
import lotto.dto.ProfitRateResultDto;
import lotto.utils.DtoMapper;

public class ProfitRate {

    public static final BigDecimal PERCENTAGE = new BigDecimal("100");

    private final Money money;
    private final WinnerStatus winnerStatus;

    public ProfitRate(Money money, WinnerStatus winnerStatus) {
        this.money = money;
        this.winnerStatus = winnerStatus;
    }

    public static ProfitRate create(Money money, WinnerStatus winnerStatus) {
        return new ProfitRate(money, winnerStatus);
    }

    public ProfitRateResultDto toDto() {
        return DtoMapper.toProfitRateResultDto(calculate());
    }

    private String calculate() {
        BigDecimal sumPercentage = winnerStatus.sum()
                .multiply(PERCENTAGE);

        return money.calculateProfitRate(sumPercentage);
    }

}
