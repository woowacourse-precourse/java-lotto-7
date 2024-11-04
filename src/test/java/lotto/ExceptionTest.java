package lotto;

import lotto.model.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {
    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
    void 구입_금액_단위_테스트() {
        CustomException exception = CustomException.getInstance();

        assertThatThrownBy(() -> exception.purchaseAmountInputCheck("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다")
    void 당첨_번호_개수_테스트() {
        CustomException exception = CustomException.getInstance();

        assertThatThrownBy(() -> exception.winningNumberInputCheck("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 숫자");
    }
}
