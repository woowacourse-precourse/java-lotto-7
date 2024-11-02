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

    @DisplayName("로또 구입금액은 0이하이면 예외가 발생한다.")
    @Test
    void 로또_구입금액은_0이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(-1))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("숫자는 1000 단위로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void 숫자는_1000_단위로_나누어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(1111))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
