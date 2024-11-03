package lotto.utils.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.ErrorMessage.NOT_INTEGER;
import static org.assertj.core.api.Assertions.*;

public class PurchaseTotalPriceParserTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("주어진 문자열이 유효할 경우 금액을 파싱한다.")
        public void 유효한_입력으로_금액을_파싱한다() {
            String input = "1000";
            int result = PurchaseTotalPriceParser.parse(input);
            assertThat(result).isEqualTo(1000);
        }

        @Test
        @DisplayName("0을 포함한 유효한 입력값이 주어질 경우 금액을 파싱한다.")
        public void 제로를_포함한_유효한_입력으로_금액을_파싱한다() {
            String input = "0";
            int result = PurchaseTotalPriceParser.parse(input);
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("음수 문자열이 주어질 경우 금액을 파싱한다.")
        public void 음수를_유효한_입력으로_파싱한다() {
            String input = "-1000";
            int result = PurchaseTotalPriceParser.parse(input);
            assertThat(result).isEqualTo(-1000);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest
        @ValueSource(strings = {"abc", "", "@#$%", "12.34"})
        @DisplayName("정수가 아닌 문자열이나 특수문자가 주어질 경우 예외를 발생시킨다.")
        public void 숫자가_아닌_입력(String input) {
            assertThatExceptionOfType(NumberFormatException.class)
                    .isThrownBy(() -> PurchaseTotalPriceParser.parse(input))
                    .withMessageContaining(NOT_INTEGER.getMessage());
        }
    }
}
