package lotto.filter;

public interface FilterChain {
    void doFilter(String input);

    void addFilter(Filter filter);
}
