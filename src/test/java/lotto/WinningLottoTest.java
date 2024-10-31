package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        String hasSevenElements = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> new WinningLotto(hasSevenElements))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_쉼표로_구분되지_않으면_예외가_발생한다() {
        String wrongNumber = "1,2,3'4,5,6";

        assertThatThrownBy(() -> new WinningLotto(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_수가_있으면_예외가_발생한다() {
        String wrongNumber = "1,1,3,4,5,6";

        assertThatThrownBy(() -> new WinningLotto(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1에서_45사이가_아닌_경우_예외가_발생한다() {
        String wrongNumber1 = "1,10,30,40,50,60";
        String wrongNumber2 = "0,10,30,40,50,60";

        assertThatThrownBy(() -> new WinningLotto(wrongNumber1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(wrongNumber2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
