package lotto.utils.parser;

import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LottoNumbersInputParserTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @ParameterizedTest
        @ValueSource(strings = {
                "1, 2, 3, 4, 5, 6",
                "  1 , 2, 3 , 4 , 5 , 6  ",
                "1,2,3,4,5,6",
        })
        @DisplayName("유효한 입력으로 로또 번호를 반환한다.")
        public void 유효한_입력으로_로또_번호를_반환한다(String input) {
            List<Integer> result = LottoNumbersInputParser.parse(input);
            assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("null 입력값에 대해 예외를 발생시킨다.")
        public void null_입력값에_예외를_발생시킨다() {
            assertThatExceptionOfType(NullPointerException.class)
                    .isThrownBy(() -> LottoNumbersInputParser.parse(null))
                    .withMessage(NULL_INPUT.getMessage());
        }

        @Test
        @DisplayName("빈 문자열 입력값에 대해 예외를 발생시킨다.")
        public void 빈_문자열_입력값에_예외를_발생시킨다() {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> LottoNumbersInputParser.parse(""))
                    .withMessage(EMPTY_INPUT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "1, 2, , 4, 5, 6",
                "1, 2,4,,5, 6",
                "1, 2,, 4, ,  5, 6"
        })
        @DisplayName("빈 항목이 포함된 경우 예외를 발생시킨다.")
        public void 빈_항목이_포함된_입력에_예외를_발생시킨다(String input) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> LottoNumbersInputParser.parse(input))
                    .withMessage(EMPTY_PART_INPUT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "1,2,3,invalid,5,6",
                "1,2,3,#,5,6",
                "&,1,2,3,#,5,6,7"
        })
        @DisplayName("숫자가 아닌 값이 포함된 경우 예외를 발생시킨다.")
        public void 숫자가_아닌_값이_포함된_입력에_예외를_발생시킨다(String input) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> LottoNumbersInputParser.parse(input))
                    .withMessage(INVALID_VALUE_INPUT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {",1,2,3,4,5,6", "1,2,3,4,5,6,"})
        @DisplayName("입력 값의 시작이나 끝에 콤마가 포함된 경우 예외를 발생시킨다.")
        public void 시작이나_끝에_콤마가_포함된_입력에_예외를_발생시킨다(String input) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> LottoNumbersInputParser.parse(input))
                    .withMessage(INVALID_COMMA_POSITION.getMessage());
        }
    }
}
