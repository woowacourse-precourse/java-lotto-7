package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.LottoPurchaseAmountValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountValidatorTest {

    private LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    @BeforeEach
    void 테스트_사전작업() {
        this.lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();
    }

    @DisplayName("로또 구입금액이 음수 혹은 로또 가격으로 나눠떨어지지 않을 때 IllegalArgumentException을 발생시키는지")
    @ParameterizedTest
    @ValueSource(ints = {-1000, 1001})
    void 로또_구입금액이_음수일때(int amount) {
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.checkAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
