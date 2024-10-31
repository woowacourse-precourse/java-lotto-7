package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoBonusNumberValidatorTest {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private final LottoBonusNumberValidator lottoBonusNumberValidator;

    public LottoBonusNumberValidatorTest() {
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
        this.lottoBonusNumberValidator = new LottoBonusNumberValidator(lottoNumberValidator);
    }

    @Test
    public void 보너스_번호가_숫자가_아닌값이_포함되어있다면_예외가_발생한다() {
        String bonusNumber = "12,";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lottoBonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호가_로또_번호_조건을_만족하지못한다면_예외가_발생한다() {
        String bonusNumber = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lottoBonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호가_당첨_번호에_포함된_숫자라면_예외가_발생한다() {
        String bonusNumber = "6";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lottoBonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
