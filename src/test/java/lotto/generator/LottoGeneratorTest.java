package lotto.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final LottoGenerator lottoGenerator;

    public LottoGeneratorTest() {
        lottoGenerator = new LottoGenerator(LOTTO_PRICE, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
    }

    @Test
    public void 로또_발행_랜덤_테스트() {
        List<Integer> randomNumbers = List.of(1, 2, 3, 4, 5, 6);
        int lottoCount = 1;

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoBundle lottoBundle = lottoGenerator.generateLottoBundle(lottoCount * LOTTO_PRICE);

                    assertThat(lottoBundle.getLottos().getFirst())
                            .extracting("numbers")
                            .usingRecursiveComparison()
                            .isEqualTo(randomNumbers);
                },
                randomNumbers
        );
    }

    @Test
    public void 로또_발행_갯수_테스트() {
        int lottoCount = 100;

        LottoBundle lottoBundle = lottoGenerator.generateLottoBundle(lottoCount * LOTTO_PRICE);

        assertThat(lottoBundle.getLottos().size()).isEqualTo(lottoCount);
    }
}
