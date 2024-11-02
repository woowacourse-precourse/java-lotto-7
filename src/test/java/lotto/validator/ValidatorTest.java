package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 숫자_형식이_아니면_예외가_발생한다() {
        assertThatThrownBy(()-> Validator.validateNumeric("하나"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(()-> Validator.validateAmountUnit(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨로또번호_개수가_6이_아니면_예외가_발생한다() {
        List<Integer> winningLotto = new ArrayList<>();
        winningLotto.add(1);
        winningLotto.add(2);
        winningLotto.add(3);

        assertThatThrownBy(()-> Validator.validateLottoNumberCount(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨로또번호가_중복되면_예외가_발생한다() {
        List<Integer> winningLotto = new ArrayList<>();
        winningLotto.add(1);
        winningLotto.add(2);
        winningLotto.add(3);
        winningLotto.add(3);
        winningLotto.add(4);
        winningLotto.add(5);

        assertThatThrownBy(()-> Validator.validateLottoDuplicate(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자가_콤마가_아닌_다른_문자이면_예외가_발생한다() {
        String input = "1*2,3,4,5,6";

        assertThatThrownBy(()-> Validator.validateInputWinningNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자가_콤마가_아닌_다른_문자이면_예외가_발생한다2() {
        String input = "1 2,3,4,5,6";

        assertThatThrownBy(()-> Validator.validateInputWinningNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백문자가_있으면_예외가_발생한다() {
        String input = "1,2,3,4,5,6 ";

        assertThatThrownBy(()-> Validator.validateInputWinningNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
