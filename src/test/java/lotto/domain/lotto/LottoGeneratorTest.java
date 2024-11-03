package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import lotto.domain.utility.generator.RandomIntegerListGenerator;
import lotto.domain.utility.generator.RandomNumberListGenerator;
import lotto.domain.utility.sorting.AscendingSorter;
import lotto.domain.utility.sorting.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private RandomNumberListGenerator randomNumberListGenerator;

    private Sorter sorter;

    @BeforeEach
    void setUp() {
        randomNumberListGenerator = new RandomIntegerListGenerator();
        sorter = new AscendingSorter();
    }

    @Test
    void 로또_생성시_로또는_NULL이_아니다() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator(randomNumberListGenerator, sorter);

        //when
        Lotto lotto = lottoGenerator.generate();

        //then
        assertNotNull(lotto);
    }
}
