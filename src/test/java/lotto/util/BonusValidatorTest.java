package lotto.util;

import lotto.model.lotto.Lotto;
import lotto.util.ExceptionMessage;
import lotto.util.validator.BonusValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusValidatorTest {
    private BonusValidator bonusValidator;
    private Lotto 유효한로또;

    @BeforeEach
    public void setUp() {
        bonusValidator = new BonusValidator();
        유효한로또 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Nested
    class 정상입력테스트 {
        @Test
        public void 유효한보너스번호_검증() {
            assertDoesNotThrow(() -> bonusValidator.validate("7"));
        }

        @Test
        public void 당첨번호와_중복되지않는보너스번호_검증() {
            assertDoesNotThrow(() -> bonusValidator.validateDuplicates("7", 유효한로또));
        }
    }

    @Nested
    class 비정상입력테스트 {
        @Test
        public void 범위를벗어난보너스번호_검증() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> bonusValidator.validate("50")
            );
            assert(exception.getMessage().contains(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage()));
        }

        @Test
        public void 당첨번호와_중복된보너스번호_검증() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> bonusValidator.validateDuplicates("3", 유효한로또)
            );
            assert(exception.getMessage().contains(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage()));
        }
    }
}