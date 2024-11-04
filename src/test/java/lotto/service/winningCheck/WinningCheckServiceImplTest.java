package lotto.service.winningCheck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.factory.WinningNumbersFactory;
import lotto.model.Lotto;
import lotto.model.PrizeTier;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningCheckServiceImplTest {

    @Test
    @DisplayName("3개 번호 일치 시 5등 상금 반환")
    void testThreeNumberMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)));
        WinningNumbers updatedWinningNumbers = WinningNumbersFactory.createWinningNumbersWithBonusNumber(winningNumbers,
                13);
        WinningStatistic winningStatistic = new WinningStatistic();

        WinningCheckServiceImpl service = new WinningCheckServiceImpl();
        int prizeAmount = service.checkPrize(lotto, updatedWinningNumbers, winningStatistic);

        assertEquals(PrizeTier.FIFTH.getPrizeAmount(), prizeAmount);
    }

    @Test
    @DisplayName("보너스 번호 포함 5개 일치 시 2등 상금 반환")
    void testFiveNumberMatchWithBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumbers updatedWinningNumbers = WinningNumbersFactory.createWinningNumbersWithBonusNumber(winningNumbers,
                7);

        WinningStatistic winningStatistic = new WinningStatistic();

        WinningCheckServiceImpl service = new WinningCheckServiceImpl();
        int prizeAmount = service.checkPrize(lotto, updatedWinningNumbers, winningStatistic);

        assertEquals(PrizeTier.SECOND.getPrizeAmount(), prizeAmount);
    }

    @Test
    @DisplayName("일치하는 번호가 없는 경우 상금 0 반환")
    void testNoMatch() {
        Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumbers updatedWinningNumbers = WinningNumbersFactory.createWinningNumbersWithBonusNumber(winningNumbers,
                14);
        WinningStatistic winningStatistic = new WinningStatistic();

        WinningCheckServiceImpl service = new WinningCheckServiceImpl();
        int prizeAmount = service.checkPrize(lotto, updatedWinningNumbers, winningStatistic);

        assertEquals(0, prizeAmount);
    }
}
