package lotto.util;

import java.util.List;
import lotto.enums.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {
    @Nested
    class WinningNumbers{
        @ParameterizedTest
        @ValueSource(strings = {"","0+1/3",",10,30,25"})
        void 올바른_형태의_숫자_목록_입력_검증_실패(String input) {
            Assertions.assertThatThrownBy(() -> LottoValidator.validateNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBERS_INPUT.format());
        }

        @Test
        void 정확히_6개의_숫자를_입력_검증_실패(){
            Assertions.assertThatThrownBy(() -> LottoValidator.validateNumbers("10,20,30"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBERS_COUNT.format());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,30,2,40,5,80","31,23,42,12,0,9"})
        void 유효_범위_내_숫자_입력_검증_실패(String input){
            Assertions.assertThatThrownBy(()-> LottoValidator.validateNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_IN_BOUNDARY.format());
        }

        @Test
        void 중복_숫자_입력_검증_실패(){
            Assertions.assertThatThrownBy(() -> LottoValidator.validateNumbers("10,1,2,3,4,10"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATED_NUMBERS.format());
        }

        @Test
        void 당첨_숫자_목록_입력_검증_성공(){
            LottoValidator.validateNumbers("3,9,15,43,2,20");
        }
    }

    @Nested
    class BonusNumber{
        List<Integer> winningNumbers = List.of(1,3,10,23,30,9);

        @ParameterizedTest
        @ValueSource(strings = {"","-1","+3",})
        void 숫자_형태_입력_검증_실패(String input){
            Assertions.assertThatThrownBy(() -> LottoValidator.validateBonusNumber(input,winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER_FORM.format());
        }

        @ParameterizedTest
        @ValueSource(strings = {"0","80"})
        void 유효_범위_내_숫자_입력_검증_실패(String input){
            Assertions.assertThatThrownBy(() -> LottoValidator.validateBonusNumber(input, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_IN_BOUNDARY.format());
        }

        @Test
        void 당첨_번호_목록과_중복되지_않은_숫자_검증_실패(){
            Assertions.assertThatThrownBy(() -> LottoValidator.validateBonusNumber("23",winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATED_WITH_WINNING_NUMBERS.format());
        }

        @Test
        void 보너스_번호_검증_성공(){
            LottoValidator.validateBonusNumber("17",winningNumbers);
        }
    }

}