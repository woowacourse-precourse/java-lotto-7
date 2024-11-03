package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void LottoGenerator_테스트() {
        LottoGenerator lottoGenerator = new LottoGenerator(2);
        List<Lotto> lottos = lottoGenerator.getLottos();

        assertEquals(2, lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(numbers, numbers.stream().sorted().toList());
        }
    }
}