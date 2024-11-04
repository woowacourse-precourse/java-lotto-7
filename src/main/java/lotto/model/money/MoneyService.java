package lotto.model.money;

import lotto.dto.MatchDto;

import java.util.List;

public class MoneyService {
    public double getRateOfReturn(List<MatchDto> matchDtos, Money money) {
        Moneys moneys = Moneys.of(matchDtos);
        return moneys.getRateOfReturn(money);
    }
}
