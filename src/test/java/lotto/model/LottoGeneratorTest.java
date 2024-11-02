package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("주어진 수량만큼 로또를 발행한다.")
    @Test
    void issue() {
        //given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int quantity = 6;

        LottoGenerator lottoGenerator = new LottoGenerator(() -> lottoNumbers);

        //when
        Lottos result = lottoGenerator.issues(quantity);

        //then
        List<Lotto> compareLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        assertThat(result.getLottos()).hasSize(6).isEqualTo(compareLotto);
    }
}
