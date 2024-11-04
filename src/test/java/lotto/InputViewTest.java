package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class InputViewTest {
    @Test
    void 구입_금액이_천원_단위로_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_형식의_당첨_번호를_입력받는다() {
        List<Integer> winningNumbers = InputView.parseWinningNumbers("1,2,3,4,5,6");

        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 잘못된_형식의_당첨_번호를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.parseWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputView.parseWinningNumbers("1,2,3,4,5,abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
