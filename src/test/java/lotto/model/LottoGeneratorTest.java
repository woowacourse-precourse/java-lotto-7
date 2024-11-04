package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void generateLottosTest() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoGenerator lottoGenerator = LottoGenerator.generate(1);
            List<Integer> testNumbers = lottoGenerator.getLottos().getFirst().getNumbers();
            Assertions.assertThat(testNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        }, List.of(1, 2, 3, 4, 5, 6));
    }
}