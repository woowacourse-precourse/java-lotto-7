package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

class LottoGameTest {

    @Test
    void calculateResult_당첨결과계산_테스트() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoGame lottoGame = new LottoGame(winningNumbers, bonusNumber);

        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)), // 5등
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)) // 꽝
        );

        // when
        LottoResult result = lottoGame.calculateResult(purchasedLottos);

        // then
        assertThat(result.getResultMap().get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getResultMap().get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getResultMap().get(Rank.THIRD)).isEqualTo(1);
        assertThat(result.getResultMap().get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.getResultMap().get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.getResultMap().get(Rank.NONE)).isEqualTo(1);
    }
}
