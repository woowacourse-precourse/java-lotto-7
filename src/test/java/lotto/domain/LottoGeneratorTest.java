package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.LottoGenerator;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 주어진_금액으로_결재_가능한_로또의_개수를_구한다() {
        assertThat(lottoGenerator.purchasableLottoCount(8000))
                .isEqualTo(8);
    }

    @Test
    void 주어진_금액이_1000원_단위로_나누어_떨어지지_않을_경우_예외처리한다() {
        assertThatThrownBy(() -> lottoGenerator.purchasableLottoCount(8300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
