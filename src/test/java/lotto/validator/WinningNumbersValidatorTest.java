package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    @DisplayName("정상적인 당첨번호 입력시 false를 반환한다")
    @Test
    void 정상적인_당첨번호_입력시_false를_반환한다() {
        // given
        WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();
        String userInput = "1,2,3,4,5,6";

        // when
        boolean result = winningNumbersValidator.isNotValidWinningNumbers(userInput);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("숫자로 변환할 수 없는 문자 포함시 true를 반환한다")
    @Test
    void 숫자로_변환할_수_없는_문자_포함시_true를_반환한다() {
        WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();
        String userInput = "1 ,2,3,4,5,6";

        // when
        boolean result = winningNumbersValidator.isNotValidWinningNumbers(userInput);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("로또 범위를 넘는 숫자 포함시 true를 반환한다")
    @Test
    void 로또_범위를_넘는_숫자_포함시_true를_반환한다() {
        WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();
        String userInput = "46,2,3,4,5,6";

        // when
        boolean result = winningNumbersValidator.isNotValidWinningNumbers(userInput);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("숫자 개수가 6이 아닌 경우 true를 반환한다")
    @Test
    void 숫자_개수가_6이_아닌_경우_true를_반환한다() {
        WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();
        String userInput = "1,2,3,4,5";

        // when
        boolean result = winningNumbersValidator.isNotValidWinningNumbers(userInput);

        // then
        assertThat(result).isTrue();
    }
}