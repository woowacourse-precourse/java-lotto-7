package lotto.model;

import java.util.Arrays;
import lotto.exception.ErrorMessage;
import lotto.validator.WinnerLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerLottoTest {

    @Test
    void 입력된_당첨번호_문자열_배열의_크기가_6이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> WinnerLotto.from("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX.getMessage());

        assertThatThrownBy(() -> WinnerLotto.from("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX.getMessage());
    }

    @DisplayName("숫자 문자열 배열에 숫자 문자열이 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 숫자_문자열_배열에_숫자_문자열이_범위_내_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> WinnerLotto.from("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45.getMessage() + ": 0");

        assertThatThrownBy(() -> WinnerLotto.from("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45.getMessage() + ": 46");
    }

    @DisplayName("입력된 보너스 번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 입력된_보너스_번호가_범위_내_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> WinnerLotto.from("1,2,3,4,5,6").setBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45.getMessage() + ": 0");
    }

    @Test
    void 입력된_보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> WinnerLotto.from("1,2,3,4,5,6").setBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATES_WITH_WINNING_NUMBERS.getMessage());

        WinnerLottoValidator validator = new WinnerLottoValidator();
        assertThatThrownBy(() -> validator.checkForDuplicate(Arrays.asList(1, 2, 3, 4, 5), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_DUPLICATE.getMessage() + ": 5");
    }

    @Test
    void 입력된_보너스_번호에_숫자가_아닌값이_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> WinnerLotto.from("1,2,3,4,5,6").setBonusNumber("6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_MUST_BE_NUMBER.getMessage());
    }
}
