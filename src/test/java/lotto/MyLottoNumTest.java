package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.controller.MyLottoNum;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyLottoNumTest {
    private MyLottoNum myLottoNum;

    @BeforeEach
    void setUp() {
        myLottoNum = new MyLottoNum();
    }

    @Test
    void testMakeMyLotto() {
        int times = 5;
        myLottoNum.makeMyLotto(times);

        List<Lotto> lottoList = myLottoNum.getLottoList(times);
        assertEquals(times, lottoList.size());

        for (Lotto lotto : lottoList) {
            assertEquals(6, lotto.getNumbers().size());
            for (int number : lotto.getNumbers()) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }
}
