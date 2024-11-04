package lotto;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningNumbers;
import lotto.service.PrizeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PrizeCalculatorTest {

    private PrizeCalculator prizeCalculator;

    @BeforeEach
    public void setUp() {
        prizeCalculator = new PrizeCalculator();
    }

    @Test
    public void testCheckWinningNumbers() {
        // Given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개 일치, 보너스 일치
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)), // 3개 일치
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)) // 일치 없음
        );

        prizeCalculator.checkWinningNumbers(winningNumbers, purchasedLottos);

        assertEquals(1, prizeCalculator.getPrizeCountMap().get(Prize.SIX_MATCH));
        assertEquals(1, prizeCalculator.getPrizeCountMap().get(Prize.FIVE_MATCH_BONUS));
        assertEquals(1, prizeCalculator.getPrizeCountMap().get(Prize.THREE_MATCH));
        assertNull(prizeCalculator.getPrizeCountMap().get(Prize.FOUR_MATCH));
        assertNull(prizeCalculator.getPrizeCountMap().get(Prize.FIVE_MATCH));
    }
}
