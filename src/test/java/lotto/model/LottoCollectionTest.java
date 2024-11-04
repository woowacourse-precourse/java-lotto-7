package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCollectionTest {

    @Test
    void toString_양식() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto, lotto);
        LottoCollection lottoCollection = new LottoCollection(lottos);

        // when
        String result = lottoCollection.toString();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n");
    }

    @Test
    void getLottoCount_로또_개수_반환_확인() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoCollection lottoCollection = new LottoCollection(List.of(lotto, lotto));

        // when
        int result = lottoCollection.getLottoCount();

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void matchWinningNumbers_당첨_결과_확인() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto6 = new Lotto(List.of(1, 2, 10, 11, 12, 13));
        Lotto lotto7 = new Lotto(List.of(1, 10, 11, 12, 13, 14));
        LottoCollection lottoCollection = new LottoCollection(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, "7");

        // when
        var result = lottoCollection.matchWinningNumbers(winningNumbers, bonusNumber);

        // then
        assertThat(result.get(5_000)).isEqualTo(1);
        assertThat(result.get(50_000)).isEqualTo(1);
        assertThat(result.get(1_500_000)).isEqualTo(1);
        assertThat(result.get(30_000_000)).isEqualTo(1);
        assertThat(result.get(2_000_000_000)).isEqualTo(1);
    }

    @Test
    void getTotalPrize_총_당첨_상금_확인(){
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoCollection lottoCollection = new LottoCollection(List.of(lotto1, lotto2));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, "7");

        // when
        long result = lottoCollection.getTotalPrize(winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualTo(2_000_000_000 + 30_000_000);
    }


}