package lotto.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {
    @DisplayName("입력한 금액이 1,000원 단위가 아니라면 예외가 발생한다")
    @Test
    void 입력한_금액이_1000원_단위가_아니라면_예외가_발생한다() {
        // given
        InputValidation inputValidation = new InputValidation();
        String money = "1234";

        // when & then
        assertThatThrownBy(() -> inputValidation.moneyValidation(money))
                .isInstanceOf(IllegalArgumentException.class);
    }


}