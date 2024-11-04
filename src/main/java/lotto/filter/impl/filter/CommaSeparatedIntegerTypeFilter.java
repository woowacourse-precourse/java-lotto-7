package lotto.filter.impl.filter;

import static lotto.common.ErrorConstants.ERROR_HEADER;

import java.util.Arrays;
import lotto.filter.Filter;
import lotto.filter.FilterChain;

public class CommaSeparatedIntegerTypeFilter implements Filter {
    private static final String DELIMITER = ",";
    private static final String ERROR_MESSAGE_INVALID_INTEGER_RANGE =
            ERROR_HEADER + "입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.";

    @Override
    public void doFilter(String input, FilterChain filterChain) {
        try {
            Arrays.stream(input.split(DELIMITER)).forEach(Integer::valueOf);
            filterChain.doFilter(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_INTEGER_RANGE);
        }
    }
}
