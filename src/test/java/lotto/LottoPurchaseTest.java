package lotto;

import lotto.model.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchase("5300"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void 구입_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchase("-5000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 최소 1000원 이상 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void 구입_금액이_0원이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchase("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 최소 1000원 이상 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchase("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 숫자만 입력해야 합니다.");
    }

    @DisplayName("올바른 구입 금액을 입력하면 정확한 로또 개수가 생성된다.")
    @Test
    void 기능_테스트_올바른_구입_금액을_입력한다() {
        LottoPurchase lottoPurchase = new LottoPurchase("5000");
        assertThat(lottoPurchase.getLottoAmount()).isEqualTo(5);
    }
}
