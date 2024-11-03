package lotto.util;

import static lotto.constant.ExceptionMessage.INPUT_TOO_LONG;
import static lotto.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static lotto.constant.ExceptionMessage.NULL_OR_EMPTY_INPUT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberParserTest {
    @Nested
    class 숫자_변환_테스트 {
        @Test
        void 숫자_문자열을_정수로_변환한다() {
            // given
            String input = "123";

            // when
            Integer result = NumberParser.parse(input);

            // then
            assertThat(result).isEqualTo(123);
        }

        @Test
        void 앞뒤_공백이_있는_숫자_문자열을_정수로_변환한다() {
            // given
            String input = "  456  ";

            // when
            Integer result = NumberParser.parse(input);

            // then
            assertThat(result).isEqualTo(456);
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "abc", "12.34", "1a2b3c", "12 34"
        })
        void 숫자가_아닌_문자열_변환_시_예외가_발생한다(String input) {
            assertThatThrownBy(() -> NumberParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_FORMAT.message());
        }
    }

    @Nested
    class 입력_유효성_검증_테스트 {
        @ParameterizedTest
        @NullAndEmptySource
        void null_또는_빈_문자열_입력_시_예외가_발생한다(String input) {
            assertThatThrownBy(() -> NumberParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NULL_OR_EMPTY_INPUT.message());
        }

        @Test
        void 공백_문자열_입력_시_예외가_발생한다() {
            // given
            String input = "   ";

            // when & then
            assertThatThrownBy(() -> NumberParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NULL_OR_EMPTY_INPUT.message());
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "1234567890", "9999999999", "10000000000"
        })
        void 최대_자릿수_초과_시_예외가_발생한다(String input) {
            assertThatThrownBy(() -> NumberParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_TOO_LONG.message());
        }
    }
}
