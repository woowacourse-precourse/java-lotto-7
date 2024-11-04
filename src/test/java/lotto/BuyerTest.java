package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {
    @DisplayName("입력 금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void 입력_금액이_1000단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Buyer("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 입력_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Buyer("이천원"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
