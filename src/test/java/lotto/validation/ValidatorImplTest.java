package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorImplTest {

    private ValidatorImpl validator;

    @BeforeEach
    void setUp() {
        validator = new ValidatorImpl();
    }

    @Test
    void 구매_금액_유효성() {
        validateInvalidAmounts("abc", "[ERROR] 구매 금액은 숫자여야 합니다.");
        validateInvalidAmounts("0", "[ERROR] 구매 금액은 0보다 커야 합니다.");
        validateInvalidAmounts("-1000", "[ERROR] 구매 금액은 0보다 커야 합니다.");
        validateInvalidAmounts("500", "[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");

        assertEquals(1000, validator.validate("1000"));
        assertEquals(2000, validator.validate("2000"));
    }

    @Test
    void 입력값_정수_변환() {
        assertEquals(1000, validator.parseInput("1000"));
        assertThrows(IllegalArgumentException.class, () -> validator.parseInput("abc"),
                "[ERROR] 구매 금액은 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호_유효성_검사() {
        assertDoesNotThrow(() -> validator.winningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        validateWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 46),
                "[ERROR] 번호는 1부터 45 사이여야 합니다.");
        validateWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 5),
                "[ERROR] 번호는 중복될 수 없습니다.");
    }

    @Test
    void 보너스_번호_유효성_검사() {
        assertDoesNotThrow(() -> validator.validateBonusNumber(7, Arrays.asList(1, 2, 3, 4, 5, 6)));

        validateBonusNumber(46, Arrays.asList(1, 2, 3, 4, 5, 6),
                "[ERROR] 번호는 1부터 45 사이여야 합니다.");
        validateBonusNumber(1, Arrays.asList(1, 2, 3, 4, 5, 6),
                "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    private void validateInvalidAmounts(String input, String expectedMessage) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input), expectedMessage);
    }

    private void validateWinningNumbers(java.util.List<Integer> numbers, String expectedMessage) {
        assertThrows(IllegalArgumentException.class, () -> validator.winningNumbers(numbers), expectedMessage);
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers, String expectedMessage) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateBonusNumber(bonusNumber, winningNumbers),
                expectedMessage);
    }
}
