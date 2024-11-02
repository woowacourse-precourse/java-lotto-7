package lotto.filter.impl.filter;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import lotto.filter.Filter;
import lotto.filter.FilterChain;
import org.junit.jupiter.api.Test;

class IntegerTypeFilterTest {

    private final IntegerTypeFilter filter = new IntegerTypeFilter();

    @Test
    void testValidIntegerInput() {
        String validInput = "123";
        FilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatCode(() -> filter.doFilter(validInput, filterChain))
                    .doesNotThrowAnyException();
            softly.assertThat(((TestFilterChain) filterChain).isFilterCalled())
                    .isTrue()
                    .as("Filter chain should be called for valid integer input");
        });
    }

    @Test
    void testInvalidIntegerInput() {
        String invalidInput = "12345678901234567890";
        FilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(invalidInput, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.")
                    .as("Out-of-range integer input should throw IllegalArgumentException");
            softly.assertThat(((TestFilterChain) filterChain).isFilterCalled())
                    .isFalse()
                    .as("Filter chain should not be called for invalid integer input");
        });
    }

    @Test
    void testNonNumericInput() {
        String nonNumericInput = "abc";
        FilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(nonNumericInput, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.")
                    .as("Non-numeric input should throw IllegalArgumentException");
            softly.assertThat(((TestFilterChain) filterChain).isFilterCalled())
                    .isFalse()
                    .as("Filter chain should not be called for non-numeric input");
        });
    }

    private static class TestFilterChain implements FilterChain {
        private boolean filterCalled = false;

        @Override
        public void doFilter(String input) {
            filterCalled = true;
        }

        @Override
        public void addFilter(Filter filter) {
            return;
        }

        public boolean isFilterCalled() {
            return filterCalled;
        }
    }

}