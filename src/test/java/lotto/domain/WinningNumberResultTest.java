package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import lotto.domain.winning.LottoRank;
import lotto.domain.winning.WinningResult;
import lotto.domain.number.Lotto;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberResultTest {

    @Test
    @DisplayName("당첨 결과를 집계 한다.")
    void getLottoRanksTest() {
        //given
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final BonusNumber bonusNumber = new BonusNumber(10);
        final WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);
        final List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        //when
        final WinningResult winningResult = new WinningResult(winningNumber, lottos);
        final Map<LottoRank, Integer> lottoRanks = winningResult.getLottoRanks();

        //then
        assertAll(
                () -> assertThat(lottoRanks).isNotEmpty(),
                () -> assertThat(lottoRanks).doesNotContainKey(LottoRank.RANK_NONE),
                () -> assertThat(lottoRanks).containsAllEntriesOf(Map.of(
                        LottoRank.RANK_1, 1,
                        LottoRank.RANK_2, 1,
                        LottoRank.RANK_3, 1,
                        LottoRank.RANK_4, 0,
                        LottoRank.RANK_5, 0
                )));
    }
}
