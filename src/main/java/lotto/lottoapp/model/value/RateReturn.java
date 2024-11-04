package lotto.lottoapp.model.value;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record RateReturn(BigDecimal rateOfReturn) {

    public static RateReturn by(Won totalOfWinningPrize, Won amountOfPaid) {
        if (totalOfWinningPrize == null || amountOfPaid == null) {
            throw new IllegalArgumentException("null을 지정할 수 없습니다.");
        }

        return new RateReturn(new BigDecimal(totalOfWinningPrize.getIntValue())
                .divide(new BigDecimal(amountOfPaid.getIntValue()), 3, RoundingMode.HALF_UP)
                .scaleByPowerOfTen(2));
    }

}
