package lotto.domain;

import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoPurchaseCalculatorTest {
    private LottoPurchaseCalculator lottoPurchaseCalculator;
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
        lottoPurchaseCalculator = new LottoPurchaseCalculator(randomNumberGenerator);
    }

    @Test
    @DisplayName("유효한 금액 입력 시 로또 개수 반환")
    void testGetLottoCount() {
        int lottoCount = lottoPurchaseCalculator.getLottoCount("3000");
        assertThat(lottoCount).isEqualTo(3);
    }

    @Test
    @DisplayName("금액이 숫자가 아닐 경우 예외 발생")
    void testGetLottoCountWithInvalidPrice() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            lottoPurchaseCalculator.getLottoCount("invalid");
        });
        assertEquals("[ERROR] 구매 금액은 숫자여야 합니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("금액이 1000보다 작을 경우 예외 발생")
    void testGetLottoCountWithPriceLessThan1000() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            lottoPurchaseCalculator.getLottoCount("500");
        });
        assertEquals("[ERROR] 금액은 1000 이상이어야 합니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않는 금액 입력 시 예외 발생")
    void testGetLottoCountWithNonDivisiblePrice() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            lottoPurchaseCalculator.getLottoCount("1500");
        });
        assertEquals("[ERROR] 구입 금액은 1000 단위여야 합니다.", thrown.getMessage());
    }
}
