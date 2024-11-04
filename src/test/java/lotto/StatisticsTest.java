package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StatisticsTest {

    @Test
    public void 통계_계산_테스트() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18));
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int purchaseAmount = 3000; // 3000원에 대한 로또 3장 발행

        Statistics statistics = new Statistics();
        statistics.calculateAndDisplay(lottos, winningNumbers, bonusNumber, purchaseAmount);

    }
}
