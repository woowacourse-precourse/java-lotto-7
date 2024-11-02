package lotto;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    void 당첨번호가_6개가_아니면_예외가_발생한다() {
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5); // 5개만 넣어봄

        assertThatThrownBy(() -> new WinningNumbers(invalidWinningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_중복되면_예외가_발생한다() {
        List<Integer> duplicateWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5); // 중복된 번호 5

        assertThatThrownBy(() -> new WinningNumbers(duplicateWinningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 5; // 당첨 번호에 포함된 번호

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호와_보너스번호가_정상적인_경우_객체가_생성된다() {
        List<Integer> validWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(validWinningNumbers, validBonusNumber);

        assertThat(winningNumbers).isNotNull();
    }


}
