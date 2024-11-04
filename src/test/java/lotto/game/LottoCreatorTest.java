package lotto.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCreatorTest {
    @DisplayName("구매한 로또 개수만큼 로또를 생성한다.")
    @Test
    void getLottoPrize() {
        // given
        LottoCreator lottoCreator = new LottoCreator();
        int LottoCount = 9;

        // when
        Lottos lottos = lottoCreator.createLottos(LottoCount);

        // then
        assertThat(lottos.getSize()).isEqualTo(LottoCount);
    }
}