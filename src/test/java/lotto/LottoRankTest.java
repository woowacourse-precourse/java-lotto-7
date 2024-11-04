package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoRankTest {

    @Test
    void 등수_검사_테스트(){
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 9);
        Lotto lotto1 = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 9)));
        Lotto lotto3 = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 7, 6)));
        Lotto lotto4 = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 12, 4, 34)));
        Lotto lotto5 = new Lotto(new ArrayList<Integer>(Arrays.asList(7, 2, 3, 8, 13, 6)));

        assertThat(LottoRank.getLottoRank(lotto1, winningLotto)).isEqualTo(LottoRank.RANK_1);
        assertThat(LottoRank.getLottoRank(lotto2, winningLotto)).isEqualTo(LottoRank.RANK_2);
        assertThat(LottoRank.getLottoRank(lotto3, winningLotto)).isEqualTo(LottoRank.RANK_3);
        assertThat(LottoRank.getLottoRank(lotto4, winningLotto)).isEqualTo(LottoRank.RANK_4);
        assertThat(LottoRank.getLottoRank(lotto5, winningLotto)).isEqualTo(LottoRank.RANK_5);

    }

}