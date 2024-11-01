package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputExceptionTest {

    @DisplayName("구입 금액이 숫자 형식이 아니거나 음수일 경우, 1,000으로 나누어지지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,000", "", "-1000", "1500"})
    void 구입_금액_예외_테스트(String purchaseAmount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPurchase(purchaseAmount))
                .withMessageMatching("^\\[ERROR\\].*");
    }
}
