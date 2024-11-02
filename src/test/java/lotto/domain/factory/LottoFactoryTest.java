package lotto.domain.factory;

import static lotto.config.ErrorMessageConstant.PURCHASE_REMINDER_MESSAGE;
import static lotto.config.ErrorMessageConstant.PURCHASE_TOO_LOW_MESSAGE;
import static lotto.config.GameConstant.PRICE_OF_LOTTO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @Test
    void 로또_구매_성공() {
        assertDoesNotThrow(() ->
                LottoFactory.generateLotto(PRICE_OF_LOTTO)
        );
    }

    @Test
    void 최소_주문금액_미충족() {
        int purchase = PRICE_OF_LOTTO / 2;
        assertThatThrownBy(() -> LottoFactory.generateLotto(purchase))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_TOO_LOW_MESSAGE);
    }

    @Test
    void 거스름돈_발생() {
        int purchase = PRICE_OF_LOTTO + 1;
        assertThatThrownBy(() -> LottoFactory.generateLotto(purchase))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_REMINDER_MESSAGE);
    }
}