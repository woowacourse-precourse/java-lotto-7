package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultDetailsTest {
    @DisplayName("발행한 로또와 당첨번호를 비교하여 올바른 rank를 반환한다.")
    @Test
    public void 발행한_로또와_당첨번호를_비교하여_올바른_랭크를_반환한다() {
        Rank.resetCount();
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)), //5개 일치, 보너스 일치x
                new Lotto(Arrays.asList(1, 2, 3, 4, 6, 10)), //4개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 10)), //4개 일치
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)) //3개 일치
        ));
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 15)),
                "6");

        LottoResultDetails.count(lottos, winningLottoNumber);

        assertEquals(1, Rank.FIFTH.getCount());
        assertEquals(2, Rank.FOURTH.getCount());
        assertEquals(1, Rank.THIRD.getCount());
        assertEquals(0, Rank.SECOND.getCount());
        assertEquals(0, Rank.FIRST.getCount());
    }
}