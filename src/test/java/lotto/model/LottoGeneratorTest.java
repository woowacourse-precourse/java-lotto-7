package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    void 로또_개수_확인() {
        final int COUNT = 5;
        Assertions.assertThat(LottoGenerator.generateLottos(COUNT)).hasSize(COUNT);
    }

    @Test
    void 로또_번호_유효성_검사() {
        final int COUNT = 100;

        List<Lotto> lottos = LottoGenerator.generateLottos(COUNT);

        for (Lotto lotto : lottos) {
            Assertions.assertThat(lotto.getNumbers()).hasSize(6);
            Assertions.assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
            Assertions.assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        }
    }
}