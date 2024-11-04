package lotto.filter.impl.filter;

import static lotto.common.ErrorConstants.ERROR_HEADER;

import lotto.filter.Filter;
import lotto.filter.FilterChain;

public class CommaSeparatedNumberInputFormatFilter implements Filter {
    private static final String regex = "^\\d+(,\\d+)*$";
    private static final String ERROR_MESSAGE_INPUT_FORMAT = ERROR_HEADER + "숫자(양의 정수)와 구분자(,)로 이루어진 문자열을 입력해주십시오.";

    @Override
    public void doFilter(String input, FilterChain filterChain) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_FORMAT);
        }
        filterChain.doFilter(input);
    }
}
