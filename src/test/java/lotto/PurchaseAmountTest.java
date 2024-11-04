package lotto;

import lotto.exception.InputValidator;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {
    @Test
    void 로또_구입_금액에_숫자_이외의_문자가_포함된_문자열을_입력한_경우() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않는_경우() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1300"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_10만원을_넘어가는_경우() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("150000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_로또_구입_금액은_예외를_발생시키지_않는다() {
        assertSimpleTest(() ->
                assertThatCode(() -> InputValidator.validatePurchaseAmount("10000")).doesNotThrowAnyException()
        );
    }
}
