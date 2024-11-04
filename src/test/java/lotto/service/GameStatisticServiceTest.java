package lotto.service;

import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameStatisticServiceTest {
    private GameStatisticService gameStatisticService;

    @BeforeEach
    void setup() {
        gameStatisticService = new GameStatisticService();
    }

    @DisplayName("1등 당첨 케이스")
    @Test
    void gameStatisticService_Rank_First() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(lotto), 1000, 1);

        LottoStatistic result = gameStatisticService.calculateLottoResult(lottoTicket, winningNumbers);

        assertEquals(result.getRankCount().get(Rank.FIRST), 1);
        assertEquals(result.getReturnRate(), 200000000.0);
    }


    @DisplayName("2등 당첨 케이스")
    @Test
    void gameStatisticService_Rank_SECOND() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(lotto), 1000, 1);

        LottoStatistic result = gameStatisticService.calculateLottoResult(lottoTicket, winningNumbers);

        assertEquals(result.getRankCount().get(Rank.SECOND), 1);
        assertEquals(result.getReturnRate(), 3000000.0);
    }


    @DisplayName("3등 당첨 케이스")
    @Test
    void gameStatisticService_Rank_THIRD() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(lotto), 1000, 1);

        LottoStatistic result = gameStatisticService.calculateLottoResult(lottoTicket, winningNumbers);

        assertEquals(result.getRankCount().get(Rank.THIRD), 1);
        assertEquals(result.getReturnRate(), 150000.0);
    }

}