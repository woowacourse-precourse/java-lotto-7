package lotto.model;

import org.junit.jupiter.api.Test;

import static lotto.exception.ExceptionErrorMessage.INPUT_EXIST_REMAINS_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void 만원_압력시_10장의_복권을_살_수있다() {
        String purchaseAmount = "10000";

        int lottoCount = calculator.getLottoCount(purchaseAmount);

        assertThat(lottoCount).isEqualTo(10);
    }

    @Test
    public void 천_단위로_나누어지지_않은_경우에는_예외를_발생시킨다() {
        String purchaseAmount = "15001";

        assertThatThrownBy(() -> calculator.getLottoCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EXIST_REMAINS_MESSAGE.toString());
    }

    @Test
    public void 자료형_범위룰_넘는_경우에는_예외를_발생시킨다() {
        String purchaseAmount = "2147485000";

        assertThatThrownBy(() -> calculator.getLottoCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}