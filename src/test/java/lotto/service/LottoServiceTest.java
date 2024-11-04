package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    @DisplayName("로또를 구매한 개수만큼 로또를 생성한다")
    void buyLottos(int amount) {
        List<Lotto> lottos = lottoService.buyLottos(amount);
        assertThat(lottos).hasSize(amount);
    }

    @Test
    @DisplayName("생성된 로또 번호는 오름차순으로 정렬되어 있다")
    void lottoNumbersShouldBeSorted() {
        List<Lotto> lottos = lottoService.buyLottos(1);
        List<Integer> numbers = lottos.get(0).getNumbers();

        assertThat(numbers)
            .isSorted()
            .hasSize(6)
            .doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("생성된 로또 번호는 1부터 45 사이의 숫자다")
    void lottoNumbersShouldBeInRange() {
        List<Lotto> lottos = lottoService.buyLottos(1);
        List<Integer> numbers = lottos.get(0).getNumbers();

        assertThat(numbers)
            .allMatch(number -> number >= 1 && number <= 45)
            .hasSize(6);
    }
}