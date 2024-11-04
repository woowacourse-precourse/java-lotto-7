package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings ={"a", ",", "Ahn"})
    void 문자가_입력되면_예외가_발생한다(final String num) {
        //given
        final String expectedMessage = "[ERROR] 구입 금액은 문자가 아닌 숫자여야 합니다.";

        //when & then
        assertThatThrownBy(() -> new PurchaseAmount(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}