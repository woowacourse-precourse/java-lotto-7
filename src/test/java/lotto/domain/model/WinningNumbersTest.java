package lotto.domain.model;

import lotto.domain.model.winning.WinningNumbers;
import lotto.exception.winning.WinningNumbersErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class WinningNumbersTest {

    @Test
    @DisplayName("빈 문자열을 입력할 경우 예외가 발생한다.")
    void 빈_문자열을_입력할_경우_예외가_발생한다() {
        String emptyNumbers = "";

        assertThatNullPointerException()
                .isThrownBy(() -> new WinningNumbers(emptyNumbers))
                .withMessage(WinningNumbersErrorMessages.INVALID_EMPTY.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 예외가 발생한다.")
    void 당첨_번호_6개_아닐_경우_예외가_발생한다() {
        String invalidNumbers = "1,2,3,4,5";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(invalidNumbers))
                .withMessage(WinningNumbersErrorMessages.INVALID_SIZE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    void 당첨_번호_중복_숫자_예외가_발생한다() {
        String duplicateNumbers = "1,2,3,4,5,5";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(duplicateNumbers))
                .withMessage(WinningNumbersErrorMessages.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 범위가 벗어날 경우 예외가 발생한다.")
    void 당첨_번호_범위가_벗어날_경우_예외가_발생한다() {
        String outOfRangeNumbers = "0,2,3,4,5,6";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(outOfRangeNumbers))
                .withMessage(WinningNumbersErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("입력된 문자열에 숫자 외에 문자가 있을 경우 예외가 발생한다.")
    void 입력된_문자열에_숫자_외에_문자가_있을_경우_예외가_발생한다() {
        String numbersWithAlphabet = "1,2,a,4,5,6";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(numbersWithAlphabet))
                .withMessage(WinningNumbersErrorMessages.INVALID_CHARACTER.getMessage());
    }
}