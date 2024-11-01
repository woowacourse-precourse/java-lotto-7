package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @Test
    @DisplayName("구입 금액에 맞게 로또를 생성한다")
    void generateLottosWithPrice() {
        // given
        LottoGenerator generator = new LottoGenerator(5000);

        // when
        List<Lotto> lottos = generator.generateLottos();

        // then
        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("커스텀 번호 생성기로 로또를 생성한다")
    void generateLottosWithCustomNumberGenerator() {
        // given
        List<Integer> fixedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGenerator generator = new LottoGenerator(1000, () -> fixedNumbers);

        // when
        List<Lotto> lottos = generator.generateLottos();

        // then
        assertThat(lottos).hasSize(1);
        assertThat(lottos.getFirst().toString()).isEqualTo(fixedNumbers.toString());
    }

    @Test
    @DisplayName("1000원 단위가 아닌 금액으로 로또를 구매할 수 없다")
    void cannotPurchaseLottoWithInvalidPrice() {
        // given
        int invalidPrice = 1500;

        // when & then
        assertThatThrownBy(() -> new LottoGenerator(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("0원 이하의 금액으로 로또를 구매할 수 없다")
    void cannotPurchaseLottoWithZeroOrNegativePrice() {
        // given
        int invalidPrice = 0;

        // when & then
        assertThatThrownBy(() -> new LottoGenerator(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
