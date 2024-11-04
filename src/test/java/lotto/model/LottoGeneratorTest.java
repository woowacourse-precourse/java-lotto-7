package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.Constants.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다. ")
    void testGenerateLottos() {
        int amount = 5;
        List<Lotto> lottos = lottoGenerator.generateLottos(amount);
        assertThat(lottos).hasSize(amount);
    }

    @Test
    @DisplayName("생성한 로또 숫자 개수는 6개이다. ")
    public void testGenerateLottoNumber_Size() {
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
        assertThat(lottoNumbers).hasSize(LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("생성한 로또 숫자 개수는 6개이다. ")
    public void testGenerateLottoNumber() {
        assertRandomUniqueNumbersInRangeTest(
            () -> assertThat(lottoGenerator.generateLottoNumbers()).isEqualTo(
                List.of(8, 21, 23, 41, 42, 43)),
            List.of(8, 21, 23, 41, 42, 43)
        );
    }
}