package lotto.service;

import lotto.domain.BonusNum;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class DefaultLottoResultCalculatorTest {
    private static final DefaultLottoResultCalculator defaultLottoResultCalculator = new DefaultLottoResultCalculator();

    @Test
    void 맵에_결과_저장_성공() {
        Lotto two_match = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto three_match = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto three_match_2 = new Lotto(List.of(8, 9, 10, 11, 22, 33));
        Lotto bonus_match = new Lotto(List.of(2, 5, 6, 7, 8, 9));
        Lotto zero = new Lotto(List.of(1, 11, 12, 13, 14, 15));

        Lotto winning = new Lotto(List.of(5, 6, 7, 8, 9, 10));

        List<Lotto> purchasedLottos = List.of(two_match, three_match, three_match_2, bonus_match, zero);
        WinningLotto winningLotto = new WinningLotto(winning, new BonusNum(2, winning.getNumbers()));

        LottoResult lottoResult = defaultLottoResultCalculator.calculateResult(purchasedLottos, winningLotto);

        Map<WinningResult, Integer> results = lottoResult.getResults();

        assertThat(results.get(WinningResult.THREE)).isEqualTo(2);
        assertThat(results.get(WinningResult.BONUS)).isEqualTo(1);
    }

}
