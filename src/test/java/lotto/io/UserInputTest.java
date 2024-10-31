package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserInputTest {

    UserInput userInput = new UserInput();

    @Test
    void 유효한_로또_구매_금액_입력_테스트() {
        //given
        String lottoPurchaseAmountInput = "5000";

        //when
        long lottoPurchaseAmount = userInput.getLottoPurchaseAmount(lottoPurchaseAmountInput);

        //then
        assertThat(lottoPurchaseAmount).isEqualTo(5000);
    }

    @Test
    void 로또_구매_금액_입력을_숫자로_변환할_수_없을_때_예외_테스트() {
        //given
        String lottoPurchaseAmountInput = "5,000";

        //then
        assertThatThrownBy(() ->
                userInput.getLottoPurchaseAmount(lottoPurchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 숫자입니다.");
    }

    @Test
    void 로또_구매_금액_입력이_1000원_단위로_나누어_떨어지지_않을_때_예외_테스트() {
        //given
        String lottoPurchaseAmountInput = "5001";

        //then
        assertThatThrownBy(() ->
                userInput.getLottoPurchaseAmount(lottoPurchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
    }

}