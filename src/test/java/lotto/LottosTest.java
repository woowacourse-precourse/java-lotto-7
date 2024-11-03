package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("여러 개의 로또를 생성한다.")
    @Test
    void newLottosTest() {
        int lottoCount = 2;

        Lottos lottos = new Lottos(2);

//        assertThat(lottos).isEqualTo(lottos);
    }
}
