package lotto.user.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserValidatorTest {

    @DisplayName("참 | 1,000원 단위인 경우")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 11000, 200000, 231000})
    void should_ReturnTrue_When_CheckNumberIsMultipleOfThousand(int money) {
        assertTrue(UserValidator.MULTIPLE_OF_THOUSAND.check(money));
    }

    @DisplayName("거짓 | 1,000원 단위가 아닌 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 100, 999, 1001, 1101, 1999, 2001, 2301})
    void should_ReturnFalse_When_CheckNumberIsNotMultipleOfThousand_ReturnFalse(int money) {
        assertFalse(UserValidator.MULTIPLE_OF_THOUSAND.check(money));
    }

    @DisplayName("참 | 0원 이상인 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, 999})
    void should_ReturnTrue_When_CheckNumberIsOverThanLottoPrice(int money) {
        assertTrue(UserValidator.OVER_THAN_ZERO.check(money));
    }

    @DisplayName("거짓 | 0원 미만인 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -100000})
    void should_ReturnFalse_When_CheckNumberIsUnderThanLottoPrice(int money) {
        assertFalse(UserValidator.OVER_THAN_ZERO.check(money));
    }
}