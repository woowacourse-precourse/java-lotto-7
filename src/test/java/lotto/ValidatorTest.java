package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 문자가_포함된_구입_금액을_입력_받으면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천_단위_이하의_숫자가_포함된_구입_금액을_입력_받으면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_양수가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_0인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_입력되지_않은_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6개_보다_적은_경우_예외가_발생한다() {
        String[] winningLottoInput = new String[]{ "1", "2", "3", "4", "5" };
        assertThatThrownBy(() -> Validator.validateWinningLottoInputLength(winningLottoInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6개_보다_많은_경우_예외가_발생한다() {
        String[] winningLottoInput = new String[]{ "1", "2", "3", "4", "5", "6", "7" };
        assertThatThrownBy(() -> Validator.validateWinningLottoInputLength(winningLottoInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_번호가_6개_보다_적은_경우_예외가_발생한다() {
        List<Integer> winningLottoInput = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> Validator.validateLottoNumbers(winningLottoInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_번호가_6개_보다_많은_경우_예외가_발생한다() {
        List<Integer> winningLottoInput = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> Validator.validateLottoNumbers(winningLottoInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
