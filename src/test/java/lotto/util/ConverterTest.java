package lotto.util;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.constant.ErrorMessage.NOT_A_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("== Converter 테스트 ==")
class ConverterTest {
    @Nested
    @DisplayName("-- 기능 테스트 --")
    class FeatureTest {
        @ParameterizedTest
        @DisplayName("1~45인 숫자 변환")
        @ValueSource(strings = {"1", "7", "8", "45"})
        void 숫자_변환(String number) {
            assertThat(Converter.toLottoNumber(number))
                    .isEqualTo(Integer.parseInt(number));
        }

        @ParameterizedTest
        @DisplayName("숫자 리스트 변환")
        @MethodSource("numberListsArguments")
        void 숫자_리스트_변환(String numbers, List<Integer> lottoNumbers) {
            assertIterableEquals(Converter.toLottoNumberList(numbers), lottoNumbers);
        }

        static Stream<Arguments> numberListsArguments() {
            return Stream.of(
                    Arguments.of("23,24,1,2,3,15", List.of(23, 24, 1, 2, 3, 15)),
                    Arguments.of("45,1,44,2", List.of(45, 1, 44, 2)),
                    Arguments.of("7,7,7", List.of(7, 7, 7))
            );
        }
    }

    @Nested
    @DisplayName("-- 예외 테스트 --")
    class ExceptionTest {
        @ParameterizedTest
        @DisplayName("1~45가 아닌 숫자")
        @ValueSource(strings = {"-777", "-1", "0", "46", "777"})
        void 범위_벗어남(String number) {
            assertThatThrownBy(() -> Converter.toLottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }

        @ParameterizedTest
        @DisplayName("숫자가 아닐 경우")
        @ValueSource(strings = {"not a number...", "", "   ", " 1 "})
        void 숫자_아님(String number) {
            assertThatThrownBy(() -> Converter.toLottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_A_NUMBER.getMessage());
        }

        @ParameterizedTest
        @DisplayName("1~45가 아닌 숫자 리스트")
        @ValueSource(strings = {"-1,46", "777", "-1,50,0"})
        void 범위_벗어난_숫자_리스트(String numbers) {
            assertThatThrownBy(() -> Converter.toLottoNumberList(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }

        @ParameterizedTest
        @DisplayName("숫자 아닌 숫자 리스트")
        @ValueSource(strings = {"hi,hi", ",", "1,2,"})
        void 숫자_아닌_숫자_리스트(String numbers) {
            assertThatThrownBy(() -> Converter.toLottoNumberList(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_A_NUMBER.getMessage());
        }
    }
}
