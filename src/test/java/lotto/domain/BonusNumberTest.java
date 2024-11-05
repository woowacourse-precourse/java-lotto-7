package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 보너스번호가_자연수_아니면_예외처리() {

        WinningNumbers testWinningNumbers = new WinningNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("abc", testWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_로또숫자_범위를_벗어나면_예외처리() {

        WinningNumbers testWinningNumbers = new WinningNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("47", testWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외처리() {

        WinningNumbers testWinningNumbers = new WinningNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("6", testWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}