package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class LottoPurchaserTest {

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchaser("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액에_숫자가_아닌_값이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchaser("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액에_따라_올바른_개수의_로또가_생성된다() {
        LottoPurchaser lottoPurchaser = new LottoPurchaser("5000");
        List<Lotto> purchasedLottos = lottoPurchaser.purchaseLotto();
        assertThat(purchasedLottos.size()).isEqualTo(5);
    }

    @Test
    void 각_로또_번호는_1에서_45_사이의_고유한_6개_번호로_구성된다() {
        LottoPurchaser lottoPurchaser = new LottoPurchaser("5000");
        List<Lotto> purchasedLottos = lottoPurchaser.purchaseLotto();

        for (Lotto lotto : purchasedLottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6);
            assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
            assertThat(numbers.stream().distinct().count()).isEqualTo(6);
        }
    }
}