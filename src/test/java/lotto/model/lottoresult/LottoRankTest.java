package lotto.model.lottoresult;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.PrizeLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 등수 정보 생성 테스트")
class LottoRankTest {

    @Test
    public void 일등_로또_당첨_반환() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        LottoRank lottoRank = LottoRank.from(prizeLotto, lotto);

        // then
        Assertions.assertThat(lottoRank.getRank()).isEqualTo(1);
        Assertions.assertThat(lottoRank.getPrizeMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    public void 이등_로또_당첨_반환() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        LottoRank lottoRank = LottoRank.from(prizeLotto, lotto);

        // then
        Assertions.assertThat(lottoRank.getRank()).isEqualTo(2);
        Assertions.assertThat(lottoRank.getPrizeMoney()).isEqualTo(30_000_000);
    }

    @Test
    public void 삼등_로또_당첨_반환() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 8);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        LottoRank lottoRank = LottoRank.from(prizeLotto, lotto);

        // then
        Assertions.assertThat(lottoRank.getRank()).isEqualTo(3);
        Assertions.assertThat(lottoRank.getPrizeMoney()).isEqualTo(1_500_000);
    }

    @Test
    public void 사등_로또_당첨_반환() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 15, 7);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        LottoRank lottoRank = LottoRank.from(prizeLotto, lotto);

        // then
        Assertions.assertThat(lottoRank.getRank()).isEqualTo(4);
        Assertions.assertThat(lottoRank.getPrizeMoney()).isEqualTo(50_000);
    }

    @Test
    public void 오등_로또_당첨_반환() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 14, 15, 7);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        LottoRank lottoRank = LottoRank.from(prizeLotto, lotto);

        // then
        Assertions.assertThat(lottoRank.getRank()).isEqualTo(5);
        Assertions.assertThat(lottoRank.getPrizeMoney()).isEqualTo(5_000);
    }

    @Test
    public void 로또_미당첨시_NULL_반환() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 13, 14, 15, 7);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        LottoRank lottoRank = LottoRank.from(prizeLotto, lotto);

        // then
        Assertions.assertThat(lottoRank).isNull();
    }
}
