package lotto.util;

import static lotto.constant.ExceptionMessage.INPUT_TOO_LONG;
import static lotto.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static lotto.constant.ExceptionMessage.NULL_OR_EMPTY_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberParserTest {

    @Nested
    class Long타입_파싱_테스트 {
        @Test
        void 문자열을_Long으로_변환한다() {
            // given
            String input = "123456789";

            // when
            Long result = NumberParser.parseLong(input);

            // then
            assertThat(result).isEqualTo(123456789L);
        }

        @Test
        void 공백이_포함된_문자열을_Long으로_변환한다() {
            // given
            String input = "  123456789  ";

            // when
            Long result = NumberParser.parseLong(input);

            // then
            assertThat(result).isEqualTo(123456789L);
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "12345678901234567890", // 20자리
                "999999999999999999999"  // 21자리
        })
        void 최대_자릿수를_초과하면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> NumberParser.parseLong(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_TOO_LONG.message());
        }
    }

    @Nested
    class Integer타입_파싱_테스트 {
        @Test
        void 문자열을_Integer로_변환한다() {
            // given
            String input = "12345";

            // when
            Integer result = NumberParser.parseInt(input);

            // then
            assertThat(result).isEqualTo(12345);
        }

        @Test
        void 공백이_포함된_문자열을_Integer로_변환한다() {
            // given
            String input = "  12345  ";

            // when
            Integer result = NumberParser.parseInt(input);

            // then
            assertThat(result).isEqualTo(12345);
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "1234567890",    // 10자리
                "12345678901"    // 11자리
        })
        void 최대_자릿수를_초과하면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> NumberParser.parseInt(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_TOO_LONG.message());
        }
    }

    @Nested
    class 공통_유효성_검증_테스트 {
        @ParameterizedTest
        @NullAndEmptySource
        void null이거나_빈_문자열이면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> {
                NumberParser.parseLong(input);
                NumberParser.parseInt(input);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NULL_OR_EMPTY_INPUT.message());
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "abc", "12.34", "1a2b3c", "12 34",
                "1,000", "1_000",
                "true", "false"
        })
        void 유효하지_않은_숫자_형식이면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> {
                NumberParser.parseLong(input);
                NumberParser.parseInt(input);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_FORMAT.message());
        }
    }

    @Nested
    class 경계값_테스트 {
        @Test
        void Integer의_최댓값을_초과하는_값은_Long으로_변환할_수_있다() {
            // given
            String input = "2147483648";  // Integer.MAX_VALUE + 1

            // when
            Long result = NumberParser.parseLong(input);

            // then
            assertThat(result).isEqualTo(2147483648L);
        }

        @Test
        void 자릿수가_최대치_바로_아래인_경우_변환할_수_있다() {
            // given
            String intInput = "999999999";     // 9자리
            String longInput = "999999999999999999";  // 18자리

            // when & then
            assertThat(NumberParser.parseInt(intInput)).isEqualTo(999999999);
            assertThat(NumberParser.parseLong(longInput)).isEqualTo(999999999999999999L);
        }
    }

    @Test
    void 동일한_입력에_대해_Integer와_Long_변환이_일관성을_가진다() {
        // given
        String input = "12345";

        // when
        Integer intResult = NumberParser.parseInt(input);
        Long longResult = NumberParser.parseLong(input);

        // then
        assertThat(intResult.longValue()).isEqualTo(longResult);
    }
}
