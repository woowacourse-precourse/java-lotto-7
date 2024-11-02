package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private static final List<Integer> VALID_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int VALID_BONUS_NUMBER = 7;

    @Test
    void 당첨_번호_보너스_번호_생성_테스트() {
        WinningLotto winningLotto = new WinningLotto(VALID_WINNING_NUMBERS, VALID_BONUS_NUMBER);
        assertThat(winningLotto.getWinningLotto().getNumbers()).isEqualTo(VALID_WINNING_NUMBERS);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(VALID_BONUS_NUMBER);
    }
}
