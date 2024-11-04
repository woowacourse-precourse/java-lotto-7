package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 구입_금액_1000원_단위일_경우() {
        int result = InputView.validatePurchase("7000");
        assertThat(result).isEqualTo(7);
    }

    @Test
    void 구입_금액_1000원_단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validatePurchase("7700"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_숫자로만_구성되지_않을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validatePurchase("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 당첨_번호가_올바른_형식일_경우() {
        List<Integer> winNumber = InputView.validateWinNumber("1,2,3,4,5,6");
        assertThat(winNumber).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨_번호에_문자가_포함된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validateWinNumber("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_쉼표로_구분하지_않은_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validateWinNumber("1,2,3,4,5.6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자인_경우() {
        int BonusNumber = InputView.validateBonusNumber("7");
        assertThat(BonusNumber).isEqualTo(7);
    }

    @Test
    void 보너스_번호가_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validateBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}