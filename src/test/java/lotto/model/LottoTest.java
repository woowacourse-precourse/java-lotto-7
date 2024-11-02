package lotto.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.config.LottoConstants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("구매 금액에 따른 로또 수 일치")
    @Test
    void buyLottos_ShouldReturnCorrectNumberOfLottos_WhenGivenPurchaseAmount() {
        int purchaseAmount = 5000;
        int expectedLottoCount = purchaseAmount / LOTTO_PRICE;

        List<Lotto> lottos = Lotto.buyLottos(purchaseAmount);

        assertEquals(expectedLottoCount, lottos.size(), "구매 금액에 따라 로또 수가 정확해야 합니다.");
    }

    @DisplayName("모든 로또 번호가 유일한가")
    @Test
    void buyLottos_ShouldReturnUniqueLottos() {
        int purchaseAmount = 3000;
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        List<Lotto> lottos = Lotto.buyLottos(purchaseAmount);

        assertEquals(lottoCount, lottos.size(), "로또 수는 구매한 수와 일치해야 합니다.");

        Set<Lotto> uniqueLottos = new HashSet<>(lottos);
        assertEquals(uniqueLottos.size(), lottos.size(), "모든 로또 번호는 유일해야 합니다.");
    }
}
