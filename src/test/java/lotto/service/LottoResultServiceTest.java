package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.config.AppConfig;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {
    private LottoResultService lottoResultService;

    @BeforeEach
    void init() {
        AppConfig appConfig = AppConfig.getAppConfig();
        lottoResultService = appConfig.lottoResultService();
    }

    @Test
    void 당첨_확인_테스트() {
        // given
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(4, 5, 6, 7, 8, 9);
        List<Integer> lotto3 = List.of(7, 8, 9, 10, 11, 12);
        List<Lotto> lottos = List.of(
                new Lotto(lotto1),
                new Lotto(lotto2),
                new Lotto(lotto3)
        );
        List<Integer> winningNumbers = List.of(2, 3, 4, 5, 6);
        int bonus = 1;

        // when
        Map<Winning, Integer> countWinnings = lottoResultService.getWinnings(lottos, winningNumbers, bonus);

        // then
        assertThat(countWinnings).isEqualTo(Map.of(
                Winning.THREE, 1,
                Winning.FIVE_BONUS, 1,
                Winning.FAIL, 1
        ));
    }

    @Test
    void 수익률_테스트() {
        //given
        int payment = 5000;
        Map<Winning, Integer> winnings = Map.of(
                Winning.THREE, 1
        );

        // when
        int totalWinnings = lottoResultService.calculateTotalWinnings(winnings);
        double yield = lottoResultService.calculateYield(payment, totalWinnings);

        // then
        assertThat(yield).isEqualTo(100.0);
    }
}