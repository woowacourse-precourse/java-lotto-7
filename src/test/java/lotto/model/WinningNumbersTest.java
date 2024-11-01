package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 로또_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 6;
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(validNumbers), duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 보너스_번호가_숫자범위를_벗어나면_예외가_발생한다() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 47;
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(validNumbers), duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}