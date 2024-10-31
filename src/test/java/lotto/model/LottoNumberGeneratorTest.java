package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.constants.LottoConstants;
import org.junit.jupiter.api.RepeatedTest;

class LottoNumberGeneratorTest {

    @RepeatedTest(100)
    void 랜덤_숫자_생성_테스트() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();

        List<Integer> numbers = numberGenerator.generateNumber();

        assertThat(numbers.size()).isEqualTo(LottoConstants.NUMBER_COUNT);
        assertThat(numbers).allMatch(
                num -> num >= LottoConstants.LOTTO_START_INCLUSIVE
                        && num <= LottoConstants.LOTTO_END_INCLUSIVE);
    }
}
