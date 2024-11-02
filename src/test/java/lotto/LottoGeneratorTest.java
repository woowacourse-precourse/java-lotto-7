package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    @ParameterizedTest
    @ValueSource(longs = {
            1000L,
            8000L
    })
    void generateTest(long payment) {
        Assertions.assertEquals(payment / 1000, lottoGenerator.generate(payment).size());
    }
}
