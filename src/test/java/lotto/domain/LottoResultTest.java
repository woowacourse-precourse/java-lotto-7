package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.constants.Rank;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 당첨된_로또_개수_확인() {
        // given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusLottoNumber = 7;

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),      // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),      // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),      // 3등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),      // 4등
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),      // 5등
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 낙첨
        );

        Lotto winningLotto = new Lotto(winningLottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);

        // when
        LottoResult lottoResult = new LottoResult(lottoList, winningLottoResult);

        // then
        assertThat(lottoResult.getCount(Rank.FIRST)).isEqualTo(1);   // 1등
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(1);  // 2등
        assertThat(lottoResult.getCount(Rank.THIRD)).isEqualTo(1);   // 3등
        assertThat(lottoResult.getCount(Rank.FOURTH)).isEqualTo(1);  // 4등
        assertThat(lottoResult.getCount(Rank.FIFTH)).isEqualTo(1);   // 5등
        assertThat(lottoResult.getCount(Rank.MISS)).isEqualTo(1);    // 낙첨
    }

    @Test
    void 당첨된_로또_상금_확인() {
        // given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusLottoNumber = 7;

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),      // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),      // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),      // 3등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),      // 4등
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),      // 5등
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 낙첨
        );

        Lotto winningLotto = new Lotto(winningLottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);

        // when
        LottoResult lottoResult = new LottoResult(lottoList, winningLottoResult);

        // then
        assertThat(lottoResult.calculateTotalPrize()).isEqualTo(2_031_555_000);
    }

    @Test
    void 로또_수익률_확인() {
        // given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusLottoNumber = 7;

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        Lotto winningLotto = new Lotto(winningLottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);

        // when
        LottoResult lottoResult = new LottoResult(lottoList, winningLottoResult);

        // then
        assertThat(lottoResult.calculateYield()).isEqualTo(62.5);
    }
}