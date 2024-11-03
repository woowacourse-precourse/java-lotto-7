package lotto.filter.impl.filter;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import lotto.filter.Filter;
import lotto.filter.FilterChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommaSeparatedNumberInputFormatFilterTest {
    private final CommaSeparatedNumberInputFormatFilter filter = new CommaSeparatedNumberInputFormatFilter();
    private TestFilterChain filterChain;

    @BeforeEach
    void setUp() {
        filterChain = new TestFilterChain();
    }

    @Test
    void testValidInput() {
        String validInput = "1,2,3,4,5";
        assertSoftly(softly -> {
            softly.assertThatCode(() -> filter.doFilter(validInput, filterChain))
                    .doesNotThrowAnyException();
            softly.assertThat(filterChain.isFilterCalled())
                    .isTrue()
                    .as("Filter chain should be called for valid input");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,a,3", "1,,3", ""})
    void testInvalidInput_NonNumericCharacters(String input) {
        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> filter.doFilter(input, filterChain))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자(양의 정수)와 구분자(,)로 이루어진 문자열을 입력해주십시오.");
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