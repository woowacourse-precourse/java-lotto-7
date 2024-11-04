package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 요청된_개수만큼_로또가_생성된다(){
        int lottoCount = 5;
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);

        assertThat(lottos).hasSize(lottoCount);
    }

}
