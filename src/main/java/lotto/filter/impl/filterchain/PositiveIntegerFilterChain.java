package lotto.filter.impl.filterchain;

import lotto.filter.Filter;

public class PositiveIntegerFilterChain extends DefaultFilterChain {
    public PositiveIntegerFilterChain() {
        super();
    }

    @Override
    protected void internalDoFilter(String input) {
        if (position < filterListLength) {
            try {
                Filter filter = filters.get(position++);
                filter.doFilter(input, this);
            } finally {
                this.position = 0;
            }
        }
    }
}
