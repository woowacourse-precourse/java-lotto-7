package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.Exception.ONLY_DIVISIBLE_BY_THOUSAND;
import static org.junit.jupiter.api.Assertions.*;

class LottoAmountTest {

    @Test
    @DisplayName("유효한 금액으로 LottoAmount 객체가 생성되는지 테스트")
    void createLottoAmount_ValidAmount() {
        int validAmount = 5000;

        LottoAmount lottoAmount = new LottoAmount(validAmount);

        assertEquals(validAmount, lottoAmount.getAmount());
    }

    @Test
    @DisplayName("금액이 1000으로 나누어떨어지지 않을 때 예외가 발생하는지 테스트")
    void createLottoAmount_InvalidAmount() {
        int invalidAmount = 1001; // 1000으로 나누어떨어지지 않음

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new LottoAmount(invalidAmount);
        });
        assertEquals(ONLY_DIVISIBLE_BY_THOUSAND.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("금액이 0일 때 예외가 발생하는지 테스트")
    void createLottoAmount_ZeroAmount() {
        int zeroAmount = 0;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new LottoAmount(zeroAmount);
        });
        assertEquals(ONLY_DIVISIBLE_BY_THOUSAND.getMessage(), thrown.getMessage());
    }
}
