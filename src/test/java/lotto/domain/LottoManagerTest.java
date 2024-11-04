package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.*;
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

    private Map<LottoRank, Integer> getLottoResult() {
        return Map.of(
                FAIL, 3,
                THREE, 1,
                FOUR, 1,
                FIVE, 1,
                FIVE_BONUS, 1,
                SIX, 1
        );
    }

    private WinLotto getWinLotto() {
        WinLotto winLotto = new WinLotto(List.of(1, 5, 20, 25, 40, 45));
        winLotto.setBonusNumber(7);

        return winLotto;
    }

    private List<Lotto> getLottos() {
        return List.of(
                new Lotto(List.of(1, 5, 20, 25, 40, 45)),
                new Lotto(List.of(1, 5, 20, 25, 40, 44)),
                new Lotto(List.of(1, 5, 20, 25, 43, 44)),
                new Lotto(List.of(1, 5, 20, 24, 43, 44)),
                new Lotto(List.of(1, 5, 23, 24, 43, 44)),
                new Lotto(List.of(1, 4, 23, 24, 43, 44)),
                new Lotto(List.of(2, 4, 23, 24, 43, 44)),
                new Lotto(List.of(1, 5, 20, 25, 40, 7))
        );
    }
}
