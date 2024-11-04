package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다")
    @Test
    void 로또_구입_금액_단위_예외_테스트() {
        assertThatThrownBy(() -> Application.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("로또 구입 금액이 음수거나 0일 때 예외가 발생한다")
    @Test
    void 로또_구입_금액_음수_예외_테스트() {
        assertThatThrownBy(() -> Application.validatePurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1보다 커야 합니다.");

        assertThatThrownBy(() -> Application.validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1보다 커야 합니다.");
    }

    @DisplayName("유효한 로또 구입 금액이면 예외가 발생하지 않는다")
    @Test
    void 유효한_로또_구입_금액_테스트() {
        Application.validatePurchaseAmount(3000);
    }
}
