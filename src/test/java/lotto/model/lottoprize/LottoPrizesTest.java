package lotto.model.lottoprize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.WinningNumbers;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizesTest {

    private LottoPrizes lottoPrizes;

    @BeforeEach
    public void 모든_등수의_로또_1개씩_당첨되었다고_가정() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, "7");

        List<Lotto> testLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12))
        );

        Lottos lottos = new Lottos(testLottos);

        this.lottoPrizes = new LottoPrizes(lottos, winningNumbers);
    }

    @DisplayName("로또 상금 리스트가 정확해야 한다.")
    @Test
    public void 로또_상금_리스트가_정확해야_한다() {
        List<LottoPrize> expectedPrizes = Arrays.asList(
                LottoPrize.SIX_MATCHES,
                LottoPrize.FIVE_MATCHES_WITH_BONUS,
                LottoPrize.FIVE_MATCHES,
                LottoPrize.FOUR_MATCHES,
                LottoPrize.THREE_MATCHES
        );

        assertEquals(expectedPrizes, lottoPrizes.getLottoPrizes());
    }

    @DisplayName("로또 상금 개수가 정확해야 한다.")
    @Test
    public void 로또_상금_개수가_정확해야_한다() {
        int expectedTotalPrizeCount = 5;
        assertEquals(expectedTotalPrizeCount, lottoPrizes.getLottoPrizes().size());
    }
}
