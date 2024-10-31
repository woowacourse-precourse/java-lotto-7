package lotto.domain;

import java.math.BigDecimal;
import lotto.dto.ProfitRateResultDto;
import lotto.utils.DtoMapper;

public class ProfitRate {

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

    public String calculate() {
        BigDecimal sum = winnerStatus.sum();
        return money.calculateProfitRate(sum);
    }

}
