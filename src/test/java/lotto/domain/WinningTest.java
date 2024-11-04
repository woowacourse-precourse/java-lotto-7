package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    void 유효한_입력으로_당첨_로또가_생성된다() {
        Winning winning = new Winning("1,2,3,4,5,6");
        Lotto lotto = winning.getLotto();
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 입력이_유효하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Winning("1,2,3,4,5,abc"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 입력이_콤마로_구분되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Winning("1;2;3;4;5;6"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 입력이_빈_문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Winning(""))
                .isInstanceOf(NumberFormatException.class);
    }
}