package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningInfo;
import lotto.service.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("1등 당첨을 정확히 계산한다")
    void calculateFirstWinner() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when
        lottoResult.updateResult(WinningInfo.FIRST_WINNER);

        // then
        assertThat(lottoResult.toString()).contains("6개 일치 (2,000,000,000원) - 1개");

        List<Lotto> lottoList = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lottos lottos = new Lottos(lottoList);
        assertThat(lottoResult.getProfitRate(lottos)).isEqualTo(200_000_000.0);
    }

    @Test
    @DisplayName("2등 당첨을 정확히 계산한다")
    void calculateSecondWinner() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when
        lottoResult.updateResult(WinningInfo.SECOND_WINNER);

        // then
        assertThat(lottoResult.toString()).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");

        List<Lotto> lottoList = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lottos lottos = new Lottos(lottoList);
        assertThat(lottoResult.getProfitRate(lottos)).isEqualTo(3_000_000.0);
    }

    @Test
    @DisplayName("여러 등수의 당첨을 동시에 계산한다")
    void calculateMultipleWinners() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when
        lottoResult.updateResult(WinningInfo.FIRST_WINNER);
        lottoResult.updateResult(WinningInfo.SECOND_WINNER);
        lottoResult.updateResult(WinningInfo.THIRD_WINNER);
        lottoResult.updateResult(WinningInfo.FOURTH_WINNER);
        lottoResult.updateResult(WinningInfo.FIFTH_WINNER);

        // then
        assertThat(lottoResult.toString())
                .contains("6개 일치 (2,000,000,000원) - 1개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개")
                .contains("5개 일치 (1,500,000원) - 1개")
                .contains("4개 일치 (50,000원) - 1개")
                .contains("3개 일치 (5,000원) - 1개");
    }

    @Test
    @DisplayName("수익률을 정확히 계산한다")
    void calculateProfit() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when
        lottoResult.updateResult(WinningInfo.FIFTH_WINNER);
        lottoResult.updateResult(WinningInfo.FIFTH_WINNER);

        // then
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );
        Lottos lottos = new Lottos(lottoList);
        assertThat(lottoResult.getProfitRate(lottos)).isEqualTo(333.3);
    }

    @Test
    @DisplayName("미당첨 로또의 수익률은 0%이다")
    void calculateProfitWithNoWinning() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when & then
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottoList);
        assertThat(lottoResult.getProfitRate(lottos)).isEqualTo(0.0);
    }
}