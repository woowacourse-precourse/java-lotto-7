package lotto.custom.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import lotto.custom.constants.NumberConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMakerTest {
    private LottoMaker lottoMaker;

    @BeforeEach
    void setUp() {
        lottoMaker = new LottoMaker();
    }

    @DisplayName("모델_로또메이커_로또수계산_테스트")
    @Test
    void 모델_로또메이커_로또수계산_테스트() {
        int purchaseAmount = NumberConstants.LOTTO_PRICE * 5;

        Lottos lottos = lottoMaker.run(purchaseAmount);

        assertEquals(5, lottos.getLottos().size());
    }

    @DisplayName("모델_로또메이커_로또숫자개수_테스트")
    @Test
    void 모델_로또메이커_로또숫자개수_테스트() {
        int purchaseAmount = NumberConstants.LOTTO_PRICE * 2;

        Lottos lottos = lottoMaker.run(purchaseAmount);

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
        }
    }

    @DisplayName("모델_로또메이커_로또숫자중복_테스트")
    @Test
    void 모델_로또메이커_로또숫자중복_테스트() {
        int purchaseAmount = NumberConstants.LOTTO_PRICE * 2;

        Lottos lottos = lottoMaker.run(purchaseAmount);

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, new HashSet<>(numbers).size());
        }
    }

    @DisplayName("모델_로또메이커_로또숫자범위_테스트")
    @Test
    void 모델_로또메이커_로또숫자범위_테스트() {
        int purchaseAmount = NumberConstants.LOTTO_PRICE * 2;

        Lottos lottos = lottoMaker.run(purchaseAmount);

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            assertTrue(numbers.stream().allMatch(num -> num >= 1 && num <= 45));
        }
    }
}