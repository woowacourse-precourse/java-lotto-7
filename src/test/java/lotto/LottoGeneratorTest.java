package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.PurchasedLottos;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void 구입_금액에_맞는_개수_생성() {
        PurchasedLottos lottos = lottoGenerator.generateLottos(5000);
        assertThat(lottos.getSize()).isEqualTo(5);
    }

    @Test
    void 구입_금액_0원으로_0개_생성() {
        PurchasedLottos lottos = lottoGenerator.generateLottos(0);
        assertThat(lottos.getSize()).isEqualTo(0);
    }

    @Test
    void 생성된_로또는_오름차순() {
        PurchasedLottos lottos = lottoGenerator.generateLottos(1000);
        assertThat(isSortedAscending(lottos)).isTrue();
    }

    private static boolean isSortedAscending(PurchasedLottos lottos) {
        return lottos.getPurchasedLottos()
                .stream()
                .sorted()
                .toList()
                .equals(lottos.getPurchasedLottos());
    }
}
