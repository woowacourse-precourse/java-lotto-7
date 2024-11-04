package lotto.lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("LottoWinning객체를 생성한다.")
    void createLottoWinningTest() {
        //given
        int bonusNumber = 10;

        // when
        LottoWinning lottoWinning = LottoWinning.of(lotto, bonusNumber);

        // then
        Assertions.assertThat(lottoWinning.getLotto()).isEqualTo(lotto);
        Assertions.assertThat(lottoWinning.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("bonusnumber가 1과 45사이의 정수가 아니라면 IllegalArgumentException을 던진다")
    void bonusNumberOutboundExceptionTest() {
        // given
        int bonusNumber = 100;

        Assertions.assertThatThrownBy(() -> LottoWinning.of(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("bonusNumber가 lotto 번호와 중복된다면 IllegalArgumentException을 던진다")
    void bonusNumberDuplicatedExceptionTest() {
        // given
        int bonusNumber = 1;

        Assertions.assertThatThrownBy(() -> LottoWinning.of(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}