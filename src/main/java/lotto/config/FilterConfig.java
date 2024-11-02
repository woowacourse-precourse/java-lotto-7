package lotto.config;

import lotto.filter.FilterChain;
import lotto.filter.impl.filter.CommaSeparatedIntegerTypeFilter;
import lotto.filter.impl.filter.CommaSeparatedNumberInputFormatFilter;
import lotto.filter.impl.filter.IntegerTypeFilter;
import lotto.filter.impl.filter.PositiveIntegerFilter;
import lotto.filter.impl.filterchain.CommaSeparatedNumberFilterChain;
import lotto.filter.impl.filterchain.PositiveIntegerFilterChain;

public class FilterConfig {
    private static FilterConfig INSTANCE;

    private final FilterChain positiveIntegerFilterChain = new PositiveIntegerFilterChain();
    private final FilterChain commaSeparatedNumberFilterChain = new CommaSeparatedNumberFilterChain();

    private FilterConfig() {
        positiveIntegerFilterChain.addFilter(new IntegerTypeFilter());
        positiveIntegerFilterChain.addFilter(new PositiveIntegerFilter());
        commaSeparatedNumberFilterChain.addFilter(new CommaSeparatedNumberInputFormatFilter());
        commaSeparatedNumberFilterChain.addFilter(new CommaSeparatedIntegerTypeFilter());
    }

    public static FilterConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FilterConfig();
        }
        return INSTANCE;
    }

    public FilterChain getPositiveIntegerFilterChain() {
        return positiveIntegerFilterChain;
    }

    public FilterChain getCommaSeparatedNumberFilterChain() {
        return commaSeparatedNumberFilterChain;
    }
}
