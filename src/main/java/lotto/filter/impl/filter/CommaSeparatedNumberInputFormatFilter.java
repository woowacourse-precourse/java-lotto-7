package lotto.filter.impl.filter;

import lotto.filter.Filter;
import lotto.filter.FilterChain;

public class CommaSeparatedNumberInputFormatFilter implements Filter {
    private static final String regex = "^\\d+(,\\d+)*$";

    @Override
    public void doFilter(String input, FilterChain filterChain) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 숫자(양의 정수)와 구분자(,)로 이루어진 문자열을 입력해주십시오.");
        }
        filterChain.doFilter(input);
    }
}
