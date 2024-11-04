package lotto.generator;

import lotto.constants.LottoConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumberGeneratorTest {
    private RandomValueGenerator randomLottoNumberGenerator;

    @BeforeEach
    void setUp() {
        randomLottoNumberGenerator = new RandomLottoNumberGenerator();
    }
    @Test
    void 로또_번호_6개_생성_테스트() {
        List<Integer> lottoNumbers = randomLottoNumberGenerator.generate();
        assertThat(lottoNumbers).hasSize(LottoConstants.LOTTO_NUMBER_COUNT);
    }

    @Test
    void 로또_번호_범위_테스트() {
        List<Integer> lottoNumbers = randomLottoNumberGenerator.generate();
        assertThat(lottoNumbers).allMatch(number -> number >= LottoConstants.LOTTO_MIN_NUMBER && number <= LottoConstants.LOTTO_MAX_NUMBER);
    }

    @Test
    void 로또_번호_중복_테스트() {
        List<Integer> lottoNumbers = randomLottoNumberGenerator.generate();
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);

        assertThat(uniqueNumbers).hasSize(LottoConstants.LOTTO_NUMBER_COUNT);
    }

    @Test
    void 로또_번호_오름차순_정렬_테스트() {
        List<Integer> lottoNumbers = randomLottoNumberGenerator.generate();
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedNumbers);

        assertThat(lottoNumbers).isEqualTo(sortedNumbers);
    }
}
