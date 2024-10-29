package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchaseLotto;
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

    @DisplayName("구매한 로또 게임 장수를 확인한다.")
    @Test
    void 로또_구매_장수_테스트() {
        PurchaseLotto purchaseLotto = new PurchaseLotto(8000);

        assertThat(purchaseLotto.calculateLottoGameCount()).isEqualTo(8);
    }

    @DisplayName("구매할 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 로또_구매_금액_1000원_미만_예외_테스트() {
        assertThatThrownBy(() -> new PurchaseLotto(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매할 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_구매_금액_1000원_단위가_아닐때_예외_테스트() {
        assertThatThrownBy(() -> new PurchaseLotto(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
