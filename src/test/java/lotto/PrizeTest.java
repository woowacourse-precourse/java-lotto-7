package lotto;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrizeTest {
    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 당첨번호가_3개_일치할_경우() {
        Prize prize = Prize.getPrize(3, false);
        assertEquals(Prize.THREE_MATCH, prize);
    }

    @Test
    void 당첨번호가_5개_일치하고_보너스_번호도_일치할_경우() {
        Prize prize = Prize.getPrize(5, true);
        assertEquals(Prize.FIVE_MATCH_WITH_BONUS, prize);
    }

    @Test
    void 당첨번호가_5개_일치하고_보너스_번호가_불일치할_경우() {
        Prize prize = Prize.getPrize(5, false);
        assertEquals(Prize.FIVE_MATCH, prize);
    }

    @Test
    void 로또_생성_테스트() {
        int numberOfTickets = 5;
        List<Lotto> lottos = lottoService.createLotto(numberOfTickets);

        assertEquals(numberOfTickets, lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
            assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 45));
            assertEquals(numbers.size(), numbers.stream().distinct().count());
        }
    }

    @Test
    void 당첨등수_계산_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개 일치 + 보너스
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))  // 5개 일치
        );

        List<Prize> expectedPrizes = Arrays.asList(
                Prize.SIX_MATCH,
                Prize.FIVE_MATCH_WITH_BONUS,
                Prize.FIVE_MATCH
        );

        List<Prize> calculatedPrizes = lottoService.calculatePrizes(lottos, winningLotto);

        assertEquals(expectedPrizes, calculatedPrizes);
    }
}
