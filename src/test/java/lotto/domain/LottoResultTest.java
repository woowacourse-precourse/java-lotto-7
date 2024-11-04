package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    @DisplayName("1등에 당첨된다.")
    @Test
    void 일등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));  // 1등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("2등에 당첨된다.")
    @Test
    void 이등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));  // 2등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("3등에 당첨된다.")
    @Test
    void 삼등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));  // 3등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("4등에 당첨된다.")
    @Test
    void 사등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 8));  // 4등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("5등에 당첨된다.")
    @Test
    void 오등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 9, 8));  // 5등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("당첨되지 않는다.")
    @Test
    void 당첨되지_않는다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 11, 10, 9, 8));

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.NONE)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void 수익률을_계산한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), 7);

        // 3장 구매, 1등 1장 (20억)
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(userNumbers),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)),
                new Lotto(Arrays.asList(20, 21, 22, 23, 24, 25))
        );

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        // 수익률 = (당첨금 * 100) / 구매금액
        // = (2,000,000,000 * 100) / 3,000 = 66,666,666.7%
        assertThat(lottoResult.getReturnRate()).isEqualTo(66666666.7, offset(0.1));
    }
}

