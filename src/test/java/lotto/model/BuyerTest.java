package lotto.model;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {

    @Test
    void 입력된_로또_구입_금액에_숫자가_아닌_문자열이_포홤되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Buyer.from("1200$"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_NUMBER.getMessage());
        });
    }

    @DisplayName("입력된 로또 구입 금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void 입력된_로또_구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Buyer.from("900"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_AT_LEAST_1000.getMessage());
        });
    }

    @DisplayName("입력된 로또 구입 금액이 1,000원으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 입력된_로또_구입_금액이_1000원으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Buyer.from("1200"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000.getMessage());
        });
    }

    @Test
    void 입력된_로또_구입_금액이_int의_범위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Buyer.from(String.valueOf((long) Integer.MAX_VALUE + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_AMOUNT_TOO_LARGE.getMessage());
    }
}
