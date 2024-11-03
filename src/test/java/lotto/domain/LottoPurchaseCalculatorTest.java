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
}