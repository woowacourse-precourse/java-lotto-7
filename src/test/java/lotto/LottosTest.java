package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.NumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("여러 개의 로또를 생성한다.")
    @Test
    void newLottosTest() {
        int lottoCount = 2;
        NumbersGenerator fixedNumbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

        Lottos lottos = new Lottos(lottoCount, fixedNumbersGenerator);

        lottos.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6))
        );
    }
}
