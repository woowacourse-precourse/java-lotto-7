package lotto;

import lotto.domain.Attempt;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

public class LottoManagerTest {

    @Test
    void 시도에_맞춰서_랜덤_로또를_알맞은_개수를_뽑아야_한다() {
        LottoManager lottoManager = new LottoManager(
                new Attempt(4000),
                new Lotto(List.of(1,2,3,4,5,6)),
                new BonusLotto(7));

        long expected = 4;

        Assertions.assertEquals(expected,lottoManager.getRandomLottoList().size());
    }

    @Test
    void 랜덤_로또를_알맞게_뽑아야_한다() {
        List<Lotto> expected = getRandomList().stream()
                .map(Lotto::new)
                .toList();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoManager lottoManager = new LottoManager(
                            new Attempt(4000),
                            new Lotto(List.of(1,2,3,4,5,6)),
                            new BonusLotto(7));
                    Assertions.assertEquals(expected,lottoManager.getRandomLottoList());
                },
                getRandomList().get(0),
                getRandomList().get(1),
                getRandomList().get(2),
                getRandomList().get(3)
        );
    }

    @Test
    void 보너스_적용이_제대로_작동해야_한다() {
        int expected = 1;

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoManager lottoManager = new LottoManager(
                            new Attempt(1000),
                            new Lotto(List.of(1,2,3,4,5,7)),
                            new BonusLotto(1));
                    Assertions.assertEquals(
                            expected,
                            lottoManager.doLotto().get(LottoPrize.FIVE_MATCH_BONUS)
                    );
                },
                List.of(1,2,3,4,5,6)
        );
    }

    @Test
    void 로또_번호가_전부_일치할때_상금이_정확히_산출된다() {
        int expected = 1;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoManager lottoManager = new LottoManager(
                            new Attempt(2000),
                            new Lotto(List.of(1,2,3,4,5,6)),
                            new BonusLotto(1));
                    Assertions.assertEquals(
                            expected,
                            lottoManager.doLotto().get(LottoPrize.SIX_MATCH)
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(7,8,9,10,11,12)
        );
    }

    @Test
    void 로또_번호가_전부_일치하지_않을_때_상금이_정확히_산출된다() {
        Map<LottoPrize, Integer> expected = initializePrizeMap();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoManager lottoManager = new LottoManager(
                            new Attempt(1000),
                            new Lotto(List.of(1,2,3,4,5,6)),
                            new BonusLotto(1));
                    Assertions.assertEquals(
                            expected,
                            lottoManager.doLotto()
                    );
                },
                List.of(7,8,9,10,11,12)
        );
    }

    @Test
    void 수익률이_제대로_계산되어야_한다() {
        int usedMoney = 2000;
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        int bonusNumber = 1;
        List<Integer> fiveMatchBonus = List.of(1,2,3,4,5,7);
        List<Integer> sixMatch = List.of(1,2,3,4,5,6);

        int earn = LottoPrize.FIVE_MATCH_BONUS.getPrize() + LottoPrize.SIX_MATCH.getPrize();
        double expected = (double)(earn - usedMoney) / usedMoney * 100;

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoManager lottoManager = new LottoManager(
                            new Attempt(usedMoney),
                            new Lotto(lotto),
                            new BonusLotto(bonusNumber));
                    Map<LottoPrize, Integer> prizeMap = lottoManager.doLotto();
                    Assertions.assertEquals(
                            expected,
                            lottoManager.getROI(prizeMap)
                    );
                },
                fiveMatchBonus,
                sixMatch
        );
    }

    private List<List<Integer>> getRandomList() {
        return List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42));
    }

    private Map<LottoPrize, Integer> initializePrizeMap() {
        Map<LottoPrize, Integer> prizeMap = new LinkedHashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeMap.put(prize, 0));
        return prizeMap;
    }
}
