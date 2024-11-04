package lotto.domain;

import lotto.TestConstants;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @Test
    void 당첨_번호_보너스_번호_생성_테스트() {
        Lotto winningLottoNumbers = new Lotto(TestConstants.VALID_WINNING_NUMBERS);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, TestConstants.VALID_BONUS_NUMBER);

        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(TestConstants.EXPECTED_WINNING_NUMBERS);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(TestConstants.EXPECTED_BONUS_NUMBER);
    }
}
