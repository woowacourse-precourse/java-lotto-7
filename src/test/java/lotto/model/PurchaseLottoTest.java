package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseLottoTest {

    @Test
    public void 올바른_형식의_구매_금액() throws NoSuchFieldException, IllegalAccessException {
        PurchaseLotto purchaseLotto = new PurchaseLotto("10000");
        Field moneyField = purchaseLotto.getClass().getDeclaredField("money");
        moneyField.setAccessible(true);

        assertEquals(10000, moneyField.get(purchaseLotto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000원", "만원", " ", ""})
    void 구매_금액을_숫자로_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new PurchaseLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}