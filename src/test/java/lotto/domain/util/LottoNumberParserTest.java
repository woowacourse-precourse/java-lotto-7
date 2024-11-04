package lotto.domain.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.exception.CustomErrorCode;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoNumberParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,5,23,32,41,45"})
    void 올바르게_입력된_문자열을_파싱한다(String number) {
        // when
        List<Integer> numbers = LottoNumberParser.parse(number);

        // then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Nested
    class 예외_처리_테스트를_진행한다 {

        @ParameterizedTest
        @NullAndEmptySource
        void 공백이나_빈_값이_입력된다(String number) {
            // when & then
            assertThatThrownBy(() -> LottoNumberParser.parse(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_EMPTY_NUMBER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3.4.5.6", "1,2,3,4/5/6", "1/2/3/4/5/6"})
        void 잘못된_구분자가_입력된다(String number) {
            // when & then
            assertThatThrownBy(() -> LottoNumberParser.parse(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_WRONG_DELIMITER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,4,5,6,7,8", "1,2,3", "1,2,3,4"})
        void 로또_개수를_벗어난_숫자를_입력받는다(String number) {
            // when & then
            assertThatThrownBy(() -> LottoNumberParser.parse(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_LOTTO_SIZE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,a", "1,2,3,b,5,6", "1,2,3,4,5,x"})
        void 숫자가_아닌_값이_포함된_입력을_받는다(String number) {
            // when & then
            assertThatThrownBy(() -> LottoNumberParser.parse(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_NOT_NUMBER.getMessage());
        }
    }
}
