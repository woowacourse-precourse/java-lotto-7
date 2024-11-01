package lotto.filter.impl.filter;

import lotto.filter.Filter;
import lotto.filter.FilterChain;

public class PositiveIntegerFilter implements Filter {
    @Override
    public void doFilter(String input, FilterChain filterChain) {
        int round = Integer.parseInt(input);
        if (round < 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 음의 정수입니다.");
        }
        filterChain.doFilter(input);
    }
}
