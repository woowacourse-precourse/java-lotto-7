package lotto.repository;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.config.LottoRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InMemoryLottoRepositoryTest {

    @DisplayName("총 당첨금 계산 테스트")
    @Test
    void findTotalPrizeByWinningNumbersAndBonusNumber() {
        LottoRepository lottoRepository = new InMemoryLottoRepository();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoRepository.generateRandomLottos(8000);
                    int totalPrize = lottoRepository.generatePrizeListBy(
                            List.of(4, 7, 11, 30, 44, 45), 6)
                            .stream()
                            .map(LottoRule::getPrize)
                            .mapToInt(Integer::intValue)
                            .sum();
                    assertEquals(totalPrize, 10_000);
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