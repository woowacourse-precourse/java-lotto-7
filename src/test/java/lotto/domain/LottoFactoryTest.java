package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 정상적인_로또_생성_성공() {
        int lottoCount = 5;
        List<Lotto> lottos = LottoFactory.createLottos(lottoCount);

        assertThat(lottos).hasSize(lottoCount);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        }
    }

}