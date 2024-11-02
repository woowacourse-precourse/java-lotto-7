package lotto.viewHandler.api.dto.output;

import lotto.domain.ResultLotto;

import java.util.Arrays;

public class ResultAmountDto {
    private final Double amount;

    public ResultAmountDto(Integer money) {
        this.amount = transformDto(money);
    }

    public Double getAmount() {
        return amount;
    }

    private Double transformDto(Integer money) {
        return Arrays.stream(ResultLotto.values())
                .filter(resultLotto -> resultLotto.getCount() != 0)
                .mapToDouble(resultLotto -> resultLotto.getCount() * resultLotto.getLottoAmount())
                .sum() / money;
    }
}
