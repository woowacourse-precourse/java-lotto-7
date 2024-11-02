package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 번호는 중복되지 않는 6개의 숫자여야 한다")
    @Test
    void createLottoNumbers() {
        // given
        Lottos lottos = new Lottos(1);  // 1개의 로또 생성

        // when
        List<Lotto> generatedLottos = lottos.getLottos();
        Lotto lotto = generatedLottos.get(0);
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).hasSize(6);

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers).hasSize(6);


        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("여러 개의 로또를 생성할 수 있다")
    @Test
    void createMultipleLottos() {
        // given
        int count = 5;

        // when
        Lottos lottos = new Lottos(count);

        // then
        assertThat(lottos.getLottos()).hasSize(count);


        lottos.getLottos().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6);
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            assertThat(uniqueNumbers).hasSize(6);
            assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
        });
    }
}