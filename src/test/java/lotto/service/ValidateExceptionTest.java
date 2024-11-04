package lotto.service;

import lotto.constants.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateExceptionTest {
    Validate validate;
    @BeforeEach
    void setUp () {
        validate = new Validate();
    }

    @Test
    void 로또_구입_실패_숫자가_아닌_입력() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> validate.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_A_NUMBER);
    }
    @Test
    void 로또_구입_실패_1000원_단위가_아닌_입력() {
        // given
        String input = "5001";

        // when & then
        assertThatThrownBy(() -> validate.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_AMOUNT_UNIT);
    }
    @Test
    void 로또_구입_실패_1000원_미만_입력() {
        // given
        String input = "500";

        // when & then
        assertThatThrownBy(() -> validate.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    void 당첨_번호_입력_실패_숫자_아님() {
        // given
        String input = "a,b,c,d,e, ";

        // when & then
        assertThatThrownBy(() -> validate.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_A_NUMBER);
    }
    @Test
    void 당첨_번호_입력_실패_6개_미만() {
        // given
        String input = "1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> validate.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
    }
    @Test
    void 당첨_번호_입력_실패_6개_초과() {
        // given
        String input = "1,2,3,4,5,6,7";

        // when & then
        assertThatThrownBy(() -> validate.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
    }
    @Test
    void 당첨_번호_입력_실패_번호_1미만() {
        // given
        String input = "1,2,3,4,5,-6";

        // when & then
        assertThatThrownBy(() -> validate.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }
    @Test
    void 당첨_번호_입력_실패_번호_45초과() {
        // given
        String input = "1,2,3,4,5,46";

        // when & then
        assertThatThrownBy(() -> validate.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }
    @Test
    void 당첨_번호_입력_실패_중복() {
        // given
        String input = "1,2,3,4,5,5";

        // when & then
        assertThatThrownBy(() -> validate.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
    }

    @Test
    void 보너스_번호_입력_실패_숫자_아님() {
        // given
        String input = "a";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThatThrownBy(() -> validate.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_A_NUMBER);
    }
    @Test
    void 보너스_번호_입력_실패_번호_1미만() {
        // given
        String input = "-1";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThatThrownBy(() -> validate.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }
    @Test
    void 보너스_번호_입력_실패_번호_45초과() {
        // given
        String input = "46";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThatThrownBy(() -> validate.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }
}
