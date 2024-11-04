package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    @DisplayName("로또를 구매한 개수 만클 로또가 생성되는지 확인하기")
    public void 로또_구입_성공_테스트() {
        Lottos lottos = new Lottos(5);
        assertThat(lottos.lottos.size()).isEqualTo(5);
    }
}