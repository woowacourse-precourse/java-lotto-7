package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.LottoStore;
import lotto.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @Test
    void 로또_구입_금액이_1000의_배수가_아니면_예외가_발생한다() {
        String input = "1500";

        assertThatThrownBy(() -> lottoStore.purchaseLottos(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000 단위여야 합니다.");
    }

    @Test
    void 로또_구입_금액이_최소_금액_미만이면_예외가_발생한다() {
        String input = "500";

        assertThatThrownBy(() -> lottoStore.purchaseLottos(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 로또 한장의 가격 이상이어야 합니다.");
    }

    @Test
    void 로또_구입_입력이_숫자가_아니면_예외가_발생한다() {
        String input = "abc";

        assertThatThrownBy(() -> lottoStore.purchaseLottos(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자여야 합니다.");
    }
}
