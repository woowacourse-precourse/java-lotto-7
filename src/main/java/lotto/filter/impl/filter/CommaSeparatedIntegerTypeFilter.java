package lotto.filter.impl.filter;

import java.util.Arrays;
import lotto.filter.Filter;
import lotto.filter.FilterChain;

public class CommaSeparatedIntegerTypeFilter implements Filter {

    private static final String DELIMITER = ",";

    @Override
    public void doFilter(String input, FilterChain filterChain) {
        try {
            Arrays.stream(input.split(DELIMITER)).forEach(Integer::valueOf);
            filterChain.doFilter(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.");
        }
    }
}
