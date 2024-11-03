package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성 테스트")
    public void 로또_생성기는_요청한_갯수와_동일한_로또_갯수를_반환해야한다() {
        // given
        LottoGenerator generator = new DefaultLottoGenerator();
        int count = 5;

        // when
        Lottos lottos = generator.generateLottos(count);

        // then
        assertEquals(count, lottos.getLottos().size());
    }

}
