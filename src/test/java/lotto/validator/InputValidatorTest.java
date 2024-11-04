package lotto.validator;

import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @Nested
    class validateInputAmount_메서드_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {"", "0"})
        @NullSource
        @DisplayName("validateInput 메서드 테스트")
        void 빈_값이나_0을_입력하면_예외가_발생한다(String input) {
            //given
            //when & then
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputAmount(input);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"01000", "9000a", "abc", "-1000", "1000.50", "1000 ", " 5000"})
        void 숫자가_아닌_문자를_입력하면_예외가_발생한다(String input) {
            //given
            //when & then
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputAmount(input);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1500", "160001", "199999"})
        void 천_원_단위로_나누어_떨어지지_않으면_예외가_발생한다(String input) {
            //given
            //when & then
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputAmount(input);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000", "160000", "5000000", "123000"})
        void 천_원_단위로_나누어_떨어지는_숫자_입력_시_테스트를_성공한다(String input) {
            //given
            //when & then
            assertDoesNotThrow(() -> validator.validateInputAmount(input));
        }
    }

    @Nested
    class validateInputNumbers_메서드_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {",", "1,2,3,4,5,6,", ",1,2,3,4,5", ",1,2,3,4,5,6","1,2,3,4,5,6,,"})
        void 구분자가_앞_뒤로_숫자가_존재하지_않으면_예외_발생(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputNumbers(input);
            });
        }
        @ParameterizedTest
        @ValueSource(strings = {"", ",", "a,b,c,d,e,f", "1,2,3,4,5"})
        void 숫자_6개를_만족하지_못하면_예외가_발생해야_한다(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputNumbers(input);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46", "1,2,3,4,45,100"})
        void 숫자_6개를_만족하지만_범위가_1부터_45가_아니면_예외가_발생해야_한다(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputNumbers(input);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,5", "1,1,1,1,1,1", "11,3,5,7,9,11"})
        void 중복_숫자가_존재하면_예외가_발생해야_한다(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputNumbers(input);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,41,42", "1,3,5,7,9,11","5,7,10,20,45,3"})
        void 정상_범위_숫자_6개는_성공한다(String input) {
            assertDoesNotThrow(() -> validator.validateInputNumbers(input));
        }
    }

    @Nested
    class validateInputBonusNumber_메서드_테스트 {
        @ParameterizedTest
        @MethodSource("bonusNumberRangeTest")
        void 일부터_사십_오_범위가_아닌_보너스_번호는_예외_발생(List<Integer> winnerNumbers, String bonusNumber) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputBonusNumber(winnerNumbers, bonusNumber);
            });
        }

        @ParameterizedTest
        @MethodSource("WinnerAndBonusNumbersForDuplicationTest")
        void 당첨_번호와_보너스_번호가_겹치면_예외가_발생한다(List<Integer> winnerNumbers, String bonusNumber) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateInputBonusNumber(winnerNumbers, bonusNumber);
            });
        }

        static Stream<Arguments> WinnerAndBonusNumbersForDuplicationTest() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), "3"),
                    Arguments.of(List.of(10, 20, 30, 40, 45, 6), "10"),
                    Arguments.of(List.of(1, 15, 23, 35, 40, 45), "45")
            );
        }

        static Stream<Arguments> bonusNumberRangeTest() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), "0"),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), "46"),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), "100")
            );
        }
    }




}