package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.model.lotto.PurchaseAmount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @Test
    void 구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> PurchaseAmount.from("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> PurchaseAmount.from("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 입력_받은_구입_금액이_숫자가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> PurchaseAmount.from("1000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 입력_받은_구입_금액이_빈_값일_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
