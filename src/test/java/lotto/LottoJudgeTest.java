package lotto;

import static lotto.score.Prize.FIFTH_PRIZE;
import static lotto.score.Prize.FIRST_PRIZE;
import static lotto.score.Prize.SECOND_PRIZE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.score.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoJudgeTest {
    @Test
    void 세개의_숫자가_일치했을_때_5등상() {
        //given
        LottoJudge judge = new LottoJudge();
        List<Lotto> lottos = new ArrayList<>();
        LottoWinningSet lottoWinningSet = new LottoWinningSet(Arrays.asList(4, 5, 6, 7, 8, 9), 10);
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        Map<Prize, Integer> prizeScore = judge.calculateLottoScore(lottos, lottoWinningSet);

        //then
        Assertions.assertThat(prizeScore.get(FIFTH_PRIZE)).isEqualTo(1);
    }

    @Test
    void 다섯개_일치_보너스_볼_일치시_이등상() {
        //given
        LottoJudge judge = new LottoJudge();
        List<Lotto> lottos = new ArrayList<>();
        LottoWinningSet lottoWinningSet = new LottoWinningSet(Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        Map<Prize, Integer> prizeScore = judge.calculateLottoScore(lottos, lottoWinningSet);

        //then
        Assertions.assertThat(prizeScore.get(SECOND_PRIZE)).isEqualTo(1);
    }

    @Test
    void 여섯개_일치시_일등상() {
        //given
        LottoJudge judge = new LottoJudge();
        List<Lotto> lottos = new ArrayList<>();
        LottoWinningSet lottoWinningSet = new LottoWinningSet(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        Map<Prize, Integer> prizeScore = judge.calculateLottoScore(lottos, lottoWinningSet);

        //then
        Assertions.assertThat(prizeScore.get(FIRST_PRIZE)).isEqualTo(1);
    }

}