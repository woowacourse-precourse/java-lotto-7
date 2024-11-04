package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneratorTest {

    @Test
    @DisplayName("구매금액이 1000원 단위가 아니면 예외가 발생한다.")
    void 구매금액_1000원_단위_아니면_예외() {
        assertThatThrownBy(() -> new LottoGenerator("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("구매금액이 숫자가 아니면 예외가 발생한다.")
    void 구매금액이_숫자가_아니면_예외() {
        assertThatThrownBy(() -> new LottoGenerator("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매금액은 숫자로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("입력한 금액에 따라 생성된 로또의 개수가 맞는지 확인한다.")
    void 로또_개수_확인() {
        LottoGenerator generator = new LottoGenerator("5000");
        List<Lotto> lottos = generator.getLottos();

        assertEquals(5, lottos.size());
    }

    @Test
    @DisplayName("생성된 각 로또 번호가 6개의 번호로 이루어져 있는지 확인한다.")
    void 로또_번호_개수_확인() {
        LottoGenerator generator = new LottoGenerator("3000");
        List<Lotto> lottos = generator.getLottos();

        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
        }
    }

    @Test
    @DisplayName("각 로또 번호에 중복된 숫자가 없는지 확인한다.")
    void 로또_번호_중복_확인() {
        LottoGenerator generator = new LottoGenerator("3000");
        List<Lotto> lottos = generator.getLottos();

        for (Lotto lotto : lottos) {
            long uniqueCount = lotto.getNumbers().stream().distinct().count();
            assertEquals(6, uniqueCount);
        }
    }
}
