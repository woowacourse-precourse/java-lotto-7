package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 당첨번호가_6개가_아니면_예외처리() {

        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호중에_빈문자열이_존재하면_예외처리() {

        assertThatThrownBy(() -> new WinningNumbers("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_자연수가_아니면_예외처리() {

        assertThatThrownBy(() -> new WinningNumbers("1,2,3,aa,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_로또숫자_범위를_벗어나면_예외처리() {

        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호에_중복이_존재하면_예외처리() {

        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}