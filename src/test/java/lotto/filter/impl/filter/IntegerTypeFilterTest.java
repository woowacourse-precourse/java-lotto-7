package lotto.filter.impl.filter;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import lotto.filter.Filter;
import lotto.filter.FilterChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerTypeFilterTest {
    private final IntegerTypeFilter filter = new IntegerTypeFilter();
    private TestFilterChain filterChain;

    @BeforeEach
    void setUp() {
        filterChain = new TestFilterChain();
    }

    @Test
    void testValidIntegerInput() {
        String validInput = "123";
        assertSoftly(softly -> {
            softly.assertThatCode(() -> filter.doFilter(validInput, filterChain))
                    .doesNotThrowAnyException();
            softly.assertThat(filterChain.isFilterCalled())
                    .isTrue()
                    .as("Filter chain should be called for valid integer input");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678901234567890", "abc"})
    void testInvalidIntegerInput(String input) {
        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(input, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.");
            softly.assertThat(filterChain.isFilterCalled())
                    .isFalse()
                    .as("Filter chain should not be called for invalid integer input");
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