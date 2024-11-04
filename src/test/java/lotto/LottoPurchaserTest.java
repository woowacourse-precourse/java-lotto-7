package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.HashSet;

public class LottoPurchaserTest {

    private LottoPurchaser lottoPurchaser;

    @BeforeEach
    @DisplayName("로또를 5개 구입한다.")
    void setup() {
        lottoPurchaser = new LottoPurchaser("5000");
    }

    @Test
    void 구입한_로또의_개수가_5개가_아니면_예외가_발생한다() {
        List<Lotto> purchasedLottos = lottoPurchaser.purchaseLotto();
        assertThat(purchasedLottos.size()).isEqualTo(5);
    }

    @Test
    void 구입한_로또_번호의_개수와_범위_및_중복을_확인() {
        List<Lotto> purchaseLottos = lottoPurchaser.purchaseLotto();
        for (Lotto purchasedLotto : purchaseLottos) {
            List<Integer> numbers = purchasedLotto.getNumbers();
            assertThat(numbers).hasSize(6);
            assertThat(new HashSet<>(numbers).size()).isEqualTo(6);
            assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
        }
    }
}
