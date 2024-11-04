package lotto;

import lotto.inputAction.InputPurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 번호에 1~45 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("올바른 로또 번호로 로또 객체가 정상 생성된다.")
    @Test
    void 로또_객체_정상_생성_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_천원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputPurchaseAmount.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 단위의 양수여야 합니다.");
    }

    @DisplayName("구입 금액이 0보다 작거나 같으면 예외가 발생한다.")
    @Test
    void 구입_금액이_음수_또는_0이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputPurchaseAmount.validatePurchaseAmount(-5000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 단위의 양수여야 합니다.");

        assertThatThrownBy(() -> InputPurchaseAmount.validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 단위의 양수여야 합니다.");
    }
}
