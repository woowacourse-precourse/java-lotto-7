package lotto;

import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class WinningNumbersTest {

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 3, 3, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6개가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_1에서_45사이가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
