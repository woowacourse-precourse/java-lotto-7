package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    @DisplayName("유효한 구매 금액으로 로또가 올바르게 생성된다.")
    void 유효한_구매_금액으로_로또가_올바르게_생성된다() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount);
        assertThat(lottos).hasSize(5);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).isSorted();
            assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
        }
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void 구매_금액이_1000원_단위가_아니면_예외가_발생한다() {
        int invalidAmount = 1500;
        assertThatThrownBy(() -> LottoGenerator.generateLottos(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("구매 금액이 0보다 작거나 같으면 예외가 발생한다.")
    void 구매_금액이_0보다_작거나_같으면_예외가_발생한다() {
        int invalidAmount = 0;
        assertThatThrownBy(() -> LottoGenerator.generateLottos(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    }
}