package lotto;

import java.util.List;
import lotto.model.LottoPublisher;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

public class LottoPublisherTest {
    @Test
    public void 로또_번호가_발행되는지_확인한다(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoPublisher lottoPublisher = new LottoPublisher(8);
                    assertEquals(List.of(List.of(8, 21, 23, 41, 42, 43),
                            List.of(3, 5, 11, 16, 32, 38),
                            List.of(7, 11, 16, 35, 36, 44),
                            List.of(1, 8, 11, 31, 41, 42),
                            List.of(13, 14, 16, 38, 42, 45),
                            List.of(7, 11, 30, 40, 42, 43),
                            List.of(2, 13, 22, 32, 38, 45),
                            List.of(1, 3, 5, 14, 22, 45)),lottoPublisher.getPublishedLotto());
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
