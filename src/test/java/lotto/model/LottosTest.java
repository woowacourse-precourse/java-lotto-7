package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 모든_로또_번호를_문자열로_변환한다() {
        Lottos lottos = Lottos.createLottos(2);
        String lottosString = lottos.allLottosToString();

        assertThat(lottosString).isNotNull();
        assertThat(lottosString.split(System.lineSeparator())).hasSize(2);
    }
}
