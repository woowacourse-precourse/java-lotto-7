package lotto.model.lottoresult;

import static lotto.model.lottoresult.LottoRank.FIRST_PRIZE;
import static lotto.model.lottoresult.LottoRank.SECOND_PRIZE;
import static lotto.model.lottoresult.LottoRank.THIRD_PRIZE;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.PrizeLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 결과 생성 모델 테스트")
class LottoResultTest {

    @Test
    void 수익률_있을시_로또_결과_생성() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(winningNumbers, bonusNumber);

        List<Lotto> lottosList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        Lottos lottos = new Lottos(lottosList);

        // when
        LottoResult lottoResult = LottoResult.from(prizeLotto, lottos);

        // then
        Double expectedEarningRate = (double) 2_031_500_000 / 3000 * 100;
        Assertions.assertThat(lottoResult.getLottoRanks())
                .hasSize(3)
                .containsExactly(FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE);
        Assertions.assertThat(lottoResult.getEarningRate()).isEqualTo(expectedEarningRate);
    }

    @Test
    void 로또_미당첨시_수익률_0() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(winningNumbers, bonusNumber);

        List<Lotto> lottosList = List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(20, 21, 22, 23, 24, 25))
        );
        Lottos lottos = new Lottos(lottosList);

        // when
        LottoResult lottoResult = LottoResult.from(prizeLotto, lottos);

        // then
        Assertions.assertThat(lottoResult.getLottoRanks()).isEmpty();
        Assertions.assertThat(lottoResult.getEarningRate()).isEqualTo(0);
    }
}
