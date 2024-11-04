package lotto.model.money;

import lotto.dto.MatchDto;
import lotto.model.match.MatchInformation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static lotto.common.Rule.ROUND_COUNT;

public class Moneys {
    private final List<Money> monies;

    public Moneys(List<Money> monies) {
        this.monies = monies;
    }

    public static Moneys of(List<MatchDto> matchDtos) {
        List<Money> monies = new ArrayList<>();
        for (MatchDto matchDto : matchDtos) {
            MatchInformation matchInformation = matchDto.matchInformation();

            int count = matchDto.count();
            int value = LottoMoney.from(matchInformation).getValue();

            Money money = Money.of(value, count);
            monies.add(money);
        }
        return new Moneys(monies);
    }

    public double getRateOfReturn(Money money) {
        double rateOfMoney = (getTotalValue() / money.getTotalValue()) * 100;
        BigDecimal roundedRate = BigDecimal.valueOf(rateOfMoney)
                .setScale(ROUND_COUNT.getNumber(), RoundingMode.HALF_UP);
        return roundedRate.doubleValue();
    }

    private double getTotalValue() {
        return monies.stream().mapToDouble(Money::getTotalValue).sum();
    }
}
