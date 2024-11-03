package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 로또_한_개_생성() {
        //given
        long purchaseAmount = 1000;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        //then
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottos = lottoGenerator.purchase(purchaseAmount);
                    Assertions.assertThat(lottos)
                            .hasSize(1);
                    Assertions.assertThat(lottos.getFirst().getNumbers())
                            .isEqualTo(numbers);

                },
                numbers);
    }
}