package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningRankTest {

    private LottoChecker lottoChecker;

    @BeforeEach
    void 사전_조건() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
    }

    @Test
    void 등수_확인() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10))
        );

        WinningRank.winningCounts(lottos, lottoChecker);

        assertThat(WinningRank.FIRST.getCount()).isEqualTo(1);
        assertThat(WinningRank.SECOND.getCount()).isEqualTo(1);
        assertThat(WinningRank.THIRD.getCount()).isEqualTo(1);
        assertThat(WinningRank.FOURTH.getCount()).isEqualTo(1);
        assertThat(WinningRank.FIFTH.getCount()).isEqualTo(1);
    }


}