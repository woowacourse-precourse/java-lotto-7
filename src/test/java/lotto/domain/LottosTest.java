package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 리스트 테스트")
class LottosTest {
    @Test
    @DisplayName("로또 리스트 객체 생성")
    void createLottos() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(Lottos.from(List.of(lotto))).isInstanceOf(Lottos.class);
    }
}
