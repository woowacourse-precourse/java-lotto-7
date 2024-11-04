package lotto.filter.impl.filter;

import static lotto.common.ErrorConstants.ERROR_HEADER;

import lotto.filter.Filter;
import lotto.filter.FilterChain;

public class PositiveIntegerFilter implements Filter {
    private static final String ERROR_MESSAGE_NEGATIVE_AMOUNT = ERROR_HEADER + "입력한 금액이 음의 정수입니다.";

    @Override
    public void doFilter(String input, FilterChain filterChain) {
        int round = Integer.parseInt(input);
        if (round < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NEGATIVE_AMOUNT);
        }
        filterChain.doFilter(input);
    }
}
