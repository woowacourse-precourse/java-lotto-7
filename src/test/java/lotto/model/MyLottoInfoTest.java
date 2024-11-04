package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoInfoTest {

    @Test
    @DisplayName("올바른 등수에 올바른 개수")
    void validWinningRanks(){
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 3
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12)); // 3
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 7, 42, 43)); // 4
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 7, 8, 44)); // 5
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 7, 8, 45)); // 5 + 1
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 7, 8, 9)); // 6

        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        MyLottoInfo myLottoInfo = new MyLottoInfo(lottos);

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 7, 8, 9)), 45);
        myLottoInfo.getResultPerLotto(winningLotto);

        assertThat(myLottoInfo.getMyResult().get(Rank.FIFTH_PLACE)).isEqualTo(2);
        assertThat(myLottoInfo.getMyResult().get(Rank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(myLottoInfo.getMyResult().get(Rank.THIRD_PLACE)).isEqualTo(1);
        assertThat(myLottoInfo.getMyResult().get(Rank.SECOND_PLACE)).isEqualTo(1);
        assertThat(myLottoInfo.getMyResult().get(Rank.FIRST_PLACE)).isEqualTo(1);

    }

    @Test
    @DisplayName("당첨 수익금 계산이 올바른 경우")
    void validRevenueRate(){

        //given
        int purchaseAmount = 8000;
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIFTH_PLACE);

        //when
        Revenue revenue = Revenue.from(ranks);
        revenue.updateRevenueRate(purchaseAmount);

        //then
        assertThat(revenue.getRevenueRate()).isEqualTo(62.5);
    }
}
