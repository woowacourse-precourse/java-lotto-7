package lotto.dto.output;

import lotto.domain.ResultLotto;

import java.util.Arrays;

import static lotto.viewHandler.exception.MyExceptionConstant.ZERO;

public class ResultAmountDto {
    private static final Double FIRST_DECIMAL_PLACE = 10.0;
    private static final Integer ROUND_NUMBER = 1_000;

    private final Double amount;

    public ResultAmountDto(Integer money) {
        this.amount = transformDto(money);
    }

    public Double getAmount() {
        return amount;
    }

    private Double transformDto(Integer money) {
        double amount = Arrays.stream(ResultLotto.values())
                .filter(resultLotto -> resultLotto.getCount() != ZERO)
                .mapToDouble(resultLotto -> resultLotto.getCount() * resultLotto.getLottoAmount())
                .sum() / money;
        return Math.round(amount * ROUND_NUMBER) / FIRST_DECIMAL_PLACE;
    }
}
