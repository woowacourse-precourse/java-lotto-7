package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.values;
import static lotto.fixture.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {

    LottoManager lottoManager = LottoManager.INSTANCE;

    @Test
    void 로또_구매가능_개수() {
        assertThat(lottoManager.getPurchasableLottos(8000L)).isEqualTo(8);
    }

    @Test
    void 로또_구매() {
        assertThat(lottoManager.purchaseLotto(8).size()).isEqualTo(8);
    }

    @Test
    void 당첨_결과_반환() {
        List<Lotto> lottos = getLottos();
        WinLotto winLotto = getWinLotto();
        Map<LottoRank, Integer> expectResult = getLottoResult();

        assertThat(lottoManager.drawResult(lottos, winLotto)).isEqualTo(expectResult);
    }

    @Test
    void 당첨금_반환() {
        Map<LottoRank, Integer> result = getLottoResult();
        long expectPrize = Arrays.stream(values())
                .mapToLong(LottoRank::getPrize)
                .sum();

        assertThat(lottoManager.calculatePrize(result)).isEqualTo(expectPrize);
    }
}
