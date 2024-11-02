package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    private final static String ERROR_NOT_DIVISIBLE_BY_1000 = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";

    @Test
    public void 구입_금액이_1000으로_나누어_떨어지지_않으면_예외_발생() {
        // given
        String input = "1200";

        // when & then
        Assertions.assertThatThrownBy(() -> Parser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_DIVISIBLE_BY_1000);
    }

    @Test
    public void 구입_금액이_1000으로_나누어_떨어지면_정상() {
        // given
        String input = "1000";
        int result = 1000;

        // when
        int purchaseAmount = Parser.parsePurchaseAmount(input);

        // then
        Assertions.assertThat(purchaseAmount).isEqualTo(result);
    }
}
