package lotto.model;

import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.INVALID_WINNING_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_DUPLICATED_NUMBERS;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_STARTING_WITH_COMMA;
import static lotto.constants.ErrorMessage.WINNING_NUMBERS_MUST_CONTAIN_COMMA;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {
    @Test
    void 문장_맨_앞에_공백이_오는_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = " 1,2,3,4,5,6";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    @Test
    void 문장_맨_뒤에_공백이_오는_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = "1,2,3,4,5,6 ";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    @Test
    void 문장_맨_앞_맨_뒤에_공백이_오는_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = " 1,2,3,4,5,6 ";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    @Test
    void 입력에_쉼표가_포함_되지_않는_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = "123456";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(WINNING_NUMBERS_MUST_CONTAIN_COMMA);
    }

    @Test
    void 입력이_쉼표로_시작_되는_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = ",1,2,3,4,5,6";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(NOT_ALLOWED_STARTING_WITH_COMMA);
    }

    @Test
    void 정수가_입력_되지_않은_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = "string,1,2,3,4,5";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(INPUT_VALUE_MUST_BE_NUMERIC);
    }

    @Test
    void 입력된_정수의_개수가_6개가_아닌_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = "1,2,3,4,5,6,7";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(INVALID_WINNING_NUMBER_COUNT);
    }

    @Test
    void 입력된_정수_중_1_이하_정수가_입력_된_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = "0,1,2,3,4,5";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(INVALID_NUMBER_RANGE);
    }

    @Test
    void 입력된_정수_중_45_이상_정수가_입력_된_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = "1,2,3,4,5,46";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(INVALID_NUMBER_RANGE);
    }

    @Test
    void 중복되는_정수가_입력_된_경우_예외가_발생한다() {
        // given
        String rawWinningNumbers = "1,2,3,4,5,5";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(rawWinningNumbers))
                .withMessage(NOT_ALLOWED_DUPLICATED_NUMBERS);
    }
}