package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 로또생성() {
        //given
        int count = 10;

        //when
        Lottos lottos = new Lottos(count);

        //then
        assertThat(lottos.get()).hasSize(10);
        assertThat(lottos.getSize()).isEqualTo(10);
    }

}