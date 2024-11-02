package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @DisplayName("당첨 번호 추첨시 기본 6개와 보너스 숫자를 뽑는다.")
    @Test
    void 당첨_번호_추첨시_기본_6개와_보너스_숫자를_뽑는다(){
        WinningLotto winningLotto = new WinningLotto();

        assertThat(winningLotto.getNumbers()).hasSize(LOTTO_MAX_NUMBER.getUnit());
        assertThat(winningLotto.getBonusNumber()).isInstanceOf(Integer.class);
    }
}