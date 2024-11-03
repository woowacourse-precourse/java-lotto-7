package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.RandomLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 생성 테스트")
public class LottoGeneratorTest {
    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new RandomLottoGenerator();
    }

    @Test
    @DisplayName("구입 금액에 맞게 로또를 생성한다.")
    void 성공_로또생성_금액의수만큼() {
        // given
        int amount = 5000;

        // when
        List<Lotto> lottos = lottoNumberGenerator.generate(amount);

        // then
        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("생성된 로또 번호는 오름차순으로 정렬되어 있어야 한다.")
    void 성공_로또생성_오름차순() {
        // given
        int amount = 1000;

        // when
        List<Lotto> lottos = lottoNumberGenerator.generate(amount);

        // then
        assertThat(lottos).allSatisfy(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).isSorted();
        });
    }

    @Test
    @DisplayName("생성된 로또 번호는 1부터 45 사이의 숫자여야 한다.")
    void 성공_로또생성_알맞은범위() {
        // given
        int amount = 1000;

        // when
        List<Lotto> lottos = lottoNumberGenerator.generate(amount);

        // then
        assertThat(lottos).allSatisfy(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
        });
    }

    @Test
    @DisplayName("생성된 로또 번호는 중복되지 않아야 한다.")
    void 성공_로또생성_중복되지않는번호() {
        // given
        int amount = 1000;

        // when
        List<Lotto> lottos = lottoNumberGenerator.generate(amount);

        // then
        assertThat(lottos).allSatisfy(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).doesNotHaveDuplicates();
        });
    }
}
