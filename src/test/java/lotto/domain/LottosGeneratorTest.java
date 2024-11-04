package lotto.domain;

import static lotto.util.Constants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosGeneratorTest {
    @Test
    void 로또_생성() {
        NumbersGenerator testGenerator = new TestNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));
        LottosGenerator lottosGenerator = new LottosGenerator(testGenerator);

        int purchaseAmount = LOTTO_PRICE * 3;
        List<Lotto> lottos = lottosGenerator.generate(purchaseAmount);

        assertThat(lottos).hasSize(3);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        }
    }
}
