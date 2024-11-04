package lotto.validation;


import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoContextValidatorTest {
    @Test
    @DisplayName("입력 개수가 6개가 아닐 때")
    void notEnoughOrOverNumber() {
        LottoException under = Assertions.assertThrows(LottoException.class,
                () -> LottoContextValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5)));
        Assertions.assertEquals(LottoExceptionCode.NOT_VALID_NUMBER_OF_WINNING_NUMBER, under.getCode());
        LottoException over = Assertions.assertThrows(LottoException.class,
                () -> LottoContextValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)));
        Assertions.assertEquals(LottoExceptionCode.NOT_VALID_NUMBER_OF_WINNING_NUMBER, over.getCode());
    }

    @Test
    @DisplayName("중복 숫자 존재")
    void duplicatedNumber() {
        LottoException dup = Assertions.assertThrows(LottoException.class,
                () -> LottoContextValidator.validateWinningNumbers(List.of(1, 1, 2, 3, 4, 5)));
        Assertions.assertEquals(LottoExceptionCode.DUPLICATED_WINNING_NUMBERS, dup.getCode());
    }

    @Test
    @DisplayName("보너스 중복")
    void bonusDup() {
        LottoException dup = Assertions.assertThrows(LottoException.class,
                () -> LottoContextValidator.validateBonusNumber(6, List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertEquals(LottoExceptionCode.DUPLICATED_BONUS_NUMBER, dup.getCode());
    }
}