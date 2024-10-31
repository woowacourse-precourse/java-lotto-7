package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void 입력받은_만큼의_로또를_생성한다() {
        int quantity = 5;
        List<Lotto> lottos = LottoGenerator.generate(quantity);
        Assertions.assertThat(lottos.size()).isEqualTo(quantity);
    }
}