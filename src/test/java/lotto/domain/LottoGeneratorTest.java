package lotto.domain;

import lotto.strategy.LottoCreateStrategy;
import lotto.strategy.RandomLottoCreateStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest {
    @Test
    void 구매_금액_만큼의_로또개수가_발행한다(){
        String purchaseAmount = "2000";
        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount, new RandomLottoCreateStrategy());

        assertEquals(2, lottoGenerator.getLottos().size());

    }

    @Test
    void 구매_금액_만큼_로또를_발행한다(){
        String purchaseAmount = "1000";
        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount, new LottoCreateStrategy() {
            @Override
            public List<Integer> createRandomLottoNumbers() {
                return List.of(1,2,3,4,5,6);
            }
        });

        Lotto lotto = lottoGenerator.getLottos().get(0);

        assertEquals(1, lotto.getNumbers().get(0));
        assertEquals(2, lotto.getNumbers().get(1));
        assertEquals(3, lotto.getNumbers().get(2));
        assertEquals(4, lotto.getNumbers().get(3));
        assertEquals(5, lotto.getNumbers().get(4));
        assertEquals(6, lotto.getNumbers().get(5));
    }
}
