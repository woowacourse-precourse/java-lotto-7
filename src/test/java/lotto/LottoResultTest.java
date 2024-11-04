package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.lotto.LottoResult;
import lotto.lotto.object.MyLotto;
import lotto.lotto.object.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("당첨 번호와 일치하는 번호의 개수만큼 반환한다.")
    @Test
    void 당첨_번호와_일치하는_번호의_개수만큼_반환한다() {
        // given
        MyLotto myLotto = new MyLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(3, 4, 5, 6, 7, 8), 9);

        // when
        LottoResult lottoResult = new LottoResult(winningLotto);
        int count = lottoResult.matchingNumberCount(myLotto);

        // then
        assertThat(count).isEqualTo(4);
    }

    @DisplayName("일치하는 번호 개수에 따라 순위를 정한다.")
    @Test
    void 일치하는_번호_개수에_따라_순위를_정한다() {
        // given
        MyLotto myLotto = new MyLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(2, 3, 4, 5, 6, 8), 1);
        LottoResult lottoResult = new LottoResult(winningLotto);

        // when
        int rank = lottoResult.assignRank(myLotto);
        myLotto.setRank(rank);

        // then
        assertThat(myLotto.getRank()).isEqualTo(2);
    }

    @DisplayName("일치하는 번호 개수와 해당 복권 개수를 Map으로 반환한다.")
    @Test
    void 일치하는_번호_개수와_해당_복권_개수를_Map으로_반환한다() {
        // given
        List<MyLotto> myLottos = new ArrayList<>();
        myLottos.add(new MyLotto(List.of(1, 2, 3, 4, 5, 6)));
        myLottos.add(new MyLotto(List.of(2, 3, 4, 5, 6, 7)));
        myLottos.add(new MyLotto(List.of(3, 4, 5, 6, 7, 8)));

        LottoResult lottoResult = new LottoResult(new WinningLotto(List.of(3, 4, 5, 6, 7, 8), 9));

        // when
        Map<Integer, Integer> winningStatistics = lottoResult.winningStatistics(myLottos);

        // then
        System.out.println(winningStatistics);
    }

}