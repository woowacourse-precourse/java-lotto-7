package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void generateLottos_정확한_개수의_로또_생성() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();
        int lottoCount = 5;

        // when
        List<Lotto> lottos = lottoGenerator.generateLottos(lottoCount);

        // then
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }

}