package lotto.utils.parser;

import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberInputParserTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("주어진 문자열이 유효한 보너스 번호일 경우 파싱하여 정수를 반환한다.")
        public void 유효한_입력으로_보너스_번호를_파싱한다() {
            String input = "5";
            int result = BonusNumberInputParser.parse(input);
            assertThat(result).isEqualTo(5);
        }

        @Test
        @DisplayName("0을 포함한 유효한 입력값이 주어질 경우 보너스 번호로 파싱한다.")
        public void 제로를_포함한_유효한_입력으로_보너스_번호를_파싱한다() {
            String input = "0";
            int result = BonusNumberInputParser.parse(input);
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("음수 문자열이 주어질 경우 보너스 번호로 파싱한다.")
        public void 음수를_유효한_입력으로_보너스_번호를_파싱한다() {
            String input = "-10";
            int result = BonusNumberInputParser.parse(input);
            assertThat(result).isEqualTo(-10);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest
        @ValueSource(strings = {"abc", "", "12a", "@#$%", "12.34"})
        @DisplayName("정수가 아닌 문자열이나 특수문자가 주어질 경우 예외를 발생시킨다.")
        public void 숫자가_아닌_입력(String input) {
            assertThatExceptionOfType(NumberFormatException.class)
                    .isThrownBy(() -> BonusNumberInputParser.parse(input))
                    .withMessage(NOT_INTEGER.getMessage());
        }
    }
}
