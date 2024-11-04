package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 생성된_로또_개수_테스트() {
        int requestedCount = 5;
        Lottos lottos = lottoGenerator.generateLottos(requestedCount);

        assertEquals(requestedCount, lottos.lottos().size());
    }

    @Test
    void 로또_번호_개수_테스트() {
        Lottos lottos = lottoGenerator.generateLottos(5);

        lottos.lottos().forEach(lotto ->
                assertEquals(6, lotto.numbers().size()));
    }

    @Test
    void 로또_번호_중복_테스트() {
        Lottos lottos = lottoGenerator.generateLottos(5);

        lottos.lottos().forEach(lotto -> {
            long uniqueCount = lotto.numbers().stream().distinct().count();
            assertEquals(6, uniqueCount);
        });
    }

    @Test
    void 로또_번호_정렬_테스트() {
        Lottos lottos = lottoGenerator.generateLottos(5);

        lottos.lottos().forEach(lotto -> {
            List<Integer> numbers = lotto.numbers();
            for (int i = 0; i < numbers.size() - 1; i++) {
                assertTrue(numbers.get(i) < numbers.get(i + 1));
            }
        });
    }
}