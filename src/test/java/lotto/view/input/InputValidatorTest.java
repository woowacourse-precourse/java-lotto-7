package lotto.view.input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void 구매_금액_검증_성공() {
        //given
        Integer amount = 10000;

        //then
        assertDoesNotThrow(() -> validator.validateAmount(amount));
    }

    @Test
    void 구매_금액_단위_검증_실패() {
        //given
        Integer amount = 10090;

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateAmount(amount));
    }

    @Test
    void 최대_구매_금액_검증_실패() {
        //given
        Integer amount = 100010;

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateAmount(amount));
    }

    @Test
    void 최소_구매_금액_검증_실패() {
        //given
        Integer amount = 100;

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateAmount(amount));
    }

    @Test
    void 당첨번호_개수_검증_성공() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        assertDoesNotThrow(() -> validator.validateWinningNumbers(winningNumbers));
    }

    @Test
    void 당첨번호_개수_검증_실패() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateWinningNumbers(winningNumbers));
    }

    @Test
    void 당첨번호_범위_검증_실패() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 49, 5, 62);

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateWinningNumbers(winningNumbers));
    }

    @Test
    void 보너스_번호_검증() {
        //given
        Integer bonusNumber = 7;

        //then
        assertDoesNotThrow(() -> validator.validateBonusNumber(bonusNumber));
    }

    @Test
    void 보너스_번호_검증_실패() {
        //given
        Integer bonusNumberZero = 0;
        Integer bonusNumberNegative = -1;
        Integer bonusNumberOver = 46;

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(bonusNumberZero));
        assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(bonusNumberNegative));
        assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(bonusNumberOver));
    }






}