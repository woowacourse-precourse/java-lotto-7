package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    public void 구입_금액만큼_로또를_발행했는지와_각_로또_번호의_갯수가_6개인지_테스트() {
        int purchaseAmount = 5;
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = lottoGenerator.generateLottoList(purchaseAmount);

        assertEquals(purchaseAmount, lottoList.size());
        lottoList.forEach(lotto -> assertEquals(6, lotto.getNumbers().size()));
    }
}
