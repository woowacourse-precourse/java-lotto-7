package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("금액만큼 로또 개수 생성 테스트")
    void constructLottos(){
        //given
        int count = 5000;
        //when
        Lottos lottos = Lottos.of(count);
        //then
        Assertions.assertThat(lottos.lottos.size()).isEqualTo(count);
    }

}