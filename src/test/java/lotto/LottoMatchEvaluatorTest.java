package lotto;

import java.util.List;

import lotto.model.LottoMatchEvaluator;

import lotto.model.LottoPublisher;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

public class LottoMatchEvaluatorTest {

    @Test
    public void 로또_번호와_발행된_로또_보너스_번호를_비교한다(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoPublisher lottoPublisher = new LottoPublisher(8);
                    LottoMatchEvaluator lottoMatchEvaluator =  new LottoMatchEvaluator(List.of(1,2,3,4,5,6),7,lottoPublisher);
                    assertEquals(List.of(0,0,0,0,1),lottoMatchEvaluator.getLottoWinningCounts());
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
}
