package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("로또 번호가 6개인지 확인")
    @Test
    void 로또_번호가_6개인지_확인() {
        int lottoCount = 1;

        List<Lotto> lottos = lottoGenerator.generateLottos(lottoCount);
        List<Integer> numbers = lottos.get(0).getNumbers();

        assertThat(numbers).hasSize(6);
    }

    @DisplayName("로또 번호가 1에서 45 사이인지 확인")
    @Test
    void 로또_번호가_1에서_45_사이인지_확인() {
        int lottoCount = 1;

        List<Lotto> lottos = lottoGenerator.generateLottos(lottoCount);
        List<Integer> numbers = lottos.get(0).getNumbers();

        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인")
    @Test
    void 로또_번호가_오름차순으로_정렬되는지_확인() {
        int lottoCount = 1;

        List<Lotto> lottos = lottoGenerator.generateLottos(lottoCount);
        List<Integer> numbers = lottos.get(0).getNumbers();

        assertThat(numbers).isSorted();
    }

    @DisplayName("요청한 수량만큼 로또를 생성하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void 요청한_수량만큼_로또를_생성하는지_확인(int count) {
        List<Lotto> lottos = lottoGenerator.generateLottos(count);

        assertThat(lottos).hasSize(count);
    }

}
