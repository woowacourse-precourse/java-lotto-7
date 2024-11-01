package lotto.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    public void setUp() {
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @Test
    public void 테스트_사용자_번호_일치_확인() {
        Set<Integer> userNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(Rank.FIRST, winningLotto.getRank(userNumbers));

        userNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertEquals(Rank.SECOND, winningLotto.getRank(userNumbers));

        userNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 8, 9));
        assertEquals(Rank.FOURTH, winningLotto.getRank(userNumbers));

        userNumbers = new HashSet<>(Arrays.asList(8, 9, 10, 11, 12, 13));
        assertEquals(Rank.FIFTH, winningLotto.getRank(userNumbers));
    }

    @Test
    public void 테스트_당첨_통계_출력() {
        int[] matchCounts = {0, 0, 1, 1, 1, 1};
        winningLotto.printWinningStatistics(matchCounts); // This will print the winning statistics to the console
    }
}
