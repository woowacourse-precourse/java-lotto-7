package lotto.util;

import lotto.domain.Host;
import lotto.domain.Lotto;
import lotto.domain.WinningKind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUtilTest {

    private Host host;
    private Map<WinningKind, Integer> lottoResult;

    @BeforeEach
    void setUp() {
        host = Host.getHost();
        host.setSelectedNumbers(List.of(1, 2, 3, 4, 5, 6));
        host.setBonusNumber(7);
        lottoResult = LottoUtil.resultInit();
    }

    @DisplayName("초기 로또 결과가 모든 WinningKind에 대해 0으로 초기화되는지 확인")
    @Test
    void resultInit() {
        Map<WinningKind, Integer> result = LottoUtil.resultInit();
        for (WinningKind kind : WinningKind.values()) {
            assertThat(result.get(kind)).isEqualTo(0);
        }
    }

    @DisplayName("로또 번호가 당첨 조건을 만족할 경우 WinningKind의 개수가 올바르게 증가하는지 확인")
    @Test
    void checkLotto() {
        Map<WinningKind, Integer> expectedResults = Map.of(
                WinningKind.MATCH_6, 1,
                WinningKind.MATCH_5_BONUS, 1,
                WinningKind.MATCH_3, 0,
                WinningKind.MATCH_4, 0,
                WinningKind.MATCH_5, 0
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto bonusLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto noPrizeLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));

        LottoUtil.checkLotto(lottoResult, winningLotto, host);
        LottoUtil.checkLotto(lottoResult, bonusLotto, host);
        LottoUtil.checkLotto(lottoResult, noPrizeLotto, host);

        expectedResults.forEach((key, expectedCount) ->
                assertThat(lottoResult.get(key)).isEqualTo(expectedCount));
    }

    @DisplayName("로또 결과를 기반으로 수익률을 정확하게 계산")
    @Test
    void calculateYield() {
        lottoResult.put(WinningKind.MATCH_3, 1);
        lottoResult.put(WinningKind.MATCH_4, 2);
        lottoResult.put(WinningKind.MATCH_5, 1);

        int purchaseAmount = 5_000;
        double yield = LottoUtil.getYield(lottoResult, purchaseAmount);

        double expectedYield = (WinningKind.MATCH_3.getPrize() * 1 +
                WinningKind.MATCH_4.getPrize() * 2 +
                WinningKind.MATCH_5.getPrize() * 1) / (double) purchaseAmount * 100;

        assertThat(yield).isEqualTo(expectedYield);
    }

}