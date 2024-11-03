package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    void 당첨번호_생성_성공() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        assertThat(winningLotto.getWinningNumbers().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 당첨번호는_6개이어야_한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    void 당첨번호는_숫자여야_한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,a", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다.");
    }

    @Test
    void 당첨번호는_중복되지_않아야_한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,5", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    void 보너스번호는_숫자여야_한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @Test
    void 보너스번호는_1부터_45사이의_숫자여야_한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다");

        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다");
    }

    @Test
    void 보너스번호는_당첨번호와_중복되지_않아야_한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

}