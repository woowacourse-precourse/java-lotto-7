package lotto.filter.impl.filter;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import lotto.filter.Filter;
import lotto.filter.FilterChain;
import org.junit.jupiter.api.Test;

class CommaSeparatedIntegerTypeFilterTest {
    private final CommaSeparatedIntegerTypeFilter filter = new CommaSeparatedIntegerTypeFilter();

    @Test
    void testValidInput() {
        String validInput = "123,456,789";
        TestFilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatCode(() -> filter.doFilter(validInput, filterChain))
                    .doesNotThrowAnyException();
            softly.assertThat(filterChain.isFilterCalled())
                    .isTrue()
                    .as("Filter chain should be called for valid input");
        });
    }

    @Test
    void testInvalidInput_NonIntegerCharacters() {
        String invalidInput = "123,abc,456";
        TestFilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(invalidInput, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.");
            softly.assertThat(filterChain.isFilterCalled())
                    .isFalse()
                    .as("Filter chain should not be called for invalid input");
        });
    }

    @Test
    void testInvalidInput_IntegerOutOfRange() {
        String invalidInput = "123,2147483648,456";
        TestFilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(invalidInput, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.");
            softly.assertThat(filterChain.isFilterCalled())
                    .isFalse()
                    .as("Filter chain should not be called for invalid input");
        });
    }

    @Test
    void testInvalidInput_EmptyString() {
        String invalidInput = "";
        TestFilterChain filterChain = new TestFilterChain();

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(invalidInput, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 금액이 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다.");
            softly.assertThat(filterChain.isFilterCalled())
                    .isFalse()
                    .as("Filter chain should not be called for invalid input");
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