package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    private Lottos lottos;

    @Test
    @DisplayName("정상_로또_생성")
    void 정상_로또_생성 () {
        // given
        int expectLottoNum = 5;

        // when
        lottos = new Lottos(expectLottoNum);
        long actualLottoNum = lottos.getUserLottoCount();

        // then
        assertThat(actualLottoNum).isEqualTo(expectLottoNum);
    }

}