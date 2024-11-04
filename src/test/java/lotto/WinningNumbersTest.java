package lotto;

import static lotto.service.exception.LottoExceptionMessage.INVALID_WINNING_NUMBERS;
import static lotto.service.exception.LottoExceptionMessage.WINNING_NUMBERS_DUPLICATED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.service.exception.LottoException;
import lotto.view.validation.WinningNumbersValidator;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 당첨_번호가_콤마로만_구분되지_않는다면_예외발생() {
        // given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        // when & then
        LottoException e = assertThrows(LottoException.class, () -> {
            WinningNumbersValidator.validate(winningNumbers);
        });
        assertEquals(INVALID_WINNING_NUMBERS.message(), e.getMessage());
    }

    @Test
    void 당첨_번호가_콤마로_시작한다면_예외발생() {
        // given
        String winningNumbers = ",1,2,3,4,5,6";
        // when & then
        LottoException e = assertThrows(LottoException.class, () -> {
            WinningNumbersValidator.validate(winningNumbers);
        });
        assertEquals(INVALID_WINNING_NUMBERS.message(), e.getMessage());
    }

    @Test
    void 당첨_번호가_콤마로_끝난다면_예외발생() {
        // given
        String winningNumbers = "1,2,3,4,5,6,";
        // when & then
        LottoException e = assertThrows(LottoException.class, () -> {
            WinningNumbersValidator.validate(winningNumbers);
        });
        assertEquals(INVALID_WINNING_NUMBERS.message(), e.getMessage());
    }

    @Test
    void 당첨_번호를_5개의_숫자로_입력한다면_예외발생() {
        // given
        String winningNumbers = "1,2,3,4,5";
        // when & then
        LottoException e = assertThrows(LottoException.class, () -> {
            WinningNumbersValidator.validate(winningNumbers);
        });
        assertEquals(INVALID_WINNING_NUMBERS.message(), e.getMessage());
    }

    @Test
    void 당첨_번호를_7개의_숫자로_입력한다면_예외발생() {
        // given
        String winningNumbers = "1,2,3,4,5,6,7";
        // when & then
        LottoException e = assertThrows(LottoException.class, () -> {
            WinningNumbersValidator.validate(winningNumbers);
        });
        assertEquals(INVALID_WINNING_NUMBERS.message(), e.getMessage());
    }

    @Test
    void 당첨_번호가_중복된다면_예외발생() {
        // given
        String winningNumbers = "1,2,3,4,5,5";
        // when & then
        LottoException e = assertThrows(LottoException.class, () -> {
            WinningNumbersValidator.validate(winningNumbers);
        });
        assertEquals(WINNING_NUMBERS_DUPLICATED.message(), e.getMessage());
    }
}
