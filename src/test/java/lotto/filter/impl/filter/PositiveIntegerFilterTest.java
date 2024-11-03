package lotto.filter.impl.filter;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import lotto.filter.Filter;
import lotto.filter.FilterChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositiveIntegerFilterTest {
    private final PositiveIntegerFilter filter = new PositiveIntegerFilter();
    private TestFilterChain filterChain;

    @BeforeEach
    void setUp() {
        filterChain = new TestFilterChain();
    }

    @Test
    void testValidPositiveIntegerInput() {
        String validInput = "10";
        assertSoftly(softly -> {
            softly.assertThatCode(() -> filter.doFilter(validInput, filterChain))
                    .doesNotThrowAnyException();
            softly.assertThat(filterChain.isFilterCalled())
                    .isTrue()
                    .as("Filter chain should be called for valid positive input");
        });
    }

    @Test
    void testZeroInput() {
        String zeroInput = "0";
        TestFilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatCode(() -> filter.doFilter(zeroInput, filterChain))
                    .doesNotThrowAnyException();
            softly.assertThat(filterChain.isFilterCalled())
                    .isTrue()
                    .as("Filter chain should be called for zero input");
        });
    }

    @Test
    void testNegativeIntegerInput() {
        String negativeInput = "-5";
        TestFilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(negativeInput, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 금액이 음의 정수입니다.");
            softly.assertThat(filterChain.isFilterCalled())
                    .isFalse()
                    .as("Filter chain should not be called for negative input");
        });
    }

    @Test
    void testInvalidNonNumericInput() {
        String invalidInput = "abc";
        TestFilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(invalidInput, filterChain))
                    .isInstanceOf(NumberFormatException.class);
            softly.assertThat(filterChain.isFilterCalled())
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